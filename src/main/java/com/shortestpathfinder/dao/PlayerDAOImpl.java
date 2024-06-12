package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.*;
import java.util.*;

/**
 * Implementation of the MazeDAO interface.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class PlayerDAOImpl implements PlayerDAO {

    /**
     * A list of Player objects managed by this DAO implementation.
     */
    private List<Player> players;

    /**
     * Constructs a new PlayerDAOImpl with an empty list of players.
     */
    public PlayerDAOImpl() {

        this.players = new ArrayList<>();

        Player Manfred = new Player("Manfred");
        Player Faurizio = new Player("Faurizio");
        Player Rebecca = new Player("Rebecca");
        Player Andrey = new Player("Andrey");

        this.addPlayer(Manfred);
        this.addPlayer(Faurizio);
        this.addPlayer(Rebecca);
        this.addPlayer(Andrey);

    }

    /**
     * Retrieves a list of all players.
     *
     * @return a list of all Player objects.
     */
    @Override
    public List<Player> getAllPlayers() {
        return new ArrayList<>(players);
    }

    /**
     * Retrieves a player by its unique ID.
     *
     * @param id the unique ID of the player.
     * @return the Player object with the specified ID, or null if no such
     * player exists.
     */
    @Override
    public Player getPlayerById(String id) {
        Optional<Player> player = players.stream()
                .filter(p -> String.valueOf(p.getId()).equals(id))
                .findFirst();
        return player.orElse(null);
    }

    /**
     * Adds a new player to the list.
     *
     * @param player the Player object to be added.
     */
    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Updates an existing player in the list.
     *
     * @param player the Player object with updated information.
     */
    @Override
    public void updatePlayer(Player player) {
        players.replaceAll(p -> String.valueOf(p.getId()).equals(String.valueOf(player.getId())) ? player : p);
    }

    /**
     * Deletes a player by its unique ID from the list.
     *
     * @param id the unique ID of the player to be deleted.
     */
    @Override
    public void deletePlayer(String id) {
        players.removeIf(p -> String.valueOf(p.getId()).equals(id));
    }

    /**
     * Checks if a player name is already taken.
     *
     * @param playerName the name to be checked.
     * @return true if the player name is already taken, false otherwise.
     */
    @Override
    public boolean isPlayerNameTaken(String playerName) {
        return players.stream().anyMatch(p -> p.getName().equalsIgnoreCase(playerName));
    }
}
