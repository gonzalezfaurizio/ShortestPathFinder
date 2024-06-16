package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Panel class for displaying a maze and its solution path. Extends JPanel to
 * provide custom painting of the maze and path.
 *
 * @version 1.1
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
     * List to store the coordinates of the solution path points.
     */
    private List<Point> pathPoints;

    /**
     * The current step in the path being displayed.
     */
    private int currentStep;

    /**
     * Timer for updating the display.
     */
    private Timer timer;

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
        setPreferredSize(new Dimension(cols * (cellSize / 2), rows * (cellSize / 2)));

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

        // Store the path points in a list
        pathPoints = new ArrayList<>();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                if (path[i][j] > 0) {
                    pathPoints.add(new Point(i, j));
                }
            }
        }
        pathPoints.sort((p1, p2) -> Integer.compare(path[p1.x][p1.y], path[p2.x][p2.y]));

        // Initialize the timer to update the display every second
        currentStep = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentStep < pathPoints.size()) {
                    currentStep++;
                    repaint();
                } else {
                    timer.stop();
                }
            }
        });
        timer.start();
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
            }
        }

        // Draw the path points
        g.setColor(Color.GRAY); // Set color for the path points
        for (int k = 0; k < currentStep; k++) {
            Point p = pathPoints.get(k);
            int i = p.x;
            int j = p.y;

            if (i == startX && j == startY) {
                g.setColor(Color.GRAY); // Starting point
            } else if (i == endX && j == endY) {
                g.setColor(Color.GRAY); // Ending point
            } else {
                g.setColor(Color.GRAY); // Path points
            }
            g.fillOval(j * cellSize + cellSize / 4, i * cellSize + cellSize / 4, cellSize / 2, cellSize / 2);
        }
    }
}
