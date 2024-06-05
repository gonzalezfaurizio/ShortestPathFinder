package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;

public class MazeDisplayPanel extends JPanel {

    private char[][] maze;
    private int[][] path;
    private int cellSize;
    private int startX, startY, endX, endY;

    public MazeDisplayPanel(char[][] maze, int[][] path, int panelWidth, int panelHeight) {
        this.maze = maze;
        this.path = path;
        int rows = maze.length;
        int cols = maze[0].length;
        this.cellSize = Math.min(panelWidth / cols, panelHeight / rows);
        setPreferredSize(new Dimension(cols * cellSize, rows * cellSize));

        // Identify start and end points
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (maze[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int rows = maze.length;
        int cols = maze[0].length;

        // Find the maximum steps value in the path
        int maxSteps = 0;
        for (int[] row : path) {
            for (int cell : row) {
                if (cell > maxSteps) {
                    maxSteps = cell;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == 'X') {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);

                if (path[i][j] > 0) {
                    if (i == startX && j == startY) {
                        g.setColor(Color.BLUE); // Starting point
                    } else if (i == endX && j == endY) {
                        g.setColor(Color.RED); // Ending point
                    } else {
                        int steps = path[i][j];
                        float ratio = (float) steps / maxSteps;
                        g.setColor(new Color(ratio, 0.0f, 1.0f - ratio)); // Gradient from blue to red
                    }
                    g.fillOval(j * cellSize + cellSize / 4, i * cellSize + cellSize / 4, cellSize / 2, cellSize / 2);
                }
            }
        }
    }
}
