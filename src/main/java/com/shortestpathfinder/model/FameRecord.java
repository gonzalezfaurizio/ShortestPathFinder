// File: src/com/shortestpathfinder/model/FameRecord.java
package com.shortestpathfinder.model;

/**
 * Class representing a record in the Hall of Fame.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @authors: - GONZALEZ ALFARO FAURIZIO - RODRIGUEZ GUTIERREZ REBECA - RODRIGUEZ
 * RODRIGUEZ ANDREY ELADIO
 */
public class FameRecord {

    private static int currentId = 0;
    private final int id;
    private String playerName;
    private String mazeName;
    private int steps;
    private String algorithmName;

    public FameRecord(String playerName, String mazeName, int steps, String algorithmName) {
        this.id = ++currentId;
        this.playerName = playerName;
        this.mazeName = mazeName;
        this.steps = steps;
        this.algorithmName = algorithmName;
    }

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getMazeName() {
        return mazeName;
    }

    public void setMazeName(String mazeName) {
        this.mazeName = mazeName;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

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
