package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.Player;
import java.util.List;

/**
 * Interface for player data access operations.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public interface PlayerDAO {

    /**
     * Retrieves a list of all players.
     *
     * @return a list of all Player objects.
     */
    List<Player> getAllPlayers();

    /**
     * Retrieves a player by its unique ID.
     *
     * @param id the unique ID of the player.
     * @return the Player object with the specified ID, or null if no such
     * player exists.
     */
    Player getPlayerById(String id);

    /**
     * Adds a new player.
     *
     * @param player the Player object to be added.
     */
    void addPlayer(Player player);

    /**
     * Updates an existing player.
     *
     * @param player the Player object with updated information.
     */
    void updatePlayer(Player player);

    /**
     * Deletes a player by its unique ID.
     *
     * @param id the unique ID of the player to be deleted.
     */
    void deletePlayer(String id);

    /**
     * Checks if a player name is already taken.
     *
     * @param playerName the name to be checked.
     * @return true if the player name is already taken, false otherwise.
     */
    boolean isPlayerNameTaken(String playerName);
}
