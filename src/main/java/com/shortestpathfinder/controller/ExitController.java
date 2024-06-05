// File: src/com/shortestpathfinder/controller/ExitConfirmationController.java
package com.shortestpathfinder.controller;

import com.shortestpathfinder.ui.ExitView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for the exit confirmation.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author: - GONZALEZ ALFARO FAURIZIO
 * @author: - RODRIGUEZ GUTIERREZ REBECA
 * @author: - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class ExitController implements ActionListener {

    private ExitView view;

    public ExitController(ExitView view) {
        this.view = view;
        view.getConfirmButton().addActionListener(this);
        view.getCancelButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getConfirmButton()) {
            System.exit(0);
        }
        if (e.getSource() == view.getCancelButton()) {
            view.dispose();
        }
    }

    public void showView() {
        view.setVisible(true);
    }
}
