// File: src/com/shortestpathfinder/controller/InstructionsMenuController.java
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
 * @author: - GONZALEZ ALFARO FAURIZIO
 * @author: - RODRIGUEZ GUTIERREZ REBECA
 * @author: - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class InstructionsController implements ActionListener {

    private InstructionsView view;

    public InstructionsController(InstructionsView view) {
        this.view = view;
        view.getBackButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBackButton()) {
            view.dispose();
        }
    }

    public void showView() {
        view.setVisible(true);
    }
}
