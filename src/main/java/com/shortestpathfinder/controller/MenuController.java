// File: src/com/shortestpathfinder/controller/MainMenuController.java
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
 * @author: - GONZALEZ ALFARO FAURIZIO
 * @author: - RODRIGUEZ GUTIERREZ REBECA
 * @author: - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class MenuController implements ActionListener {

    //-- Atributos --//
    private MenuView view;
    
    private GameMenuView gameMenuView;
    private FameMenuView hallOfFameMenuView;
    private InstructionsView instructionsMenuView;
    private ExitView exitConfirmationView;
    private SelectMaze selectMazeView;
    private StartGame startGameView;

    private GameMenuController gameMenuController;
    private FameController hallOfFameMenuController;
    private InstructionsController instructionsMenuController;
    private ExitController exitConfirmationController;
    private MazeController selectMazeController;
    private GameController gameController;

    private PlayerDAO playerDAO;
    private GameDAO gameDAO;
    private HallOfFameDAO hallOfFameDAO;
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
     * Método para mostrar la vista principal.
     */
    public void showView() {
        view.setVisible(true);
    }

    /**
     * Maneja los eventos de acción de los botones del menú principal.
     *
     * @param e evento de acción
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
            gameMenuController = new GameMenuController(gameMenuView, gameDAO, playerDAO, mazeDAO,hallOfFameDAO);
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
}
