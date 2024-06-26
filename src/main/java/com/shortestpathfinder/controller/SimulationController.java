/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shortestpathfinder.controller;

import com.shortestpathfinder.dao.MazeDAO;
import com.shortestpathfinder.model.Maze;
import com.shortestpathfinder.ui.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

public class SimulationController implements ActionListener {

    private Simulation view;
    private MazeDAO mazeDAO;
    private char[][] selectedMaze;

    public SimulationController(Simulation view, MazeDAO mazeDAO) {
        this.view = view;
        this.mazeDAO = mazeDAO;
        view.getSelectMazeButton().addActionListener(this);
        view.getDisplaySimulationButton().addActionListener(this);
        view.getBackButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSelectMazeButton()) {
            handleSelectMaze();
        } else if (e.getSource() == view.getDisplaySimulationButton()) {
            handleDisplaySimulation();
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
                this.selectedMaze = selectedMaze.getGrid();
                JOptionPane.showMessageDialog(view, "Maze selected: " + selectedMaze.getName(), "Maze Selected", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void handleDisplaySimulation() {
        if (selectedMaze == null) {
            JOptionPane.showMessageDialog(view, "Please select a maze first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new SimulationFrame(selectedMaze);
    }

    public void showView() {
        view.setVisible(true);
    }

}
