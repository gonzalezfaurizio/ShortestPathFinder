// File: src/com/shortestpathfinder/ui/ExitConfirmationView.java
package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class for the exit confirmation view.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author: - GONZALEZ ALFARO FAURIZIO
 * @author: - RODRIGUEZ GUTIERREZ REBECA
 * @author: - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class ExitView extends JFrame {

    private JPanel panel;
    private JButton confirmButton;
    private JButton cancelButton;

    public ExitView() {
        setTitle("Exit Confirmation");
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
        JLabel label1 = new JLabel("´Exit Confirmation´");
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

        //B1 ----------------"confirmButton"-------------------------//
        confirmButton = new JButton("Confirm");
        confirmButton.setBackground(new Color(231, 231, 231));
        confirmButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        confirmButton.setBounds(32, 281, 180, 39);
        getContentPane().add(confirmButton);
        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // si el mouse entra en el boton
                confirmButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) { // si el mouse sale del boton
                confirmButton.setBackground(new Color(231, 231, 231));

            }
        });

        //B2 ----------------"cancelButton"-------------------------//
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(231, 231, 231));
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        cancelButton.setBounds(236, 281, 180, 39);
        getContentPane().add(cancelButton);
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // si el mouse entra en el boton
                cancelButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) { // si el mouse sale del boton
                cancelButton.setBackground(new Color(231, 231, 231));

            }
        });

        confirmButton.setFocusable(false);
        cancelButton.setFocusable(false);

        // Crear un JLabel con la imagen
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Ruta de la imagen
        String imagePath = "C:\\Users\\fauri\\OneDrive - Universidad de Costa Rica\\Documentos\\A. Universidad De Costa Rica\\A. Informática\\B. Algoritmos y Estructuras de Datos\\E. Proyecto Programado\\ShortestPathFinder\\src\\main\\java\\com\\shortestpathfinder\\resources\\exit.png";
        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        panel.add(imageLabel, BorderLayout.CENTER);
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
