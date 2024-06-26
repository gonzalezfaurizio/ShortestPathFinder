package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Frame class for displaying a maze and its solution path. Extends JFrame and
 * implements ActionListener to handle button events.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class MazeDisplayFrame extends JFrame implements ActionListener {

    /**
     * The main panel containing the UI components.
     */
    private JPanel panel;

    /**
     * Button to go back to the previous menu.
     */
    private JButton backButton;

    /**
     * Constructs a new MazeDisplayFrame. Initializes the frame with the
     * provided maze and solution path.
     *
     * @param maze the 2D character array representing the maze.
     * @param path the 2D integer array representing the solution path.
     */
    public MazeDisplayFrame(char[][] maze, int[][] path) {
        setTitle("Maze Path Display");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        MazeDisplayPanel mazeDisplayPanel = new MazeDisplayPanel(maze, path, 425, 425);

        JScrollPane scrollPane = new JScrollPane(mazeDisplayPanel);

        scrollPane.setBounds(0, 0, 425, 425);
        getContentPane().add(scrollPane);

        // Back button
        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        backButton.setBounds(32, 500, 180, 39);
        getContentPane().add(backButton);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setBackground(new Color(231, 231, 231));
            }
        });
        backButton.addActionListener(this);
        backButton.setFocusable(false);

        // Panel with image
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Image path
        String imagePath = "resources/maze.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Handles action events triggered by the view. Disposes the frame if the
     * back button is pressed.
     *
     * @param e the ActionEvent triggered by a user action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
        }
    }
}
