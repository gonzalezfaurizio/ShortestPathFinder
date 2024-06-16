package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class for the Hall of Fame submenu view.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class FameMenuView extends JFrame {

    /**
     * Button to navigate back to the previous menu.
     */
    private JButton backButton;

    /**
     * The main panel containing the UI components.
     */
    private JPanel panel;

    /**
     * Constructs a new FameMenuView. Initializes the UI components and sets up
     * the window properties.
     */
    public FameMenuView() {
        setTitle("Hall of Fame");
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

        // Hall of Fame
        JLabel label1 = new JLabel("‘Hall of Fame’");
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(32, 80, 600, 39);
        getContentPane().add(label1);

        //----------------"Hall of Fame Records"-------------------------//
        JTextArea fameRecordsText = new JTextArea();
        fameRecordsText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fameRecordsText.setEditable(false);
        fameRecordsText.setBackground(new Color(236, 236, 236)); // Color extraído de la imagen proporcionada
        JScrollPane scrollPane = new JScrollPane(fameRecordsText);
        scrollPane.setBounds(32, 140, 400, 200);
        getContentPane().add(scrollPane);

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

        //----------------"Back"-------------------------//
        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        backButton.setBounds(32, 350, 180, 39);
        getContentPane().add(backButton);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // si el mouse entra en el botón
                backButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) { // si el mouse sale del botón
                backButton.setBackground(new Color(231, 231, 231));
            }
        });

        backButton.setFocusable(false);

        // Crear un JLabel con la imagen
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Ruta de la imagen
        String imagePath = "C:\\Users\\fauri\\OneDrive - Universidad de Costa Rica\\Documentos\\GitHub\\ShortestPathFinder\\src\\main\\java\\com\\shortestpathfinder\\resources\\hall-of-fame.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);
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
     * Gets the text area displaying the Hall of Fame records.
     *
     * @return the text area displaying the Hall of Fame records.
     */
    public JTextArea getFameRecordsTextArea() {
        return (JTextArea) ((JScrollPane) getContentPane().getComponent(2)).getViewport().getView();
    }
}
