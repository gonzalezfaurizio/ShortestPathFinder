package com.shortestpathfinder.model;

/**
 * Class representing a maze.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class Maze {

    /**
     * The current ID counter for all maze instances.
     */
    private static int currentId = 0;

    /**
     * The unique ID of this maze instance.
     */
    private final int id;

    /**
     * The code of the maze.
     */
    private String code;

    /**
     * The name of the maze.
     */
    private String name;

    /**
     * The difficulty level of the maze.
     */
    private String difficulty;

    /**
     * The grid structure of the maze.
     */
    private char[][] grid;

    /**
     * Constructs a new Maze instance with the specified code, name, difficulty
     * level, and grid. The maze is assigned a unique ID.
     *
     * @param code the code of the maze.
     * @param name the name of the maze.
     * @param difficulty the difficulty level of the maze.
     * @param grid the grid structure of the maze.
     */
    public Maze(String code, String name, String difficulty, char[][] grid) {
        this.id = ++currentId;
        this.code = code;
        this.name = name;
        this.difficulty = difficulty;
        this.grid = grid;
    }

    /**
     * Gets the unique ID of this maze instance.
     *
     * @return the maze ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the code of the maze.
     *
     * @return the code of the maze.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code of the maze.
     *
     * @param code the new code of the maze.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the name of the maze.
     *
     * @return the name of the maze.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the maze.
     *
     * @param name the new name of the maze.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the difficulty level of the maze.
     *
     * @return the difficulty level of the maze.
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty level of the maze.
     *
     * @param difficulty the new difficulty level of the maze.
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets the grid structure of the maze.
     *
     * @return the grid structure of the maze.
     */
    public char[][] getGrid() {
        return grid;
    }

    /**
     * Sets the grid structure of the maze.
     *
     * @param grid the new grid structure of the maze.
     */
    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns a string representation of this maze instance.
     *
     * @return a string containing the details of this maze.
     */
    @Override
    public String toString() {
        return "Maze{"
                + "id=" + id
                + ", code='" + code + '\''
                + ", name='" + name + '\''
                + ", difficulty='" + difficulty + '\''
                + '}';
    }
}
