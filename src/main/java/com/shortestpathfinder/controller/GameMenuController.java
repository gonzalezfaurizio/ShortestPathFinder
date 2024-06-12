package com.shortestpathfinder.controller;

import com.shortestpathfinder.dao.*;
import com.shortestpathfinder.ui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for the new game submenu.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class GameMenuController implements ActionListener {

    /**
     * The view associated with this controller.
     */
    private GameMenuView view;

    /**
     * The sign-up view associated with this controller.
     */
    private SignUpView signUpView;

    /**
     * The select maze view associated with this controller.
     */
    private SelectMaze selectMazeView;

    /**
     * The start game view associated with this controller.
     */
    private StartGame startGameView;

    /**
     * The controller for sign-up actions.
     */
    private SignUpController signUpMenuController;

    /**
     * The controller for maze selection actions.
     */
    private MazeController selectMazeController;

    /**
     * The controller for game actions.
     */
    private GameController gameController;

    /**
     * Data Access Object for managing Game objects.
     */
    private GameDAO gameDAO;

    /**
     * Data Access Object for managing Player objects.
     */
    private PlayerDAO playerDAO;

    /**
     * Data Access Object for managing Maze objects.
     */
    private MazeDAO mazeDAO;

    /**
     * Data Access Object for managing Hall of Fame records.
     */
    private HallOfFameDAO hallOfFameDAO;

    /**
     * Constructs a new GameMenuController with the specified view and DAOs.
     * Adds action listeners to the buttons in the view.
     *
     * @param view the GameMenuView associated with this controller.
     * @param gameDAO the DAO for managing Game objects.
     * @param playerDAO the DAO for managing Player objects.
     * @param mazeDAO the DAO for managing Maze objects.
     * @param hallOfFameDAO the DAO for managing Hall of Fame records.
     */
    public GameMenuController(GameMenuView view, GameDAO gameDAO, PlayerDAO playerDAO, MazeDAO mazeDAO, HallOfFameDAO hallOfFameDAO) {
        this.view = view;
        this.gameDAO = gameDAO;
        this.playerDAO = playerDAO;
        this.mazeDAO = mazeDAO;
        this.hallOfFameDAO = hallOfFameDAO;

        view.getStartGameButton().addActionListener(this);
        view.getSingUpButton().addActionListener(this);
        view.getBackButton().addActionListener(this);
        view.getSelectMazeButton().addActionListener(this);

    }

    /**
     * Handles action events triggered by the view.
     *
     * @param e the ActionEvent triggered by a user action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSingUpButton()) {
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

    }

    /**
     * Makes the view visible.
     */
    public void showView() {
        view.setVisible(true);
    }
}
