// File: src/com/shortestpathfinder/algorithms/PathfindingAlgorithm.java
package com.shortestpathfinder.algorithms;

/**
 * Interface for pathfinding algorithms.
 * 
 * @version 1.0
 * @since 2024-05-21
 * 
 * @authors:
 * - GONZALEZ ALFARO FAURIZIO
 * - RODRIGUEZ GUTIERREZ REBECA
 * - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public interface PathfindingAlgorithm {

    /**
     * Finds the path in the given maze.
     *
     * @param maze The maze to search.
     * @return The path found, or null if no path exists.
     */
    int[][] findPath(char[][] maze);
}
