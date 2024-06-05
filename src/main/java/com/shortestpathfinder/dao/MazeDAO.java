// File: src/com/shortestpathfinder/dao/MazeDAO.java
package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.Maze;
import java.util.List;

/**
 * Interface for maze data access operations.
 * 
 * @version 1.0
 * @since 2024-05-21
 * 
 * @authors:
 * - GONZALEZ ALFARO FAURIZIO
 * - RODRIGUEZ GUTIERREZ REBECA
 * - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public interface MazeDAO {

    List<Maze> getAllMazes();

    Maze getMazeById(String id);

    void addMaze(Maze maze);

    void updateMaze(Maze maze);

    void deleteMaze(String id);
}
