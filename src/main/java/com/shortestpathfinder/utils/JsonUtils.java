package com.shortestpathfinder.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.shortestpathfinder.dao.MazeDAOImpl;

import java.io.FileReader;
import java.io.IOException;

/**
 * Utility class for handling JSON operations.
 *
 * @version 2.0
 * @since 2024-05-21
 *
 * Provides methods to convert JSON files to objects and validate the structure
 * of JSON files representing Mazes.
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class JsonUtils {

    /**
     * Gson instance for JSON operations. This instance is thread-safe and can
     * be reused across multiple operations.
     */
    private static final Gson gson = new Gson();

    /**
     * Converts a JSON file to an object of the specified class.
     *
     * @param filePath the path to the JSON file.
     * @param classOfT the class of the object to be returned.
     * @param <T> the type of the object to be returned.
     * @return an object of type T populated with the data from the JSON file.
     * @throws IOException if there is an error reading the file.
     * @throws JsonSyntaxException if the JSON is not valid.
     */
    public static <T> T fromJson(String filePath, Class<T> classOfT) throws IOException, JsonSyntaxException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, classOfT);
        }
    }

    /**
     * Validates the structure of a JSON file representing a Maze.
     *
     * @param filePath the path to the JSON file.
     * @param mazeDAO the Maze data access object for database operations.
     * @return true if the JSON structure is valid, false otherwise.
     * @throws IOException if there is an error reading the file.
     * @throws JsonSyntaxException if the JSON is not valid.
     */
    public static boolean validateJsonStructure(String filePath, MazeDAOImpl mazeDAO) throws IOException, JsonSyntaxException {
        try (FileReader reader = new FileReader(filePath)) {
            Maze maze = gson.fromJson(reader, Maze.class);
            if (maze == null) {
                return false;
            }

            if (mazeDAO.getMazeByCode(maze.getCode()) != null) {
                return false; // Maze already exists
            }

            // Validate that code, name, difficulty, and grid are not null
            if (maze.getCode() == null || maze.getName() == null || maze.getDifficulty() == null || maze.getGrid() == null) {
                return false;
            }

            // Extract row and column size from the first row
            char[][] grid = maze.getGrid();
            int rowSize = grid.length;
            int colSize = grid[0].length;

            int startCount = 0;
            int endCount = 0;

            for (char[] row : grid) {
                if (row.length != colSize) {
                    return false; // Inconsistent column size
                }
                for (char cell : row) {
                    if (cell == 'S' || cell == 'P') {
                        startCount++;
                    } else if (cell == 'E' || cell == 'Z') {
                        endCount++;
                    }
                }
            }

            // Ensure only one start and one end point
            return startCount == 1 && endCount == 1;
        }
    }

    /**
     * Private inner class representing a Maze.
     */
    private static class Maze {

        /**
         * The unique code of the maze.
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
         * The 2D character array representing the maze grid.
         */
        private char[][] grid;

        /**
         * Returns the unique code of the maze.
         *
         * @return the maze code.
         */
        public String getCode() {
            return code;
        }

        /**
         * Returns the name of the maze.
         *
         * @return the maze name.
         */
        public String getName() {
            return name;
        }

        /**
         * Returns the difficulty level of the maze.
         *
         * @return the maze difficulty level.
         */
        public String getDifficulty() {
            return difficulty;
        }

        /**
         * Returns the 2D character array representing the maze grid.
         *
         * @return the maze grid.
         */
        public char[][] getGrid() {
            return grid;
        }
    }
}
