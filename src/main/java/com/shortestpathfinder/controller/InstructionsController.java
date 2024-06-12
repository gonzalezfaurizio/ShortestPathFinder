package com.shortestpathfinder.controller;

import com.shortestpathfinder.ui.InstructionsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for the instructions submenu.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class InstructionsController implements ActionListener {

    /**
     * The view associated with this controller.
     */
    private InstructionsView view;

    /**
     * Constructs a new InstructionsController with the specified view. Adds an
     * action listener to the back button in the view.
     *
     * @param view the InstructionsView associated with this controller.
     */
    public InstructionsController(InstructionsView view) {
        this.view = view;
        view.getBackButton().addActionListener(this);
    }

    /**
     * Handles action events triggered by the view. Disposes the view if the
     * back button is pressed.
     *
     * @param e the ActionEvent triggered by a user action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBackButton()) {
            view.dispose();
        }
    }

    /**
     * Makes the view visible.
     */
    public void showView() {
        view.setVisible(true);
    }
}
