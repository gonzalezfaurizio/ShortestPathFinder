package com.shortestpathfinder.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.shortestpathfinder.dao.PlayerDAO;
import com.shortestpathfinder.model.Player;
import com.shortestpathfinder.ui.SignUpView;
import com.shortestpathfinder.utils.ValidationUtils;

public class SignUpController implements ActionListener {

    private SignUpView view;
    private PlayerDAO playerDAO;

    public SignUpController(SignUpView view, PlayerDAO playerDAO) {
        this.view = view;
        this.playerDAO = playerDAO;
        view.getSignUpButton().addActionListener(this);
        view.getBackButton().addActionListener(this);
    }

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

    public void showView() {
        view.setVisible(true);
    }
}
