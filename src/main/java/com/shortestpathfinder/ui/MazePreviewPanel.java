package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import com.shortestpathfinder.model.Maze;

public class MazePreviewPanel extends JPanel {

    private Maze maze;

    public MazePreviewPanel(Maze maze) {
        this.maze = maze;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 100));

        JPanel mazePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                char[][] grid = maze.getGrid();
                int rows = grid.length;
                int cols = grid[0].length;
                int cellSize = Math.min(getWidth() / cols, getHeight() / rows);

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (grid[i][j] == 'X') {
                            g.setColor(Color.BLACK);
                        } else {
                            g.setColor(Color.WHITE);
                        }
                        g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                        g.setColor(Color.GRAY);
                        g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
                    }
                }
            }
        };
        mazePanel.setPreferredSize(new Dimension(100, 100));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(new JLabel("Name: " + maze.getName()));
        infoPanel.add(new JLabel("Difficulty: " + maze.getDifficulty()));

        add(mazePanel, BorderLayout.WEST);
        add(infoPanel, BorderLayout.CENTER);
    }
}
