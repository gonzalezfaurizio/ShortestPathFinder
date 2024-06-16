package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.*;
import java.util.*;

/**
 * Implementation of the MazeDAO interface.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class MazeDAOImpl implements MazeDAO {

    /**
     * A list of Maze objects managed by this DAO implementation.
     */
    private List<Maze> mazes;

    /**
     * Constructs a new MazeDAOImpl with an empty list of mazes.
     */
    public MazeDAOImpl() {
        this.mazes = new ArrayList<>();

        Maze maze1 = new Maze("maze1", "Simple Maze", "Easy", new char[][]{
            {'S', ' ', 'X', ' ', ' '},
            {'X', ' ', 'X', ' ', 'X'},
            {' ', ' ', ' ', ' ', ' '},
            {'X', 'X', 'X', ' ', 'X'},
            {' ', ' ', ' ', ' ', 'E'}
        });

        Maze maze2 = new Maze("maze2", "Medium Maze", "Medium", new char[][]{
            {'S', ' ', 'X', ' ', ' ', ' ', 'X', ' '},
            {'X', ' ', 'X', ' ', 'X', ' ', 'X', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'X', ' '},
            {'X', 'X', 'X', 'X', 'X', ' ', 'X', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'X', ' '},
            {' ', 'X', 'X', 'X', 'X', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', 'X', 'X', 'X', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' ', 'E'}
        });
        Maze maze3 = new Maze("maze3", "Complex Maze", "Hard", new char[][]{
            {'S', 'X', 'X', 'X', ' ', ' ', 'X', ' '},
            {' ', ' ', ' ', 'X', ' ', 'X', 'X', 'X'},
            {'X', 'X', ' ', 'X', ' ', 'X', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', 'X', 'X', ' '},
            {'X', 'X', 'X', 'X', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X'},
            {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'X', 'X', 'X', 'X', 'X', 'E'}
        });

        Maze mazeHard = new Maze("mazeHard", "Extreme Maze", "Very Hard", new char[][]{
            {'S', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' '},
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
            {' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'E'}
        });

        this.addMaze(maze1);
        this.addMaze(maze2);
        this.addMaze(maze3);
        this.addMaze(mazeHard);
    }

    /**
     * Retrieves a list of all mazes.
     *
     * @return a list of all Maze objects.
     */
    @Override
    public List<Maze> getAllMazes() {
        return new ArrayList<>(mazes);
    }

    /**
     * Retrieves a maze by its unique ID.
     *
     * @param id the unique ID of the maze.
     * @return the Maze object with the specified ID, or null if no such maze
     * exists.
     */
    @Override
    public Maze getMazeById(String id) {
        Optional<Maze> maze = mazes.stream()
                .filter(m -> String.valueOf(m.getId()).equals(id))
                .findFirst();
        return maze.orElse(null);
    }

    /**
     * Adds a new maze to the list.
     *
     * @param maze the Maze object to be added.
     */
    @Override
    public void addMaze(Maze maze) {
        mazes.add(maze);
    }

    /**
     * Updates an existing maze in the list.
     *
     * @param maze the Maze object with updated information.
     */
    @Override
    public void updateMaze(Maze maze) {
        mazes.replaceAll(m -> String.valueOf(m.getId()).equals(String.valueOf(maze.getId())) ? maze : m);
    }

    /**
     * Deletes a maze by its unique ID from the list.
     *
     * @param id the unique ID of the maze to be deleted.
     */
    @Override
    public void deleteMaze(String id) {
        mazes.removeIf(m -> String.valueOf(m.getId()).equals(id));
    }
}
