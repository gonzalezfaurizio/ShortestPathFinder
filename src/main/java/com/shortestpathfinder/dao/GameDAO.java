// File: src/com/shortestpathfinder/dao/GameDAO.java
package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.Game;
import java.util.List;

/**
 * Interface for game data access operations.
 * 
 * @version 1.0
 * @since 2024-05-21
 * 
 * @authors:
 * - GONZALEZ ALFARO FAURIZIO
 * - RODRIGUEZ GUTIERREZ REBECA
 * - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public interface GameDAO {

    List<Game> getAllGames();

    Game getGameById(String id);

    void addGame(Game game);

    void updateGame(Game game);

    void deleteGame(String id);
}
