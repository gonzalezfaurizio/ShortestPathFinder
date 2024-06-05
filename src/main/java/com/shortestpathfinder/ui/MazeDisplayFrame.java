package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MazeDisplayFrame extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton backButton;

    public MazeDisplayFrame(char[][] maze, int[][] path) {
        setTitle("Maze Path Display");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        MazeDisplayPanel mazeDisplayPanel = new MazeDisplayPanel(maze, path, 400, 400);
        
        JScrollPane scrollPane = new JScrollPane(mazeDisplayPanel);
        
        scrollPane.setBounds(0, 0, 400, 400); // Ajustar tamaño y posición según el diseño
        getContentPane().add(scrollPane);

        // Back button
        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        backButton.setBounds(32, 500, 180, 39);
        getContentPane().add(backButton);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setBackground(new Color(231, 231, 231));
            }
        });
        backButton.addActionListener(this);
        backButton.setFocusable(false);

        // Panel with image
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Image path
        String imagePath = "C:\\Users\\fauri\\OneDrive - Universidad de Costa Rica\\Documentos\\A. Universidad De Costa Rica\\A. Informática\\B. Algoritmos y Estructuras de Datos\\E. Proyecto Programado\\ShortestPathFinder\\src\\main\\java\\com\\shortestpathfinder\\resources\\maze.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
        }
    }
}
