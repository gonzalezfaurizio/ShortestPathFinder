package com.shortestpathfinder.algorithms;

/**
 * Interface for pathfinding algorithms.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
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
