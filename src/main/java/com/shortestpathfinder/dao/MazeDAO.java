package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.Maze;
import java.util.List;

/**
 * Interface for maze data access operations.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public interface MazeDAO {

    /**
     * Retrieves a list of all mazes.
     *
     * @return a list of all Maze objects.
     */
    List<Maze> getAllMazes();

    /**
     * Retrieves a maze by its unique ID.
     *
     * @param id the unique ID of the maze.
     * @return the Maze object with the specified ID, or null if no such maze
     * exists.
     */
    Maze getMazeById(String id);

    /**
     * Adds a new maze.
     *
     * @param maze the Maze object to be added.
     */
    void addMaze(Maze maze);

    /**
     * Updates an existing maze.
     *
     * @param maze the Maze object with updated information.
     */
    void updateMaze(Maze maze);

    /**
     * Deletes a maze by its unique ID.
     *
     * @param id the unique ID of the maze to be deleted.
     */
    void deleteMaze(String id);
}
