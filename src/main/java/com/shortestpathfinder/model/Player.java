// File: src/com/shortestpathfinder/model/Player.java
package com.shortestpathfinder.model;

/**
 * Class representing the player.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @authors: - GONZALEZ ALFARO FAURIZIO - RODRIGUEZ GUTIERREZ REBECA - RODRIGUEZ
 * RODRIGUEZ ANDREY ELADIO
 */
public class Player {
    private static int currentId = 0;
    private final int id;
    private String name;

    public Player(String name) {
        this.id = ++currentId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
