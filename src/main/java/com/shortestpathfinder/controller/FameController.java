// File: src/com/shortestpathfinder/controller/HallOfFameMenuController.java
package com.shortestpathfinder.controller;

import com.shortestpathfinder.dao.*;
import com.shortestpathfinder.ui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

/**
 * Controller for the Hall of Fame submenu.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author: - GONZALEZ ALFARO FAURIZIO
 * @author: - RODRIGUEZ GUTIERREZ REBECA
 * @author: - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class FameController implements ActionListener {
    private FameMenuView view;
    private HallOfFameDAO hallOfFameDAO;

    public FameController(FameMenuView view, HallOfFameDAO hallOfFameDAO) {
        this.view = view;
        this.hallOfFameDAO = hallOfFameDAO;
        view.getBackButton().addActionListener(this);
        loadHallOfFameRecords();
    }

    private void loadHallOfFameRecords() {
        JTextArea textArea = view.getFameRecordsTextArea();
        hallOfFameDAO.getAllFameRecords().forEach(record -> textArea.append(record.toString() + "\n"));
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