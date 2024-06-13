package com.shortestpathfinder.controller;

import com.shortestpathfinder.dao.*;
import com.shortestpathfinder.ui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for the main menu.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class MenuController implements ActionListener {

    /**
     * The view associated with this controller.
     */
    private MenuView view;

    /**
     * The game menu view associated with this controller.
     */
    private GameMenuView gameMenuView;

    /**
     * The Hall of Fame menu view associated with this controller.
     */
    private FameMenuView hallOfFameMenuView;

    /**
     * The instructions menu view associated with this controller.
     */
    private InstructionsView instructionsMenuView;

    /**
     * The exit confirmation view associated with this controller.
     */
    private ExitView exitConfirmationView;

    /**
     * The select maze view associated with this controller.
     */
    private SelectMaze selectMazeView;

    /**
     * The start game view associated with this controller.
     */
    private StartGame startGameView;

    /**
     * The controller for game menu actions.
     */
    private GameMenuController gameMenuController;

    /**
     * The controller for Hall of Fame menu actions.
     */
    private FameController hallOfFameMenuController;

    /**
     * The controller for instructions menu actions.
     */
    private InstructionsController instructionsMenuController;

    /**
     * The controller for exit confirmation actions.
     */
    private ExitController exitConfirmationController;

    /**
     * The controller for maze selection actions.
     */
    private MazeController selectMazeController;

    /**
     * The controller for game actions.
     */
    private GameController gameController;

    /**
     * Data Access Object for managing Player objects.
     */
    private PlayerDAO playerDAO;

    /**
     * Data Access Object for managing Game objects.
     */
    private GameDAO gameDAO;

    /**
     * Data Access Object for managing Hall of Fame records.
     */
    private HallOfFameDAO hallOfFameDAO;

    /**
     * Data Access Object for managing Maze objects.
     */
    private MazeDAO mazeDAO;

    /**
     * Constructor que recibe la vista de menú principal y los DAO. Registra los
     * listeners de los botones del menú.
     *
     * @param view Vista del menú principal
     * @param gameDAO DAO de juegos
     * @param hallOfFameDAO DAO del Salón de la Fama
     */
    public MenuController(MenuView view, GameDAO gameDAO, HallOfFameDAO hallOfFameDAO, PlayerDAO playerDAO, MazeDAO mazeDAO) {
        this.view = view;
        this.gameDAO = gameDAO;
        this.hallOfFameDAO = hallOfFameDAO;
        this.playerDAO = playerDAO;
        this.mazeDAO = mazeDAO;

        view.getNewGameButton().addActionListener(this);
        view.getHallOfFameButton().addActionListener(this);
        view.getInstructionsButton().addActionListener(this);
        view.getExitButton().addActionListener(this);
    }

    /**
     * Handles action events triggered by the view.
     *
     * @param e the ActionEvent triggered by a user action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getExitButton()) {
            exitConfirmationView = new ExitView();
            exitConfirmationController = new ExitController(exitConfirmationView);
            exitConfirmationController.showView();
        }

        if (e.getSource() == view.getNewGameButton()) {
            gameMenuView = new GameMenuView();
            gameMenuController = new GameMenuController(gameMenuView, gameDAO, playerDAO, mazeDAO, hallOfFameDAO);
            gameMenuController.showView();
        }

        if (e.getSource() == view.getHallOfFameButton()) {
            hallOfFameMenuView = new FameMenuView();
            hallOfFameMenuController = new FameController(hallOfFameMenuView, hallOfFameDAO);
            hallOfFameMenuController.showView();
        }

        if (e.getSource() == view.getInstructionsButton()) {
            instructionsMenuView = new InstructionsView();
            instructionsMenuController = new InstructionsController(instructionsMenuView);
            instructionsMenuController.showView();
        }
    }

    /**
     * Makes the view visible.
     */
    public void showView() {
        view.setVisible(true);
    }

}
