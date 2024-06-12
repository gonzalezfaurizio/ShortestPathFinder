package com.shortestpathfinder.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of the Breadth-First Search (BFS) pathfinding algorithm.
 * Provides functionality to find a path through a maze using the BFS algorithm.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class BreadthFirstSearch implements PathfindingAlgorithm {

    /**
     * The starting X coordinate.
     */
    static int startX;

    /**
     * The starting Y coordinate.
     */
    static int startY;

    /**
     * The ending X coordinate.
     */
    static int endX;

    /**
     * The ending Y coordinate.
     */
    static int endY;

    /**
     * Finds the path through the maze using the BFS algorithm.
     *
     * @param maze the 2D character array representing the maze.
     * @return a 2D integer array representing the path through the maze.
     */
    @Override
    public int[][] findPath(char[][] maze) {

        // Identify the start and end points from the maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (maze[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        // Initialize the path, visited, and predecessors arrays
        int[][] path = new int[maze.length][maze[0].length];
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][][] predecessors = new int[maze.length][maze[0].length][2];

        // Set all predecessors to -1 (indicating no predecessor)
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                predecessors[i][j][0] = -1;
                predecessors[i][j][1] = -1;
            }
        }

        // Initialize the queue with the start node
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        boolean found = false; // Flag to indicate if the path to the end has been found

        // Main loop of the BFS algorithm
        while (!queue.isEmpty() && !found) {
            int[] current = queue.poll(); // Get the next node to explore
            int x = current[0];
            int y = current[1];

            // If the end node is reached, exit the loop
            if (x == endX && y == endY) {
                found = true;
                break;
            }

            // Explore the neighboring nodes
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check if the neighbor is within bounds, not a wall, and not visited
                if (newX >= 0 && newY >= 0 && newX < maze.length && newY < maze[0].length
                        && !visited[newX][newY] && maze[newX][newY] != 'X') {

                    queue.add(new int[]{newX, newY}); // Add neighbor to the queue
                    visited[newX][newY] = true; // Mark neighbor as visited
                    predecessors[newX][newY][0] = x; // Set predecessor
                    predecessors[newX][newY][1] = y;
                }
            }
        }

        if (!found) {
            return null; // No path found
        }

        // Trace back the path from the end to the start
        int x = endX;
        int y = endY;
        LinkedList<int[]> shortestPath = new LinkedList<>();

        while (x != startX || y != startY) {
            shortestPath.addFirst(new int[]{x, y});
            int tempX = predecessors[x][y][0];
            int tempY = predecessors[x][y][1];
            x = tempX;
            y = tempY;
        }
        shortestPath.addFirst(new int[]{startX, startY});

        // Convert the shortest path to the path matrix
        for (int[] cell : shortestPath) {
            path[cell[0]][cell[1]] = 1;
        }

        return path;
    }
}
