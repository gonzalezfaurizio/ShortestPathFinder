package com.shortestpathfinder.algorithms;

import java.util.*;

public class AStarAlgorithm implements PathfindingAlgorithm {

    // Static variables to store the start and end coordinates
    static int startX, startY, endX, endY;

    // Inner class representing a node in the grid
    static class Node implements Comparable<Node> {

        int x, y; // Coordinates of the node
        int g, h; // g is the cost from start to this node, h is the heuristic cost to the end

        Node(int x, int y, int g, int h) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
        }

        // Method to calculate the f score of the node (f = g + h)
        int f() {
            return g + h;
        }

        // Compare nodes based on their f scores
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.f(), other.f());
        }
    }

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

        // Initialize the open list with the start node
        PriorityQueue<Node> openList = new PriorityQueue<>();
        openList.add(new Node(startX, startY, 0, heuristic(startX, startY, endX, endY)));
        visited[startX][startY] = true;

        boolean found = false; // Flag to indicate if the path to the end has been found

        // Main loop of the A* algorithm
        while (!openList.isEmpty() && !found) {
            Node current = openList.poll(); // Get the node with the lowest f score
            int x = current.x;
            int y = current.y;

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
                        && maze[newX][newY] != 'X' && !visited[newX][newY]) {

                    int g = current.g + 1; // Cost from start to the neighbor

                    int h = heuristic(newX, newY, endX, endY); // Heuristic cost to the end

                    openList.add(new Node(newX, newY, g, h)); // Add neighbor to the open list

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

    // Heuristic function to estimate the cost from a node to the end node
    private int heuristic(int x, int y, int endX, int endY) {
        // Using Manhattan distance as heuristic
        return Math.abs(x - endX) + Math.abs(y - endY);
    }
}
