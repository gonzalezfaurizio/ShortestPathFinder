// File: src/com/shortestpathfinder/ui/GameMenuView.java
package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class for the new game submenu view.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class GameMenuView extends JFrame {

    /**
     * The main panel containing the UI components.
     */
    private JPanel panel;

    /**
     * Button to sign up a new player.
     */
    private JButton signUpButton;

    /**
     * Button to select a maze.
     */
    private JButton selectMazeButton;

    /**
     * Button to start a new game.
     */
    private JButton startGameButton;

    /**
     * Button to go back to the previous menu.
     */
    private JButton backButton;

    private JButton simulationButton; 

    /**
     * Constructs a new GameMenuView. Initializes the UI components and sets up
     * the window properties.
     */
    public GameMenuView() {
        setTitle("Game Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

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
        JLabel label1 = new JLabel("´Game Menu´");
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
        
        //A1 ----------------"Sing Up"-------------------------//
        signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(new Color(231, 231, 231));
        signUpButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        signUpButton.setBounds(32, 200, 180, 39);
        getContentPane().add(signUpButton);
        signUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // si el mouse entra en el boton
                signUpButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) { // si el mouse sale del boton
                signUpButton.setBackground(new Color(231, 231, 231));

            }
        });
        //A2 ----------------"Start Game"-------------------------//
        startGameButton = new JButton("Start Game");
        startGameButton.setBackground(new Color(231, 231, 231));
        startGameButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        startGameButton.setBounds(236, 200, 180, 39);
        getContentPane().add(startGameButton);
        startGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // si el mouse entra en el boton
                startGameButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) { // si el mouse sale del boton
                startGameButton.setBackground(new Color(231, 231, 231));

            }
        });
        //B1 ----------------"Upload Maze"-------------------------//
        selectMazeButton = new JButton("Upload Maze");
        selectMazeButton.setBackground(new Color(231, 231, 231));
        selectMazeButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        selectMazeButton.setBounds(236, 281, 180, 39);//setBounds(236, 281, 180, 39);
        getContentPane().add(selectMazeButton);
        selectMazeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // si el mouse entra en el boton
                selectMazeButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) { // si el mouse sale del boton
                selectMazeButton.setBackground(new Color(231, 231, 231));

            }
        });

        //B2 ----------------"Back"-------------------------//
        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        backButton.setBounds(32, 360, 180, 39);
        getContentPane().add(backButton);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // si el mouse entra en el boton
                backButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) { // si el mouse sale del boton
                backButton.setBackground(new Color(231, 231, 231));

            }
        });

        // ----------------"Simulation"-------------------------//
        simulationButton = new JButton("Simulation"); 
        simulationButton.setBackground(new Color(231, 231, 231));
        simulationButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        simulationButton.setBounds(32, 281, 180, 39);
        getContentPane().add(simulationButton);
        simulationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                simulationButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                simulationButton.setBackground(new Color(231, 231, 231));
            }
        });

        //----------------"setFocusable"-------------------------//      
        signUpButton.setFocusable(false);
        selectMazeButton.setFocusable(false);
        startGameButton.setFocusable(false);
        backButton.setFocusable(false);
        simulationButton.setFocusable(false);

        //----------------"JPanel"-------------------------// 
        // Crear un JLabel con la imagen
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Ruta de la imagen
        String imagePath = "resources/arcade.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);

    }

    /**
     * Gets the sign-up button.
     *
     * @return the sign-up button.
     */
    public JButton getSignUpButton() {
        return signUpButton;
    }

    /**
     * Gets the select maze button.
     *
     * @return the select maze button.
     */
    public JButton getSelectMazeButton() {
        return selectMazeButton;
    }

    /**
     * Gets the start game button.
     *
     * @return the start game button.
     */
    public JButton getStartGameButton() {
        return startGameButton;
    }

    /**
     * Gets the back button.
     *
     * @return the back button.
     */
    public JButton getBackButton() {
        return backButton;
    }

    public JButton getSimulationButton() { 
        return simulationButton;
    }

}
