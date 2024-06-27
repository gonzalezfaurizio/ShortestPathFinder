package com.shortestpathfinder.controller;

import com.shortestpathfinder.ui.ExitView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Controller for the exit confirmation.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class ExitController implements ActionListener {

    /**
     * The view associated with this controller.
     */
    private ExitView view;

    /**
     * Constructs a new ExitController with the specified view. Adds action
     * listeners to the confirm and cancel buttons in the view.
     *
     * @param view the ExitView associated with this controller.
     */
    public ExitController(ExitView view) {
        this.view = view;
        view.getConfirmButton().addActionListener(this);
        view.getCancelButton().addActionListener(this);
    }

    /**
     * Handles action events triggered by the buttons in the view. If the
     * confirm button is pressed, the application exits. If the cancel button is
     * pressed, the view is disposed.
     *
     * @param e the ActionEvent triggered by a button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getConfirmButton()) {
            JOptionPane.showMessageDialog(view, "Thank you for playing", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if (e.getSource() == view.getCancelButton()) {
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
