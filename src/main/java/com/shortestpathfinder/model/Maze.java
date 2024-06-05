// File: src/com/shortestpathfinder/model/Maze.java
package com.shortestpathfinder.model;

/**
 * Class representing a maze.
 * 
 * @version 1.0
 * @since 2024-05-21
 * 
 * @authors:
 * - GONZALEZ ALFARO FAURIZIO
 * - RODRIGUEZ GUTIERREZ REBECA
 * - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class Maze {
    private static int currentId = 0;
    private final int id;
    private String code;
    private String name;
    private String difficulty;
    private char[][] grid;

    public Maze(String code, String name, String difficulty, char[][] grid) {
        this.id = ++currentId;
        this.code = code;
        this.name = name;
        this.difficulty = difficulty;
        this.grid = grid;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    @Override
    public String toString() {
        return "Maze{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}