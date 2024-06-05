// File: src/com/shortestpathfinder/model/Game.java
package com.shortestpathfinder.model;

/**
 * Class representing an instance of the game.
 * 
 * @version 1.0
 * @since 2024-05-21
 * 
 * @authors:
 * - GONZALEZ ALFARO FAURIZIO
 * - RODRIGUEZ GUTIERREZ REBECA
 * - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */


public class Game {
    private static int currentId = 0;
    private final int id;
    private Player player;
    private Maze maze;
    private int currentSteps;
    private String algorithmUsed;
    private boolean completed;

    public Game(Player player, Maze maze) {
        this.id = ++currentId;
        this.player = player;
        this.maze = maze;
        this.currentSteps = 0;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public int getCurrentSteps() {
        return currentSteps;
    }

    public void incrementSteps() {
        this.currentSteps++;
    }

    public String getAlgorithmUsed() {
        return algorithmUsed;
    }

    public void setAlgorithmUsed(String algorithmUsed) {
        this.algorithmUsed = algorithmUsed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCurrentSteps(int currentSteps) {
        this.currentSteps = currentSteps;
    }

@Override
public String toString() {
    return "\nGame Details:\n" +
           "-----------------\n" +
           "Game ID: " + id + "\n" +
           "Player: " + (player != null ? player.getName() : "None") + "\n" +
           "Maze: " + (maze != null ? maze.getName() : "None") + "\n" +
           "Current Steps: " + currentSteps + "\n" +
           "Algorithm Used: " + (algorithmUsed != null ? algorithmUsed : "None") + "\n" +
           "Completed: " + (completed ? "Yes" : "No") + "\n" +
           "-----------------\n";
}
}