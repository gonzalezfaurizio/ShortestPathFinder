package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.*;
import java.util.*;

/**
 * Implementation of the GameDAO interface.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class GameDAOImpl implements GameDAO {

    /**
     * A list of Game objects managed by this DAO implementation.
     */
    private List<Game> games;

    /**
     * Constructs a new GameDAOImpl with an empty list of games.
     */
    public GameDAOImpl() {
        this.games = new ArrayList<>();
    }

    /**
     * Retrieves a list of all games.
     *
     * @return a list of all Game objects.
     */
    @Override
    public List<Game> getAllGames() {
        return new ArrayList<>(games);
    }

    /**
     * Retrieves a game by its unique ID.
     *
     * @param id the unique ID of the game.
     * @return the Game object with the specified ID, or null if no such game
     * exists.
     */
    @Override
    public Game getGameById(String id) {
        Optional<Game> game = games.stream()
                .filter(g -> String.valueOf(g.getId()).equals(id))
                .findFirst();
        return game.orElse(null);
    }

    /**
     * Adds a new game to the list.
     *
     * @param game the Game object to be added.
     */
    @Override
    public void addGame(Game game) {
        games.add(game);
    }

    /**
     * Updates an existing game in the list.
     *
     * @param game the Game object with updated information.
     */
    @Override
    public void updateGame(Game game) {
        games.replaceAll(g -> String.valueOf(g.getId()).equals(String.valueOf(game.getId())) ? game : g);
    }

    /**
     * Deletes a game by its unique ID from the list.
     *
     * @param id the unique ID of the game to be deleted.
     */
    @Override
    public void deleteGame(String id) {
        games.removeIf(g -> String.valueOf(g.getId()).equals(id));
    }
}
