package com.shortestpathfinder.controller;

import com.shortestpathfinder.dao.*;
import com.shortestpathfinder.ui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for the new game submenu.
 *
 * @version 2.0
 * @since 2024-05-21
 *
 * Handles user actions in the game menu and coordinates views and controllers
 * for different game-related functionalities like starting a game, signing up,
 * selecting a maze, and running simulations.
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class GameMenuController implements ActionListener {

    /**
     * The view for the game menu.
     */
    private GameMenuView view;

    /**
     * The view for the sign-up menu.
     */
    private SignUpView signUpView;

    /**
     * The view for maze selection.
     */
    private SelectMaze selectMazeView;

    /**
     * The view for starting a game.
     */
    private StartGame startGameView;

    /**
     * The view for simulation.
     */
    private Simulation simulationView;

    /**
     * The controller for the sign-up menu.
     */
    private SignUpController signUpMenuController;

    /**
     * The controller for maze selection.
     */
    private MazeController selectMazeController;

    /**
     * The controller for game-related functionalities.
     */
    private GameController gameController;

    /**
     * The controller for simulation.
     */
    private SimulationController simulationController;

    /**
     * Data access object for game-related operations.
     */
    private GameDAO gameDAO;

    /**
     * Data access object for player-related operations.
     */
    private PlayerDAO playerDAO;

    /**
     * Data access object for maze-related operations.
     */
    private MazeDAO mazeDAO;

    /**
     * Data access object for the hall of fame operations.
     */
    private HallOfFameDAO hallOfFameDAO;

    /**
     * Constructs a new GameMenuController with the specified views and DAOs.
     *
     * @param view the game menu view
     * @param gameDAO the data access object for game-related operations
     * @param playerDAO the data access object for player-related operations
     * @param mazeDAO the data access object for maze-related operations
     * @param hallOfFameDAO the data access object for hall of fame operations
     */
    public GameMenuController(GameMenuView view, GameDAO gameDAO, PlayerDAO playerDAO, MazeDAO mazeDAO, HallOfFameDAO hallOfFameDAO) {
        this.view = view;
        this.gameDAO = gameDAO;
        this.playerDAO = playerDAO;
        this.mazeDAO = mazeDAO;
        this.hallOfFameDAO = hallOfFameDAO;

        view.getStartGameButton().addActionListener(this);
        view.getSignUpButton().addActionListener(this);
        view.getBackButton().addActionListener(this);
        view.getSelectMazeButton().addActionListener(this);
        view.getSimulationButton().addActionListener(this);
    }

    /**
     * Handles action events triggered by the user in the game menu.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSignUpButton()) {
            signUpView = new SignUpView();
            signUpMenuController = new SignUpController(signUpView, playerDAO);
            signUpMenuController.showView();
        }

        if (e.getSource() == view.getStartGameButton()) {
            startGameView = new StartGame();
            gameController = new GameController(startGameView, mazeDAO, playerDAO, gameDAO, hallOfFameDAO);
            gameController.showView();
        }

        if (e.getSource() == view.getSelectMazeButton()) {
            selectMazeView = new SelectMaze();
            selectMazeController = new MazeController(selectMazeView, mazeDAO);
            selectMazeController.showView();
        }

        if (e.getSource() == view.getBackButton()) {
            view.dispose();
        }

        if (e.getSource() == view.getSimulationButton()) {
            simulationView = new Simulation();
            simulationController = new SimulationController(simulationView, mazeDAO);
            simulationController.showView();
        }
    }

    /**
     * Makes the game menu view visible.
     */
    public void showView() {
        view.setVisible(true);
    }
}
