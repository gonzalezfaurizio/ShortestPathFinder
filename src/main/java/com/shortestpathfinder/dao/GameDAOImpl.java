// File: src/com/shortestpathfinder/dao/GameDAOImpl.java
package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.*;
import java.util.*;

/**
 * Implementation of the GameDAO interface.
 * 
 * @version 1.0
 * @since 2024-05-21
 * 
 * @authors:
 * - GONZALEZ ALFARO FAURIZIO
 * - RODRIGUEZ GUTIERREZ REBECA
 * - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class GameDAOImpl implements GameDAO {
    private List<Game> games;

    public GameDAOImpl() {
        this.games = new ArrayList<>();
    }

    @Override
    public List<Game> getAllGames() {
        return new ArrayList<>(games);
    }

    @Override
    public Game getGameById(String id) {
        Optional<Game> game = games.stream()
                                   .filter(g -> String.valueOf(g.getId()).equals(id))
                                   .findFirst();
        return game.orElse(null);
    }

    @Override
    public void addGame(Game game) {
        games.add(game);
    }

    @Override
    public void updateGame(Game game) {
        games.replaceAll(g -> String.valueOf(g.getId()).equals(String.valueOf(game.getId())) ? game : g);
    }

    @Override
    public void deleteGame(String id) {
        games.removeIf(g -> String.valueOf(g.getId()).equals(id));
    }
}