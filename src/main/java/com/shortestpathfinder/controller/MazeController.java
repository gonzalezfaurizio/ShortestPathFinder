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

public class MazeController implements ActionListener {

    private SelectMaze view;
    private MazeDAO mazeDAO;

    public MazeController(SelectMaze view, MazeDAO mazeDAO) {
        this.view = view;
        this.mazeDAO = mazeDAO;
        view.getUploadMazeButton().addActionListener(this);

        view.getBackButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.getUploadMazeButton()) {

            JFileChooser fileChooser = new JFileChooser();

            int result = fileChooser.showOpenDialog(view);

            if (result == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();

                if (FileUtils.isValidJsonFile(selectedFile)) {
                    try {
                        Maze maze = JsonUtils.fromJson(selectedFile.getAbsolutePath(), Maze.class);
                        mazeDAO.addMaze(maze);
                        JOptionPane.showMessageDialog(view, "Maze uploaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
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

    public void showView() {
        view.setVisible(true);
    }
}
