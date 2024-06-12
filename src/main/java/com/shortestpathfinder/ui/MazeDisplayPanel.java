package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Panel class for displaying a maze and its solution path. Extends JPanel to
 * provide custom painting of the maze and path.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class MazeDisplayPanel extends JPanel {

    /**
     * The 2D character array representing the maze.
     */
    private char[][] maze;

    /**
     * The 2D integer array representing the solution path.
     */
    private int[][] path;

    /**
     * The size of each cell in the maze.
     */
    private int cellSize;

    /**
     * The starting coordinates of the maze.
     */
    private int startX, startY;

    /**
     * The ending coordinates of the maze.
     */
    private int endX, endY;

    /**
     * Constructs a new MazeDisplayPanel with the specified maze, path, and
     * panel dimensions. Initializes the panel with the maze and path data.
     *
     * @param maze the 2D character array representing the maze.
     * @param path the 2D integer array representing the solution path.
     * @param panelWidth the width of the panel.
     * @param panelHeight the height of the panel.
     */
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

    /**
     * Paints the maze and its solution path on the panel. This method is called
     * automatically whenever the panel needs to be repainted.
     *
     * @param g the Graphics object used for painting.
     */
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
