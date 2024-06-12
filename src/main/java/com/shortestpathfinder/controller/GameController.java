package com.shortestpathfinder.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.shortestpathfinder.dao.*;
import com.shortestpathfinder.model.*;
import com.shortestpathfinder.ui.*;
import com.shortestpathfinder.algorithms.*;

/**
 * Controller class for handling game-related actions in the application.
 * Implements ActionListener to respond to events in the StartGame view.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class GameController implements ActionListener {

    /**
     * The view associated with this controller.
     */
    private StartGame view;

    /**
     * Data Access Object for managing Maze objects.
     */
    private MazeDAO mazeDAO;

    /**
     * Data Access Object for managing Player objects.
     */
    private PlayerDAO playerDAO;

    /**
     * Data Access Object for managing Game objects.
     */
    private GameDAO gameDAO;

    /**
     * Data Access Object for managing Hall of Fame records.
     */
    private HallOfFameDAO hallOfFameDAO;

    /**
     * The current game instance being managed by this controller.
     */
    private Game currentGame;

    /**
     * The pathfinding algorithm selected for the game.
     */
    private PathfindingAlgorithm selectedAlgorithm;

    /**
     * Constructs a new GameController with the specified view and DAOs.
     * Initializes the controller with references to the view and data access
     * objects.
     *
     * @param view the StartGame view associated with this controller.
     * @param mazeDAO the DAO for managing Maze objects.
     * @param playerDAO the DAO for managing Player objects.
     * @param gameDAO the DAO for managing Game objects.
     * @param hallOfFameDAO the DAO for managing Hall of Fame records.
     */
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

    /**
     * Handles action events triggered by the view.
     *
     * @param e the ActionEvent triggered by a user action.
     */
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

    /**
     * Handles the selection of a maze.
     */
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

    /**
     * Handles the selection of a player.
     */
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

    /**
     * Handles the selection of a pathfinding algorithm.
     */
    private void handleSelectAlgorithm() {
        String[] algorithms = {"BreadthFirstSearch", "DepthFirstSearch", "AStarAlgorithm"};
        String selectedAlgorithmName = (String) JOptionPane.showInputDialog(view, "Select an algorithm", "Algorithm Selection", JOptionPane.PLAIN_MESSAGE, null, algorithms, algorithms[0]);
        if (selectedAlgorithmName != null) {
            switch (selectedAlgorithmName) {
                case "BreadthFirstSearch":
                    selectedAlgorithm = new BreadthFirstSearch();
                    break;
                case "DepthFirstSearch":
                    selectedAlgorithm = new DepthFirstSearch();
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

    /**
     * Handles the display of the path found by the algorithm.
     */
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

    /**
     * Counts the number of steps in the provided path.
     *
     * @param path the path represented as a 2D array of coordinates.
     * @return the number of steps in the path.
     */
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

    /**
     * Makes the view visible.
     */
    public void showView() {
        view.setVisible(true);
    }
}
