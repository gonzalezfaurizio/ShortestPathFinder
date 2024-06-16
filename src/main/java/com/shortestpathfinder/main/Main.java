package com.shortestpathfinder.main;

import com.shortestpathfinder.ui.*;
import com.shortestpathfinder.controller.*;
import com.shortestpathfinder.dao.*;

/**
 * Main class that initializes the application.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class Main {

    /**
     * The main method initializes and starts the application.
     *
     * @param args command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        // Initialize the main menu view
        MenuView mainMenuView = new MenuView();

        // Initialize the DAOs
        GameDAOImpl gameDAO = new GameDAOImpl();
        HallOfFameDAOImpl hallOfFameDAO = new HallOfFameDAOImpl();
        PlayerDAOImpl playerDAOImpl = new PlayerDAOImpl();
        MazeDAOImpl mazeDAOImpl = new MazeDAOImpl();

        // Initialize the main menu controller with the DAOs
        MenuController mainMenuController = new MenuController(mainMenuView, gameDAO, hallOfFameDAO, playerDAOImpl, mazeDAOImpl);

        // Show the main menu view
        mainMenuController.showView();
    }
}
