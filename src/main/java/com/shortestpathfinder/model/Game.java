package com.shortestpathfinder.model;

/**
 * Class representing an instance of the game.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class Game {

    /**
     * The current ID counter for all game instances.
     */
    private static int currentId = 0;

    /**
     * The unique ID of this game instance.
     */
    private final int id;

    /**
     * The player participating in the game.
     */
    private Player player;

    /**
     * The maze that the player is attempting to solve.
     */
    private Maze maze;

    /**
     * The current number of steps taken by the player.
     */
    private int currentSteps;

    /**
     * The name of the algorithm used to solve the maze.
     */
    private String algorithmUsed;

    /**
     * Indicates whether the maze has been completed.
     */
    private boolean completed;

    /**
     * Constructs a new Game instance with the specified player and maze. The
     * game is assigned a unique ID and initialized with zero steps and not
     * completed.
     *
     * @param player the player participating in the game.
     * @param maze the maze to be solved.
     */
    public Game(Player player, Maze maze) {
        this.id = ++currentId;
        this.player = player;
        this.maze = maze;
        this.currentSteps = 0;
        this.completed = false;
    }

    /**
     * Gets the unique ID of this game instance.
     *
     * @return the game ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the player participating in the game.
     *
     * @return the player.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets the player participating in the game.
     *
     * @param player the new player.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets the maze to be solved.
     *
     * @return the maze.
     */
    public Maze getMaze() {
        return maze;
    }

    /**
     * Sets the maze to be solved.
     *
     * @param maze the new maze.
     */
    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    /**
     * Gets the current number of steps taken by the player.
     *
     * @return the current steps.
     */
    public int getCurrentSteps() {
        return currentSteps;
    }

    /**
     * Increments the current number of steps taken by the player by one.
     */
    public void incrementSteps() {
        this.currentSteps++;
    }

    /**
     * Gets the name of the algorithm used to solve the maze.
     *
     * @return the algorithm name.
     */
    public String getAlgorithmUsed() {
        return algorithmUsed;
    }

    /**
     * Sets the name of the algorithm used to solve the maze.
     *
     * @param algorithmUsed the new algorithm name.
     */
    public void setAlgorithmUsed(String algorithmUsed) {
        this.algorithmUsed = algorithmUsed;
    }

    /**
     * Checks if the maze has been completed.
     *
     * @return true if the maze is completed, false otherwise.
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets the completion status of the maze.
     *
     * @param completed the new completion status.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Sets the current number of steps taken by the player.
     *
     * @param currentSteps the new number of steps.
     */
    public void setCurrentSteps(int currentSteps) {
        this.currentSteps = currentSteps;
    }

    /**
     * Returns a string representation of this game instance.
     *
     * @return a string containing the details of this game.
     */
    @Override
    public String toString() {
        return "\nGame Details:\n"
                + "-----------------\n"
                + "Game ID: " + id + "\n"
                + "Player: " + (player != null ? player.getName() : "None") + "\n"
                + "Maze: " + (maze != null ? maze.getName() : "None") + "\n"
                + "Current Steps: " + currentSteps + "\n"
                + "Algorithm Used: " + (algorithmUsed != null ? algorithmUsed : "None") + "\n"
                + "Completed: " + (completed ? "Yes" : "No") + "\n"
                + "-----------------\n";
    }
}
