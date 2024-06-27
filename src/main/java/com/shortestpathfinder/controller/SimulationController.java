package com.shortestpathfinder.controller;

import com.shortestpathfinder.dao.MazeDAO;
import com.shortestpathfinder.model.Maze;
import com.shortestpathfinder.ui.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

/**
 * Controller for managing the simulation view and handling user interactions.
 *
 * @version 1.0
 * @since 2024-06-26
 *
 * Manages actions related to selecting a maze and displaying the simulation. It
 * coordinates between the view and the maze data access object (DAO).
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class SimulationController implements ActionListener {

    /**
     * The view for the simulation.
     */
    private Simulation view;

    /**
     * Data access object for maze-related operations.
     */
    private MazeDAO mazeDAO;

    /**
     * The currently selected maze for simulation.
     */
    private char[][] selectedMaze;

    /**
     * Constructs a new SimulationController with the specified view and maze
     * DAO.
     *
     * @param view the simulation view
     * @param mazeDAO the data access object for maze-related operations
     */
    public SimulationController(Simulation view, MazeDAO mazeDAO) {
        this.view = view;
        this.mazeDAO = mazeDAO;
        view.getSelectMazeButton().addActionListener(this);
        view.getDisplaySimulationButton().addActionListener(this);
        view.getBackButton().addActionListener(this);
    }

    /**
     * Handles action events triggered by the user in the simulation view.
     *
     * @param e the action event
     */
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

    /**
     * Handles the selection of a maze by the user. Opens a new frame to preview
     * available mazes and allows the user to select one. Displays a message if
     * no mazes are available.
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
                this.selectedMaze = selectedMaze.getGrid();
                JOptionPane.showMessageDialog(view, "Maze selected: " + selectedMaze.getName(), "Maze Selected", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    /**
     * Handles the display of the simulation. Opens a new frame to run the
     * simulation on the selected maze. Displays an error message if no maze has
     * been selected.
     */
    private void handleDisplaySimulation() {
        if (selectedMaze == null) {
            JOptionPane.showMessageDialog(view, "Please select a maze first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new SimulationFrame(selectedMaze);
    }

    /**
     * Makes the simulation view visible.
     */
    public void showView() {
        view.setVisible(true);
    }
}
