// File: src/com/shortestpathfinder/controller/GameMenuController.java
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
 * @author: - GONZALEZ ALFARO FAURIZIO
 * @author: - RODRIGUEZ GUTIERREZ REBECA
 * @author: - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class GameMenuController implements ActionListener {

    private GameMenuView view;
    private SignUpView signUpView;
    private SelectMaze selectMazeView;
    private StartGame startGameView;

    private SignUpController signUpMenuController;
    private MazeController selectMazeController;
    private GameController gameController;

    private GameDAO gameDAO;
    private PlayerDAO playerDAO;
    private MazeDAO mazeDAO;
    private HallOfFameDAO hallOfFameDAO;

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

    public void showView() {
        view.setVisible(true);
    }
}
