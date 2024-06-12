package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.Game;
import java.util.List;

/**
 * Interface for game data access operations.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public interface GameDAO {

    /**
     * Retrieves a list of all games.
     *
     * @return a list of all Game objects.
     */
    List<Game> getAllGames();

    /**
     * Retrieves a game by its unique ID.
     *
     * @param id the unique ID of the game.
     * @return the Game object with the specified ID, or null if no such game
     * exists.
     */
    Game getGameById(String id);

    /**
     * Adds a new game.
     *
     * @param game the Game object to be added.
     */
    void addGame(Game game);

    /**
     * Updates an existing game.
     *
     * @param game the Game object with updated information.
     */
    void updateGame(Game game);

    /**
     * Deletes a game by its unique ID.
     *
     * @param id the unique ID of the game to be deleted.
     */
    void deleteGame(String id);
}
