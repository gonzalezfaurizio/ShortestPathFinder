// File: src/com/shortestpathfinder/dao/MazeDAOImpl.java
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
public class MazeDAOImpl implements MazeDAO {

    private List<Maze> mazes;

    public MazeDAOImpl() {
        this.mazes = new ArrayList<>();

        Maze maze1 = new Maze("maze1", "Simple Maze", "Easy", new char[][]{
            {'S', ' ', 'X', ' ', 'E'},
            {'X', ' ', 'X', ' ', 'X'},
            {' ', ' ', ' ', ' ', ' '},
            {'X', 'X', 'X', ' ', 'X'},
            {' ', ' ', ' ', ' ', ' '}
        });

        Maze maze2 = new Maze("maze2", "Medium Maze", "Medium", new char[][]{
            {'S', ' ', 'X', ' ', ' ', ' ', 'X', 'E'},
            {'X', ' ', 'X', ' ', 'X', ' ', 'X', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'X', ' '},
            {'X', 'X', 'X', 'X', 'X', ' ', 'X', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'X', ' '},
            {' ', 'X', 'X', 'X', 'X', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', 'X', 'X', 'X', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' '}
        });
        Maze maze3 = new Maze("maze3", "Complex Maze", "Hard", new char[][]{
            {'S', 'X', 'X', 'X', ' ', ' ', 'X', 'E'},
            {' ', ' ', ' ', 'X', ' ', 'X', 'X', 'X'},
            {'X', 'X', ' ', 'X', ' ', 'X', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', 'X', 'X', ' '},
            {'X', 'X', 'X', 'X', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X'},
            {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'X', 'X', 'X', 'X', 'X', ' '}
        });

        Maze mazeHard = new Maze("mazeHard", "Extreme Maze", "Very Hard", new char[][]{
            {'S', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'E'},
            {' ', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', 'X', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' '},
            {'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X', ' ', 'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', 'X', ' ', 'X'},
            {' ', ' ', ' ', 'X', ' ', ' ', 'X', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', ' ', 'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', 'X', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', 'X', ' ', ' ', ' ', 'X', ' ', ' ', 'X', ' '},
            {' ', 'X', ' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', ' ', ' ', ' ', 'X', ' ', 'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', 'X'},
            {' ', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', 'X', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' '},
            {' ', 'X', ' ', 'X', 'X', ' ', 'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', ' ', ' ', 'X', ' ', 'X', ' ', ' ', 'X', ' ', 'X', ' '},
            {' ', 'X', ' ', ' ', ' ', 'X', ' ', 'X', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' '},
            {'X', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', ' ', 'X', ' ', 'X', ' ', ' ', 'X', 'X', ' ', ' ', ' ', 'X'},
            {' ', ' ', 'X', ' ', ' ', 'X', ' ', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', ' ', 'X', ' ', ' ', ' ', 'X', 'X'},
            {' ', ' ', ' ', 'X', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', 'X', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' '},
            {' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', 'X'},
            {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' '}
        });

        this.addMaze(maze1);
        this.addMaze(maze2);
        this.addMaze(maze3);
        this.addMaze(mazeHard);
    }

    @Override
    public List<Maze> getAllMazes() {
        return new ArrayList<>(mazes);
    }

    @Override
    public Maze getMazeById(String id) {
        Optional<Maze> maze = mazes.stream()
                .filter(m -> String.valueOf(m.getId()).equals(id))
                .findFirst();
        return maze.orElse(null);
    }

    @Override
    public void addMaze(Maze maze) {
        mazes.add(maze);
    }

    @Override
    public void updateMaze(Maze maze) {
        mazes.replaceAll(m -> String.valueOf(m.getId()).equals(String.valueOf(maze.getId())) ? maze : m);
    }

    @Override
    public void deleteMaze(String id) {
        mazes.removeIf(m -> String.valueOf(m.getId()).equals(id));
    }
}
