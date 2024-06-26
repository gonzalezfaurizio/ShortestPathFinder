package com.shortestpathfinder.ui;

import com.shortestpathfinder.algorithms.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimulationFrame extends JFrame implements ActionListener {

    private JPanel panel1;
    private JPanel panel2;
    private JLabel algorithmLabel1;
    private JLabel algorithmLabel2;
    private JLabel bestAlgorithmLabel;
    private JButton backButton;
    private char[][] maze;
    private int[][] bfsPath;
    private int[][] aStarPath;

    public SimulationFrame(char[][] maze) {
        this.maze = maze;
        this.bfsPath = new BreadthFirstSearch().findPath(maze);
        this.aStarPath = new AStarAlgorithm().findPath(maze);

        setTitle("Maze Simulation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel displayPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        panel1 = new MazeDisplayPanel(maze, bfsPath, 150, 150);
        panel2 = new MazeDisplayPanel(maze, aStarPath, 150, 150);

        JScrollPane scrollPane1 = new JScrollPane(panel1);
        JScrollPane scrollPane2 = new JScrollPane(panel2);

        displayPanel.add(scrollPane1);
        displayPanel.add(scrollPane2);

        algorithmLabel1 = new JLabel("Algorithm: BreadthFirstSearch", SwingConstants.CENTER);
        algorithmLabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
        algorithmLabel2 = new JLabel("Algorithm: AStarAlgorithm", SwingConstants.CENTER);
        algorithmLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
        bestAlgorithmLabel = new JLabel("", SwingConstants.LEFT);
        bestAlgorithmLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        determineBestAlgorithm();

        displayPanel.add(algorithmLabel1);
        displayPanel.add(algorithmLabel2);

        infoPanel.add(bestAlgorithmLabel);

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

        add(displayPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void determineBestAlgorithm() {
        int bfsSteps = countSteps(bfsPath);
        int aStarSteps = countSteps(aStarPath);

        if (bfsSteps < aStarSteps) {
            bestAlgorithmLabel.setText("Best Algorithm: BreadthFirstSearch with " + bfsSteps + " steps");
        } else if (aStarSteps < bfsSteps) {
            bestAlgorithmLabel.setText("Best Algorithm: AStarAlgorithm with " + aStarSteps + " steps");
        } else {
            bestAlgorithmLabel.setText("Both algorithms have the same number of steps: " + bfsSteps);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
        }
    }
}
