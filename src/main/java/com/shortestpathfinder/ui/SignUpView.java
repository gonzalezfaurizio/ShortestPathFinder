package com.shortestpathfinder.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * View class for user sign-up. Extends JFrame to create a window with fields
 * for user input and buttons for signing up and going back.
 */
public class SignUpView extends JFrame {

    /**
     * Button to sign up a new user.
     */
    private JButton signUpButton;

    /**
     * Button to go back to the previous menu.
     */
    private JButton backButton;

    /**
     * Text field for entering the user's name.
     */
    private JTextField nameField;

    /**
     * Constructs a new SignUpView. Initializes the UI components and sets up
     * the window properties.
     */
    public SignUpView() {
        setTitle("Sign Up");
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

        // SignUp
        JLabel label1 = new JLabel("‘Sign Up’");
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setBounds(32, 80, 600, 39);
        getContentPane().add(label1);

        //----------------"Sign Up Form"-------------------------//
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameLabel.setBounds(32, 140, 100, 25);
        getContentPane().add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setBounds(100, 140, 200, 25);
        getContentPane().add(nameField);

        //----------------"Buttons"-------------------------//
        signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(new Color(231, 231, 231));
        signUpButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        signUpButton.setBounds(32, 200, 180, 39);
        getContentPane().add(signUpButton);
        signUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signUpButton.setBackground(new Color(192, 192, 192));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signUpButton.setBackground(new Color(231, 231, 231));
            }
        });

        backButton = new JButton("Back");
        backButton.setBackground(new Color(231, 231, 231));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        backButton.setBounds(32, 281, 180, 39);;
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
        signUpButton.setFocusable(false);

        // Crear un JLabel con la imagen
        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(440, 0, 362, 563);
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        // Ruta de la imagen
        String imagePath = "resources/user.png";
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
     * Gets the back button.
     *
     * @return the back button.
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Gets the text field for entering the user's name.
     *
     * @return the name field.
     */
    public JTextField getNameField() {
        return nameField;
    }

}
