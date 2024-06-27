package com.shortestpathfinder.ui;

import com.shortestpathfinder.dao.MazeDAO;
import com.shortestpathfinder.dao.MazeDAOImpl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the main frame for the Simulation application. It
 * provides a graphical user interface for selecting a maze, displaying the
 * simulation, and navigating back to the previous screen.
 *
 * @version 1.0
 * @since 2024-06-26
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class Simulation extends JFrame {

    /**
     * Button to select a maze.
     */
    private JButton selectMazeButton;

    /**
     * Button to display the simulation.
     */
    private JButton displaySimulationButton;

    /**
     * Button to navigate back to the previous screen.
     */
    private JButton backButton;

    /**
     * Panel to display additional content, such as an image.
     */
    private JPanel panel;

    /**
     * Data Access Object for managing maze data.
     */
    private MazeDAO mazeDAO;

    /**
     * Constructs a new Simulation frame with the specified title and size.
     * Initializes the user interface components and sets the frame's visibility
     * to true.
     */
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

    /**
     * Initializes the user interface components for the Simulation frame. This
     * includes setting up labels, buttons, and a panel for displaying an image.
     */
    private void initUI() {
        // Title Labels
        JLabel label = new JLabel("IF3001 TP01 GR02");
        label.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 15));
        label.setBounds(32, 40, 600, 39);
        getContentPane().add(label);

        JLabel label1 = new JLabel("´Simulation´");
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(32, 80, 600, 39);
        getContentPane().add(label1);

        // Author Labels
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

        // Buttons
        selectMazeButton = new JButton("Select Maze");
        selectMazeButton.setBackground(new Color(231, 231, 231));
        selectMazeButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        selectMazeButton.setBounds(32, 200, 180, 39);
        getContentPane().add(selectMazeButton);
        addHoverEffect(selectMazeButton);

        displaySimulationButton = new JButton("Simulation");
        displaySimulationButton.setBackground(new Color(231, 231, 231));
        displaySimulationButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        displaySimulationButton.setBounds(32, 281, 180, 39);
        getContentPane().add(displaySimulationButton);
        addHoverEffect(displaySimulationButton);

        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        backButton.setBounds(32, 360, 180, 39);
        getContentPane().add(backButton);
        addHoverEffect(backButton);

        // Make buttons non-focusable
        backButton.setFocusable(false);
        selectMazeButton.setFocusable(false);
        displaySimulationButton.setFocusable(false);

        // Panel with image
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Adding image to panel
        String imagePath = "resources/maze.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);
    }

    /**
     * Adds a hover effect to the specified button.
     *
     * @param button the JButton to which the hover effect will be added
     */
    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(231, 231, 231));
            }
        });
    }

    /**
     * Returns the Select Maze button.
     *
     * @return the selectMazeButton
     */
    public JButton getSelectMazeButton() {
        return selectMazeButton;
    }

    /**
     * Returns the Display Simulation button.
     *
     * @return the displaySimulationButton
     */
    public JButton getDisplaySimulationButton() {
        return displaySimulationButton;
    }

    /**
     * Returns the Back button.
     *
     * @return the backButton
     */
    public JButton getBackButton() {
        return backButton;
    }
}
