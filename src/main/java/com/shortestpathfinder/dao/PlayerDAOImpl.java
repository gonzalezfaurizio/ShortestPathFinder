// File: src/com/shortestpathfinder/dao/PlayerDAOImpl.java
package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.*;
import java.util.*;

/**
 * Implementation of the MazeDAO interface.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @authors: - GONZALEZ ALFARO FAURIZIO - RODRIGUEZ GUTIERREZ REBECA - RODRIGUEZ
 * RODRIGUEZ ANDREY ELADIO
 */
public class PlayerDAOImpl implements PlayerDAO {

    private List<Player> players;

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

    @Override
    public List<Player> getAllPlayers() {
        return new ArrayList<>(players);
    }

    @Override
    public Player getPlayerById(String id) {
        Optional<Player> player = players.stream()
                .filter(p -> String.valueOf(p.getId()).equals(id))
                .findFirst();
        return player.orElse(null);
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void updatePlayer(Player player) {
        players.replaceAll(p -> String.valueOf(p.getId()).equals(String.valueOf(player.getId())) ? player : p);
    }

    @Override
    public void deletePlayer(String id) {
        players.removeIf(p -> String.valueOf(p.getId()).equals(id));
    }

    @Override
    public boolean isPlayerNameTaken(String playerName) {
        return players.stream().anyMatch(p -> p.getName().equalsIgnoreCase(playerName));
    }
}
