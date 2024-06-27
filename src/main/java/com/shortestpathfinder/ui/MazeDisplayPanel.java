package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Panel class for displaying a maze and its solution path. Extends JPanel to
 * provide custom painting of the maze and path.
 *
 * @version 2.0
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
     * Indicates whether the animation is moving forward or backward.
     */
    private boolean forward;

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
        setPreferredSize(new Dimension(cols * (cellSize / 2) + 1, rows * (cellSize / 2) + 1));

        // Identify start and end points
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == 'S' || maze[i][j] == 'P') {
                    startX = i;
                    startY = j;
                } else if (maze[i][j] == 'E' || maze[i][j] == 'Z') {
                    endX = i;
                    endY = j;
                }
            }
        }

        // Store the path points in a list
        pathPoints = new ArrayList<>();
        findPath(new Point(startX, startY));

         // Initialize the timer to update the display every 500ms
        currentStep = 0;
        forward = true;
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (forward) {
                    if (currentStep < pathPoints.size()) {
                        currentStep++;
                    } else {
                        forward = false;
                        currentStep = 0;
                    }
                } else {
                    if (currentStep < pathPoints.size()) {
                        currentStep++;
                    } else {
                        timer.stop(); 
                    }
                }
                repaint();
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
            Point p = forward ? pathPoints.get(k) : pathPoints.get(pathPoints.size() - 1 - k);
            int i = p.x;
            int j = p.y;

            if (i == startX && j == startY) {
                g.setColor(Color.GREEN); // Starting point
            } else if (i == endX && j == endY) {
                g.setColor(Color.RED); // Ending point
            } else {
                g.setColor(Color.GRAY); // Path points
            }
            g.fillOval(j * cellSize + cellSize / 4, i * cellSize + cellSize / 4, cellSize / 2, cellSize / 2);
        }
    }

    /**
     * Finds a path from the current point to the end point using a
     * heuristic-based search algorithm. The found path is stored in the
     * pathPoints list.
     *
     * @param current the current point in the pathfinding process
     */
    private void findPath(Point current) {
        pathPoints.add(current);
        if (current.x == endX && current.y == endY) {
            return;
        }

        List<Point> neighbors = getValidNeighbors(current);
        neighbors.sort(Comparator.comparingInt(this::heuristic));

        for (Point neighbor : neighbors) {
            if (!pathPoints.contains(neighbor)) {
                findPath(neighbor);
                break;
            }
        }
    }

    /**
     * Retrieves a list of valid neighboring points that can be moved to from
     * the specified point.
     *
     * @param p the point for which to find valid neighbors
     * @return a list of valid neighboring points
     */
    private List<Point> getValidNeighbors(Point p) {
        List<Point> neighbors = new ArrayList<>();
        int x = p.x;
        int y = p.y;

        if (x > 0 && path[x - 1][y] > 0) {
            neighbors.add(new Point(x - 1, y));
        }
        if (x < maze.length - 1 && path[x + 1][y] > 0) {
            neighbors.add(new Point(x + 1, y));
        }
        if (y > 0 && path[x][y - 1] > 0) {
            neighbors.add(new Point(x, y - 1));
        }
        if (y < maze[0].length - 1 && path[x][y + 1] > 0) {
            neighbors.add(new Point(x, y + 1));
        }

        return neighbors;
    }

    /**
     * Calculates a heuristic value for the given point, which is the Manhattan
     * distance from the start point to the given point.
     *
     * @param p the point for which to calculate the heuristic
     * @return the heuristic value for the point
     */
    private int heuristic(Point p) {
        return Math.abs(startX - p.x) + Math.abs(startY - p.y);
    }
}
