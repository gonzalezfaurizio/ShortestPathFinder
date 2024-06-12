package com.shortestpathfinder.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import com.shortestpathfinder.dao.MazeDAO;
import com.shortestpathfinder.model.Maze;
import com.shortestpathfinder.utils.FileUtils;
import com.shortestpathfinder.utils.JsonUtils;
import com.google.gson.JsonSyntaxException;
import com.shortestpathfinder.ui.SelectMaze;

/**
 * Controller class for handling actions related to the selection and uploading
 * of mazes. Implements ActionListener to respond to button events in the
 * SelectMaze view.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class MazeController implements ActionListener {

    /**
     * The view associated with this controller.
     */
    private SelectMaze view;

    /**
     * Data Access Object for managing Maze objects.
     */
    private MazeDAO mazeDAO;

    /**
     * Constructs a new MazeController with the specified view and DAO. Adds
     * action listeners to the upload maze and back buttons in the view.
     *
     * @param view the SelectMaze view associated with this controller.
     * @param mazeDAO the DAO for managing Maze objects.
     */
    public MazeController(SelectMaze view, MazeDAO mazeDAO) {
        this.view = view;
        this.mazeDAO = mazeDAO;
        view.getUploadMazeButton().addActionListener(this);
        view.getBackButton().addActionListener(this);
    }

    /**
     * Handles action events triggered by the view. Disposes the view if the
     * back button is pressed.
     *
     * @param e the ActionEvent triggered by a user action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.getUploadMazeButton()) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(view);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                if (FileUtils.isValidJsonFile(selectedFile)) {
                    try {
                        if (JsonUtils.validateJsonStructure(selectedFile.getAbsolutePath())) {
                            Maze maze = JsonUtils.fromJson(selectedFile.getAbsolutePath(), Maze.class);
                            mazeDAO.addMaze(maze);
                            JOptionPane.showMessageDialog(view, "Maze uploaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(view, "Invalid maze format. Please upload a correctly formatted JSON file.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IOException | JsonSyntaxException ex) {
                        JOptionPane.showMessageDialog(view, "Error uploading maze: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Invalid file format. Please upload a JSON file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == view.getBackButton()) {
            view.dispose();
        }
    }

    /**
     * Makes the view visible.
     */
    public void showView() {
        view.setVisible(true);
    }
}
