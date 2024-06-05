package com.shortestpathfinder.algorithms;

import java.util.*;

public class AStarAlgorithm implements PathfindingAlgorithm {

    static int startX, startY, endX, endY;

    static class Node implements Comparable<Node> {

        int x, y;
        int g, h;

        Node(int x, int y, int g, int h) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
        }

        int f() {
            return g + h;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.f(), other.f());
        }
    }

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

        int[][] path = new int[maze.length][maze[0].length];
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][][] predecessors = new int[maze.length][maze[0].length][2];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                predecessors[i][j][0] = -1;
                predecessors[i][j][1] = -1;
            }
        }

        PriorityQueue<Node> openList = new PriorityQueue<>();
        openList.add(new Node(startX, startY, 0, heuristic(startX, startY, endX, endY)));
        visited[startX][startY] = true;

        boolean found = false;

        while (!openList.isEmpty() && !found) {
            Node current = openList.poll();
            int x = current.x;
            int y = current.y;

            if (x == endX && y == endY) {
                found = true;
                break;
            }

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newY >= 0 && newX < maze.length && newY < maze[0].length
                        && maze[newX][newY] != 'X' && !visited[newX][newY]) {
                    int g = current.g + 1;
                    int h = heuristic(newX, newY, endX, endY);
                    openList.add(new Node(newX, newY, g, h));
                    visited[newX][newY] = true;
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

    private int heuristic(int x, int y, int endX, int endY) {
        // Using Manhattan distance as heuristic
        return Math.abs(x - endX) + Math.abs(y - endY);
    }
}
