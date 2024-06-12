package com.shortestpathfinder.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.shortestpathfinder.dao.PlayerDAO;
import com.shortestpathfinder.model.Player;
import com.shortestpathfinder.ui.SignUpView;
import com.shortestpathfinder.utils.ValidationUtils;

/**
 * Controller class for handling user sign-up actions. Implements ActionListener
 * to respond to button events in the SignUpView.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class SignUpController implements ActionListener {

    /**
     * The view associated with this controller.
     */
    private SignUpView view;

    /**
     * Data Access Object for managing Player objects.
     */
    private PlayerDAO playerDAO;

    /**
     * Constructs a new SignUpController with the specified view and DAO. Adds
     * action listeners to the sign-up and back buttons in the view.
     *
     * @param view the SignUpView associated with this controller.
     * @param playerDAO the DAO for managing Player objects.
     */
    public SignUpController(SignUpView view, PlayerDAO playerDAO) {
        this.view = view;
        this.playerDAO = playerDAO;
        view.getSignUpButton().addActionListener(this);
        view.getBackButton().addActionListener(this);
    }

    /**
     * Maneja los eventos de acción de los botones del menú principal.
     *
     * @param e evento de acción
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.getSignUpButton()) {

            String playerName = view.getNameField().getText().trim();

            if (!ValidationUtils.isValidName(playerName)) {

                JOptionPane.showMessageDialog(view, "Invalid name! Please use only alphabetic characters without special characters.", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (playerDAO.isPlayerNameTaken(playerName)) {
                JOptionPane.showMessageDialog(view, "Name already taken! Please choose another name.", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                Player player = new Player(playerName);
                playerDAO.addPlayer(player);
                JOptionPane.showMessageDialog(view, "Player signed up successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == view.getBackButton()) {
            view.dispose();
        }
    }

    /**
     * Método para mostrar la vista principal.
     */
    public void showView() {
        view.setVisible(true);
    }
}
