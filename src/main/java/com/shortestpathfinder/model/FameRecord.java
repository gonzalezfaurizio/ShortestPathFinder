package com.shortestpathfinder.model;

/**
 * Class representing a record in the Hall of Fame.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class FameRecord {

    /**
     * The current ID counter for all fame records.
     */
    private static int currentId = 0;

    /**
     * The unique ID of this fame record.
     */
    private final int id;

    /**
     * The name of the player.
     */
    private String playerName;

    /**
     * The name of the maze completed by the player.
     */
    private String mazeName;

    /**
     * The number of steps taken by the player to complete the maze.
     */
    private int steps;

    /**
     * The name of the algorithm used by the player to solve the maze.
     */
    private String algorithmName;

    /**
     * Constructs a new FameRecord with the specified player name, maze name,
     * steps, and algorithm name. The record is assigned a unique ID.
     *
     * @param playerName the name of the player.
     * @param mazeName the name of the maze.
     * @param steps the number of steps taken to complete the maze.
     * @param algorithmName the name of the algorithm used.
     */
    public FameRecord(String playerName, String mazeName, int steps, String algorithmName) {
        this.id = ++currentId;
        this.playerName = playerName;
        this.mazeName = mazeName;
        this.steps = steps;
        this.algorithmName = algorithmName;
    }

    /**
     * Gets the unique ID of this fame record.
     *
     * @return the ID of this fame record.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the player.
     *
     * @return the player's name.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets the name of the player.
     *
     * @param playerName the new name of the player.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Gets the name of the maze.
     *
     * @return the maze's name.
     */
    public String getMazeName() {
        return mazeName;
    }

    /**
     * Sets the name of the maze.
     *
     * @param mazeName the new name of the maze.
     */
    public void setMazeName(String mazeName) {
        this.mazeName = mazeName;
    }

    /**
     * Gets the number of steps taken to complete the maze.
     *
     * @return the number of steps.
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Sets the number of steps taken to complete the maze.
     *
     * @param steps the new number of steps.
     */
    public void setSteps(int steps) {
        this.steps = steps;
    }

    /**
     * Gets the name of the algorithm used to solve the maze.
     *
     * @return the algorithm's name.
     */
    public String getAlgorithmName() {
        return algorithmName;
    }

    /**
     * Sets the name of the algorithm used to solve the maze.
     *
     * @param algorithmName the new name of the algorithm.
     */
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    /**
     * Returns a string representation of this fame record.
     *
     * @return a string containing the details of this fame record.
     */
    @Override
    public String toString() {
        return "Fame Record Details:\n"
                + "---------------------\n"
                + "ID: " + id + "\n"
                + "Player Name: " + playerName + "\n"
                + "Maze Name: " + mazeName + "\n"
                + "Steps Taken: " + steps + "\n"
                + "Algorithm Used: " + algorithmName + "\n"
                + "---------------------\n";
    }
}
