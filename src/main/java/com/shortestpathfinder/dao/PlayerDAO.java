// File: src/com/shortestpathfinder/dao/PlayerDAO.java
package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.Player;
import java.util.List;

/**
 * Interface for player data access operations.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @authors: - GONZALEZ ALFARO FAURIZIO - RODRIGUEZ GUTIERREZ REBECA - RODRIGUEZ
 * RODRIGUEZ ANDREY ELADIO
 */
public interface PlayerDAO {

    List<Player> getAllPlayers();

    Player getPlayerById(String id);

    void addPlayer(Player player);

    void updatePlayer(Player player);

    void deletePlayer(String id);

    boolean isPlayerNameTaken(String playerName);
}
