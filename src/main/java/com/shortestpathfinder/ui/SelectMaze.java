package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.shortestpathfinder.dao.MazeDAO;
import com.shortestpathfinder.dao.MazeDAOImpl;

public class SelectMaze extends JFrame {

    private JButton uploadMazeButton;

    private JButton backButton;
    private JPanel panel;
    private MazeDAO mazeDAO;

    public SelectMaze() {
        setTitle("Upload Maze");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        this.mazeDAO = new MazeDAOImpl();
        initUI();
        setVisible(true);
    }

    private void initUI() {
        //----------------"Titulos"-------------------------//
        JLabel label = new JLabel("IF3001 TP01 GR02");
        label.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 15));
        label.setBounds(32, 40, 600, 39);
        getContentPane().add(label);

        // SelectMaze
        JLabel label1 = new JLabel("‘Upload Maze’");
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(32, 80, 600, 39);
        getContentPane().add(label1);

        //----------------"Buttons"-------------------------//
        uploadMazeButton = new JButton("Upload Maze");
        uploadMazeButton.setBackground(new Color(231, 231, 231));
        uploadMazeButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        uploadMazeButton.setBounds(32, 200, 180, 39);
        getContentPane().add(uploadMazeButton);
        uploadMazeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                uploadMazeButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                uploadMazeButton.setBackground(new Color(231, 231, 231));
            }
        });


        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        backButton.setBounds(32, 281, 180, 39);
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

        backButton.setFocusable(false);
        uploadMazeButton.setFocusable(false);


        // Crear un JLabel con la imagen
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Ruta de la imagen
        String imagePath = "C:\\Users\\fauri\\OneDrive - Universidad de Costa Rica\\Documentos\\A. Universidad De Costa Rica\\A. Informática\\B. Algoritmos y Estructuras de Datos\\E. Proyecto Programado\\ShortestPathFinder\\src\\main\\java\\com\\shortestpathfinder\\resources\\maze.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);
    }

    public JButton getUploadMazeButton() {
        return uploadMazeButton;
    }


    public JButton getBackButton() {
        return backButton;
    }

}
