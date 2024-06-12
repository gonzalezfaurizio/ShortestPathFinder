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
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class FameController implements ActionListener {

    /**
     * The view associated with this controller.
     */
    private FameMenuView view;

    /**
     * Data Access Object for managing Hall of Fame records.
     */
    private HallOfFameDAO hallOfFameDAO;

    /**
     * Constructs a new FameController with the specified view and DAO. Adds an
     * action listener to the back button in the view and loads the Hall of Fame
     * records.
     *
     * @param view the FameMenuView associated with this controller.
     * @param hallOfFameDAO the DAO for managing Hall of Fame records.
     */
    public FameController(FameMenuView view, HallOfFameDAO hallOfFameDAO) {
        this.view = view;
        this.hallOfFameDAO = hallOfFameDAO;
        view.getBackButton().addActionListener(this);
        loadHallOfFameRecords();
    }

    /**
     * Loads and displays all Hall of Fame records in the view's text area.
     */
    private void loadHallOfFameRecords() {
        JTextArea textArea = view.getFameRecordsTextArea();
        hallOfFameDAO.getAllFameRecords().forEach(record -> textArea.append(record.toString() + "\n"));
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
