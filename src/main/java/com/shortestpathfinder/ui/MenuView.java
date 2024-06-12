package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * View class for the main menu of the application. Extends JFrame to create a
 * window with buttons for starting a new game, viewing the Hall of Fame,
 * viewing instructions, and exiting the application.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class MenuView extends JFrame {

    /**
     * The main panel containing the UI components.
     */
    private JPanel panel;

    /**
     * Button to start a new game.
     */
    private JButton newGameButton;

    /**
     * Button to view the Hall of Fame.
     */
    private JButton hallOfFameButton;

    /**
     * Button to view the instructions.
     */
    private JButton instructionsButton;

    /**
     * Button to exit the application.
     */
    private JButton exitButton;

    /**
     * Constructs a new MenuView. Initializes the UI components and sets up the
     * window properties.
     */
    public MenuView() {
        setTitle("Main Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        initUI();
        setVisible(true);
    }

    /**
     * Initializes the UI components of the view.
     */
    private void initUI() {
        //----------------"Titulos"-------------------------//
        JLabel label = new JLabel("IF3001 TP01 GR02");
        label.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 15));
        label.setBounds(32, 40, 600, 39);
        getContentPane().add(label);

        //ShortestPathFinder
        JLabel label1 = new JLabel("´Shortest Path Finder´");
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

        //A1 ----------------"New Game"-------------------------//
        newGameButton = new JButton("Game");
        newGameButton.setBackground(new Color(231, 231, 231));
        newGameButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        newGameButton.setBounds(32, 200, 180, 39);
        getContentPane().add(newGameButton);
        newGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // si el mouse entra en el boton
                newGameButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) { // si el mouse sale del boton
                newGameButton.setBackground(new Color(231, 231, 231));

            }
        });
        //A2 ----------------"Hall of Fame"-------------------------//
        hallOfFameButton = new JButton("Hall of Fame");
        hallOfFameButton.setBackground(new Color(231, 231, 231));
        hallOfFameButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        hallOfFameButton.setBounds(236, 200, 180, 39);
        getContentPane().add(hallOfFameButton);
        hallOfFameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // si el mouse entra en el boton
                hallOfFameButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) { // si el mouse sale del boton
                hallOfFameButton.setBackground(new Color(231, 231, 231));

            }
        });

        //B1 ----------------"Instructions"-------------------------//
        instructionsButton = new JButton("Instructions");
        instructionsButton.setBackground(new Color(231, 231, 231));
        instructionsButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        instructionsButton.setBounds(32, 281, 180, 39);
        getContentPane().add(instructionsButton);
        instructionsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // si el mouse entra en el boton
                instructionsButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) { // si el mouse sale del boton
                instructionsButton.setBackground(new Color(231, 231, 231));

            }
        });

        //B2 ----------------"Exit"-------------------------//
        exitButton = new JButton("Exit");
        exitButton.setBackground(new Color(231, 231, 231));
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        exitButton.setBounds(236, 281, 180, 39);
        getContentPane().add(exitButton);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // si el mouse entra en el boton
                exitButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) { // si el mouse sale del boton
                exitButton.setBackground(new Color(231, 231, 231));

            }
        });

        newGameButton.setFocusable(false);
        hallOfFameButton.setFocusable(false);
        instructionsButton.setFocusable(false);
        exitButton.setFocusable(false);

        // Crear un JLabel con la imagen
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Ruta de la imagen
        String imagePath = "C:\\Users\\fauri\\OneDrive - Universidad de Costa Rica\\Documentos\\A. Universidad De Costa Rica\\A. Informática\\B. Algoritmos y Estructuras de Datos\\E. Proyecto Programado\\ShortestPathFinder\\src\\main\\java\\com\\shortestpathfinder\\resources\\home.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);

    }

    /**
     * Gets the new game button.
     *
     * @return the new game button.
     */
    public JButton getNewGameButton() {
        return newGameButton;
    }

    /**
     * Gets the Hall of Fame button.
     *
     * @return the Hall of Fame button.
     */
    public JButton getHallOfFameButton() {
        return hallOfFameButton;
    }

    /**
     * Gets the instructions button.
     *
     * @return the instructions button.
     */
    public JButton getInstructionsButton() {
        return instructionsButton;
    }

    /**
     * Gets the exit button.
     *
     * @return the exit button.
     */
    public JButton getExitButton() {
        return exitButton;
    }
}
