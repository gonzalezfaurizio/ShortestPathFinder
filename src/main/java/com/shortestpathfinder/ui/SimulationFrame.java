package com.shortestpathfinder.ui;

import com.shortestpathfinder.algorithms.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Frame class for displaying a maze and its solution paths using different
 * algorithms. Extends JFrame and implements ActionListener to handle button
 * events.
 *
 * @version 1.0
 * @since 2024-06-26
 *
 * Displays a maze and its solution paths generated by Breadth-First Search and
 * A* Algorithm. Provides a back button to return to the previous menu.
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class SimulationFrame extends JFrame implements ActionListener {

    /**
     * Panel for displaying the maze with Breadth-First Search path.
     */
    private JPanel panel1;

    /**
     * Panel for displaying the maze with A* Algorithm path.
     */
    private JPanel panel2;

    /**
     * Label indicating the algorithm used for the first panel.
     */
    private JLabel algorithmLabel1;

    /**
     * Label indicating the algorithm used for the second panel.
     */
    private JLabel algorithmLabel2;

    /**
     * Label indicating the best algorithm based on the number of steps.
     */
    private JLabel bestAlgorithmLabel;

    /**
     * Label indicating the number of steps for Breadth-First Search.
     */
    private JLabel bfsStepsLabel;

    /**
     * Label indicating the number of steps for A* Algorithm.
     */
    private JLabel aStarStepsLabel;

    /**
     * Button to go back to the previous menu.
     */
    private JButton backButton;

    /**
     * 2D character array representing the maze.
     */
    private char[][] maze;

    /**
     * 2D integer array representing the path found by Breadth-First Search.
     */
    private int[][] bfsPath;

    /**
     * 2D integer array representing the path found by A* Algorithm.
     */
    private int[][] aStarPath;

    /**
     * Constructs a new SimulationFrame. Initializes the frame with the provided
     * maze and sets up the UI components.
     *
     * @param maze the 2D character array representing the maze.
     */
    public SimulationFrame(char[][] maze) {
        this.maze = maze;
        this.bfsPath = new BreadthFirstSearch().findPath(maze);
        this.aStarPath = new AStarAlgorithm().findPath(maze);

        setTitle("Maze Simulation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(0, 0));

        initUI();
        setVisible(true);
    }

    /**
     * Initializes the UI components of the frame.
     */
    private void initUI() {
        // Main display panel setup
        JPanel displayPanel = new JPanel(new GridLayout(2, 2, 0, 0));

        // Panels for maze display
        panel1 = new MazeDisplayPanel(maze, bfsPath, 150, 150);
        panel2 = new MazeDisplayPanel(maze, aStarPath, 150, 150);

        JScrollPane scrollPane1 = new JScrollPane(panel1);
        JScrollPane scrollPane2 = new JScrollPane(panel2);

        // Algorithm labels
        algorithmLabel1 = new JLabel("Algorithm: Breadth-First Search", SwingConstants.CENTER);
        algorithmLabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
        bfsStepsLabel = new JLabel("BFS Steps: " + countSteps(bfsPath), SwingConstants.CENTER);
        bfsStepsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

        algorithmLabel2 = new JLabel("Algorithm: A* Algorithm", SwingConstants.CENTER);
        algorithmLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
        aStarStepsLabel = new JLabel("A* Steps: " + countSteps(aStarPath), SwingConstants.CENTER);
        aStarStepsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

        // Best algorithm label
        bestAlgorithmLabel = new JLabel("", SwingConstants.CENTER);
        bestAlgorithmLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        determineBestAlgorithm();

        // Adding components to display panel
        JPanel panel1Container = new JPanel(new BorderLayout());
        panel1Container.add(algorithmLabel1, BorderLayout.NORTH);
        panel1Container.add(scrollPane1, BorderLayout.CENTER);
        panel1Container.add(bfsStepsLabel, BorderLayout.SOUTH);

        JPanel panel2Container = new JPanel(new BorderLayout());
        panel2Container.add(algorithmLabel2, BorderLayout.NORTH);
        panel2Container.add(scrollPane2, BorderLayout.CENTER);
        panel2Container.add(aStarStepsLabel, BorderLayout.SOUTH);

        displayPanel.add(panel1Container);
        displayPanel.add(panel2Container);

        // Button panel setup
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
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
        buttonPanel.add(backButton);

        // Adding panels to the frame
        add(displayPanel, BorderLayout.CENTER);
        add(bestAlgorithmLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Determines which algorithm found the shortest path and updates the label.
     */
    private void determineBestAlgorithm() {
        int bfsSteps = countSteps(bfsPath);
        int aStarSteps = countSteps(aStarPath);

        if (bfsSteps < aStarSteps) {
            bestAlgorithmLabel.setText("Best Algorithm: Breadth-First Search with " + bfsSteps + " steps");
        } else if (aStarSteps < bfsSteps) {
            bestAlgorithmLabel.setText("Best Algorithm: A* Algorithm with " + aStarSteps + " steps");
        } else {
            bestAlgorithmLabel.setText("Both algorithms have the same number of steps: " + bfsSteps);
        }
    }

    /**
     * Counts the number of steps in the given path.
     *
     * @param path the 2D integer array representing the path.
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
        return steps * 2;
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
