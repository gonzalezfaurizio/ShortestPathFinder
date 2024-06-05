package com.shortestpathfinder.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.shortestpathfinder.dao.*;
import com.shortestpathfinder.model.*;
import com.shortestpathfinder.ui.*;
import com.shortestpathfinder.algorithms.*;

public class GameController implements ActionListener {

    private StartGame view;
    private MazeDAO mazeDAO;
    private PlayerDAO playerDAO;
    private GameDAO gameDAO;
    private HallOfFameDAO hallOfFameDAO;
    private Game currentGame;
    private PathfindingAlgorithm selectedAlgorithm;

    public GameController(StartGame view, MazeDAO mazeDAO, PlayerDAO playerDAO, GameDAO gameDAO, HallOfFameDAO hallOfFameDAO) {
        this.view = view;
        this.mazeDAO = mazeDAO;
        this.playerDAO = playerDAO;
        this.gameDAO = gameDAO;
        this.hallOfFameDAO = hallOfFameDAO;
        view.getSelectMazeButton().addActionListener(this);
        view.getSelectPlayerButton().addActionListener(this);
        view.getSelectAlgorithmButton().addActionListener(this);
        view.getDisplayPathButton().addActionListener(this);
        view.getBackButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSelectMazeButton()) {
            handleSelectMaze();
        } else if (e.getSource() == view.getSelectPlayerButton()) {
            handleSelectPlayer();
        } else if (e.getSource() == view.getSelectAlgorithmButton()) {
            handleSelectAlgorithm();
        } else if (e.getSource() == view.getDisplayPathButton()) {
            handleDisplayPath();
        } else if (e.getSource() == view.getBackButton()) {
            view.dispose();
        }
    }

    private void handleSelectMaze() {
        List<Maze> mazes = mazeDAO.getAllMazes();
        if (mazes.isEmpty()) {
            JOptionPane.showMessageDialog(view, "No mazes available. Please upload a maze first.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        new MazePreviewFrame(mazes, e -> {
            Maze selectedMaze = ((MazePreviewFrame) e.getSource()).getSelectedMaze();
            if (selectedMaze != null) {
                if (currentGame == null) {
                    currentGame = new Game(null, selectedMaze);
                } else {
                    currentGame.setMaze(selectedMaze);
                }
                JOptionPane.showMessageDialog(view, "Maze selected: " + selectedMaze.getName(), "Maze Selected", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void handleSelectPlayer() {
        List<Player> players = playerDAO.getAllPlayers();
        if (players.isEmpty()) {
            JOptionPane.showMessageDialog(view, "No players available. Please create a player first.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String[] playerNames = players.stream().map(Player::getName).toArray(String[]::new);
        String selectedPlayer = (String) JOptionPane.showInputDialog(view, "Select a player", "Player Selection", JOptionPane.PLAIN_MESSAGE, null, playerNames, playerNames[0]);
        if (selectedPlayer != null) {
            Player player = players.stream().filter(p -> p.getName().equals(selectedPlayer)).findFirst().orElse(null);
            if (player != null) {
                if (currentGame == null) {
                    currentGame = new Game(player, null);
                } else {
                    currentGame.setPlayer(player);
                }
                JOptionPane.showMessageDialog(view, "Player selected: " + player.getName(), "Player Selected", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void handleSelectAlgorithm() {
        String[] algorithms = {"BreadthFirstSearch", "DepthFirstSearch", "FloodFillAlgorithm", "FullMazeTraversal", "AStarAlgorithm"};
        String selectedAlgorithmName = (String) JOptionPane.showInputDialog(view, "Select an algorithm", "Algorithm Selection", JOptionPane.PLAIN_MESSAGE, null, algorithms, algorithms[0]);
        if (selectedAlgorithmName != null) {
            switch (selectedAlgorithmName) {
                case "BreadthFirstSearch":
                    selectedAlgorithm = new BreadthFirstSearch();
                    break;
                case "DepthFirstSearch":
                    selectedAlgorithm = new DepthFirstSearch();
                    break;
                case "FloodFillAlgorithm":
                    selectedAlgorithm = new FloodFillAlgorithm();
                    break;
                case "FullMazeTraversal":
                    selectedAlgorithm = new FullMazeTraversal();
                    break;
                case "AStarAlgorithm":
                    selectedAlgorithm = new AStarAlgorithm();
                    break;
                default:
                    selectedAlgorithm = null;
                    break;
            }
            if (currentGame != null) {
                currentGame.setAlgorithmUsed(selectedAlgorithmName);
                JOptionPane.showMessageDialog(view, "Algorithm selected: " + selectedAlgorithmName, "Algorithm Selected", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void handleDisplayPath() {
        if (currentGame == null || currentGame.getPlayer() == null || currentGame.getMaze() == null || selectedAlgorithm == null) {
            JOptionPane.showMessageDialog(view, "Please select a maze, player, and algorithm first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simulate finding the path using the selected algorithm
        char[][] mazeGrid = currentGame.getMaze().getGrid();
        int[][] path = selectedAlgorithm.findPath(mazeGrid);

        if (path != null) {
            currentGame.setCompleted(true);
            int steps = countSteps(path);
            currentGame.setCurrentSteps(steps);
            gameDAO.addGame(currentGame);
            hallOfFameDAO.addFameRecord(new FameRecord(currentGame.getPlayer().getName(), currentGame.getMaze().getName(), steps, currentGame.getAlgorithmUsed()));
            JOptionPane.showMessageDialog(view, "Path found and game completed! " + currentGame, "Game Completed", JOptionPane.INFORMATION_MESSAGE);

            // Display the path graphically
            new MazeDisplayFrame(mazeGrid, path);
        } else {
            JOptionPane.showMessageDialog(view, "No path found using the selected algorithm.", "No Path Found", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private int countSteps(int[][] path) {
        int steps = 0;
        for (int[] row : path) {
            for (int cell : row) {
                if (cell > 0) {
                    steps++;
                }
            }
        }
        return steps;
    }

    public void showView() {
        view.setVisible(true);
    }
}
