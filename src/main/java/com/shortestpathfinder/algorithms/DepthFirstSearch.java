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

    static int startX, startY, endX, endY;

    @Override
    public int[][] findPath(char[][] maze) {
        // Identificar los puntos de inicio y fin en el laberinto
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

        int[][] path = new int[maze.length][maze[0].length];
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][][] predecessors = new int[maze.length][maze[0].length][2];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                predecessors[i][j][0] = -1;
                predecessors[i][j][1] = -1;
            }
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});
        boolean found = false;

        while (!stack.isEmpty() && !found) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || visited[x][y] || maze[x][y] == 'X') {
                continue;
            }

            visited[x][y] = true;

            if (x == endX && y == endY) {
                found = true;
                break;
            }

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newY >= 0 && newX < maze.length && newY < maze[0].length
                        && !visited[newX][newY] && maze[newX][newY] != 'X') {
                    stack.push(new int[]{newX, newY});
                    predecessors[newX][newY][0] = x;
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
