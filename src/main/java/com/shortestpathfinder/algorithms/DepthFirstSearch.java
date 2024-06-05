// File: src/com/shortestpathfinder/algorithms/DepthFirstSearch.java
package com.shortestpathfinder.algorithms;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Interface for pathfinding algorithms.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @authors: - GONZALEZ ALFARO FAURIZIO - RODRIGUEZ GUTIERREZ REBECA - RODRIGUEZ
 * RODRIGUEZ ANDREY ELADIO
 */
public class DepthFirstSearch implements PathfindingAlgorithm {

    // Static variables to store the start and end coordinates
    static int startX, startY, endX, endY;

    // Implementation of the pathfinding method
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

        // Initialize the stack with the start node
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});
        boolean found = false; // Flag to indicate if the path to the end has been found

        // Main loop of the DFS algorithm
        while (!stack.isEmpty() && !found) {
            int[] current = stack.pop(); // Get the next node to explore
            int x = current[0];
            int y = current[1];

            // Check if the current node is within bounds and not visited or a wall
            if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || visited[x][y] || maze[x][y] == 'X') {
                continue;
            }

            visited[x][y] = true; // Mark the current node as visited

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
                    stack.push(new int[]{newX, newY}); // Add neighbor to the stack
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
