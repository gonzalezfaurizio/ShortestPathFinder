package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.shortestpathfinder.dao.MazeDAO;
import com.shortestpathfinder.dao.MazeDAOImpl;

/**
 * View class for selecting and uploading a maze. Extends JFrame to create a
 * window with buttons for uploading a maze and going back.
 *
 * @version 2.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class SelectMaze extends JFrame {

    /**
     * Button to upload a maze.
     */
    private JButton uploadMazeButton;

    /**
     * Button to go back to the previous menu.
     */
    private JButton backButton;

    /**
     * Button to show maze information.
     */
    private JButton showInfoButton;

    /**
     * The main panel containing the UI components.
     */
    private JPanel panel;

    /**
     * Data Access Object for managing Maze objects.
     */
    private MazeDAO mazeDAO;

    /**
     * Constructs a new SelectMaze view. Initializes the UI components and sets
     * up the window properties.
     */
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

    /**
     * Initializes the UI components of the view.
     */
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
        uploadMazeButton.setBounds(32, 281, 180, 39);
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
        backButton.setBounds(32, 362, 180, 39);

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

        showInfoButton = new JButton("Maze Info");
        showInfoButton.setBackground(new Color(231, 231, 231));
        showInfoButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        showInfoButton.setBounds(32, 200, 180, 39);
        getContentPane().add(showInfoButton);
        showInfoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showInfoButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                showInfoButton.setBackground(new Color(231, 231, 231));
            }
        });

        backButton.setFocusable(false);
        uploadMazeButton.setFocusable(false);
        showInfoButton.setFocusable(false);

        // Crear un JLabel con la imagen
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Ruta de la imagen
        String imagePath = "resources/upload.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);
    }

    /**
     * Gets the upload maze button.
     *
     * @return the upload maze button.
     */
    public JButton getUploadMazeButton() {
        return uploadMazeButton;
    }

    /**
     * Gets the back button.
     *
     * @return the back button.
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Gets the show info button.
     *
     * @return the show info button.
     */
    public JButton getShowInfoButton() {
        return showInfoButton;
    }

}
