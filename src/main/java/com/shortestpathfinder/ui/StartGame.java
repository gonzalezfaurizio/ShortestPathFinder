package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.shortestpathfinder.dao.MazeDAO;
import com.shortestpathfinder.dao.PlayerDAO;
import com.shortestpathfinder.dao.GameDAO;
import com.shortestpathfinder.dao.MazeDAOImpl;
import com.shortestpathfinder.dao.PlayerDAOImpl;
import com.shortestpathfinder.dao.GameDAOImpl;

public class StartGame extends JFrame {

    private JButton selectMazeButton;
    private JButton selectPlayerButton;
    private JButton selectAlgorithmButton;
    private JButton displayPathButton;
    private JButton backButton;
    private JPanel panel;
    private MazeDAO mazeDAO;
    private PlayerDAO playerDAO;
    private GameDAO gameDAO;

    public StartGame() {
        setTitle("Start Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        this.mazeDAO = new MazeDAOImpl();
        this.playerDAO = new PlayerDAOImpl();
        this.gameDAO = new GameDAOImpl();
        initUI();
        setVisible(true);
    }

    private void initUI() {
        //----------------"Titulos"-------------------------//
        JLabel label = new JLabel("IF3001 TP01 GR02");
        label.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 15));
        label.setBounds(32, 40, 600, 39);
        getContentPane().add(label);

        // StartGame
        JLabel label1 = new JLabel("‘Start Game’");
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(32, 80, 600, 39);
        getContentPane().add(label1);

        //----------------"Buttons"-------------------------//
        selectMazeButton = new JButton("Select Maze");
        selectMazeButton.setBackground(new Color(231, 231, 231));
        selectMazeButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        selectMazeButton.setBounds(32, 150, 250, 39);
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

        selectPlayerButton = new JButton("Select Player");
        selectPlayerButton.setBackground(new Color(231, 231, 231));
        selectPlayerButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        selectPlayerButton.setBounds(32, 225, 250, 39);
        getContentPane().add(selectPlayerButton);
        selectPlayerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                selectPlayerButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                selectPlayerButton.setBackground(new Color(231, 231, 231));
            }
        });

        selectAlgorithmButton = new JButton("Select Algorithm");
        selectAlgorithmButton.setBackground(new Color(231, 231, 231));
        selectAlgorithmButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        selectAlgorithmButton.setBounds(32, 300, 250, 39);
        getContentPane().add(selectAlgorithmButton);
        selectAlgorithmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                selectAlgorithmButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                selectAlgorithmButton.setBackground(new Color(231, 231, 231));
            }
        });

        displayPathButton = new JButton("Display Path");
        displayPathButton.setBackground(new Color(231, 231, 231));
        displayPathButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        displayPathButton.setBounds(32, 375, 250, 39);
        getContentPane().add(displayPathButton);
        displayPathButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                displayPathButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                displayPathButton.setBackground(new Color(231, 231, 231));
            }
        });

        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        backButton.setBounds(32, 450, 250, 39);
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
        selectMazeButton.setFocusable(false);
        selectPlayerButton.setFocusable(false);
        selectAlgorithmButton.setFocusable(false);
        displayPathButton.setFocusable(false);

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

    public JButton getSelectMazeButton() {
        return selectMazeButton;
    }

    public JButton getSelectPlayerButton() {
        return selectPlayerButton;
    }

    public JButton getSelectAlgorithmButton() {
        return selectAlgorithmButton;
    }

    public JButton getDisplayPathButton() {
        return displayPathButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

}
