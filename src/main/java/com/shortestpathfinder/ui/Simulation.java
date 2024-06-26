package com.shortestpathfinder.ui;

import com.shortestpathfinder.dao.MazeDAO;
import com.shortestpathfinder.dao.MazeDAOImpl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Simulation extends JFrame {

    private JButton selectMazeButton;
    private JButton displaySimulationButton;
    private JButton backButton;
    private JPanel panel;
    private MazeDAO mazeDAO;

    public Simulation() {
        setTitle("Simulation");
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

        //ShortestPathFinder
        JLabel label1 = new JLabel("´Simulation´");
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(32, 80, 600, 39);
        getContentPane().add(label1);

        //----------------"Autores"-------------------------//
        JLabel FAURIZIO = new JLabel("GONZALEZ ALFARO FAURIZIO");
        FAURIZIO.setFont(new Font("Tahoma", Font.BOLD, 10));
        FAURIZIO.setBounds(32, 480, 600, 39);
        getContentPane().add(FAURIZIO);

        JLabel REBECA = new JLabel("RODRIGUEZ GUTIERREZ REBECA");
        REBECA.setFont(new Font("Tahoma", Font.BOLD, 10));
        REBECA.setBounds(32, 500, 600, 39);
        getContentPane().add(REBECA);

        JLabel ANDREY = new JLabel("RODRIGUEZ RODRIGUEZ ANDREY ELADIO");
        ANDREY.setFont(new Font("Tahoma", Font.BOLD, 10));
        ANDREY.setBounds(32, 520, 600, 39);
        getContentPane().add(ANDREY);

        //----------------"Select Maze"-------------------------//
        selectMazeButton = new JButton("Select Maze");
        selectMazeButton.setBackground(new Color(231, 231, 231));
        selectMazeButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        selectMazeButton.setBounds(32, 200, 180, 39);
        getContentPane().add(selectMazeButton);
        selectMazeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                selectMazeButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                selectMazeButton.setBackground(new Color(231, 231, 231));
            }
        });
        //----------------"Simulation"-------------------------//
        displaySimulationButton = new JButton("Simulation");
        displaySimulationButton.setBackground(new Color(231, 231, 231));
        displaySimulationButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        displaySimulationButton.setBounds(32, 281, 180, 39);
        getContentPane().add(displaySimulationButton);
        displaySimulationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                displaySimulationButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                displaySimulationButton.setBackground(new Color(231, 231, 231));
            }
        });

        //----------------"Back"-------------------------//
        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        backButton.setBounds(32, 360, 180, 39);
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

        //----------------"setFocusable"-------------------------//
        backButton.setFocusable(false);
        selectMazeButton.setFocusable(false);
        displaySimulationButton.setFocusable(false);

        //----------------"JPanel"-------------------------// 
        // Crear un JLabel con la imagen
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Ruta de la imagen
        String imagePath = "resources/maze.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);
    }

    public JButton getSelectMazeButton() {
        return selectMazeButton;
    }

    public JButton getDisplaySimulationButton() {
        return displaySimulationButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
