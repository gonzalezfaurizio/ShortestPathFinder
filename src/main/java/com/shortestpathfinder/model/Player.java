package com.shortestpathfinder.model;

/**
 * Class representing the player.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIOIO
 */
public class Player {

    /**
     * The current ID counter for all player instances.
     */
    private static int currentId = 0;

    /**
     * The unique ID of this player instance.
     */
    private final int id;

    /**
     * The name of the player.
     */
    private String name;

    /**
     * Constructs a new Player instance with the specified name. The player is
     * assigned a unique ID.
     *
     * @param name the name of the player.
     */
    public Player(String name) {
        this.id = ++currentId;
        this.name = name;
    }

    /**
     * Gets the unique ID of this player instance.
     *
     * @return the player ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the player.
     *
     * @return the player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the player.
     *
     * @param name the new name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of this player instance.
     *
     * @return a string containing the details of this player.
     */
    @Override
    public String toString() {
        return "Player{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
