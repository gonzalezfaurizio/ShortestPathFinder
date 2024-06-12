package com.shortestpathfinder.utils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

/**
 * Utility class for handling JSON operations.
 *
 * @version 2.0
 * @since 2024-05-21
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
     * Converts an object to a JSON file.
     *
     * @param filePath the path to the JSON file.
     * @param object the object to be converted to JSON.
     * @param <T> the type of the object.
     * @throws IOException if there is an error writing to the file.
     * @throws JsonIOException if there is an error during JSON serialization.
     */
    public static <T> void toJson(String filePath, T object) throws IOException, JsonIOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(object, writer);
        }
    }

    /**
     * Validates the structure of a JSON file representing a Maze.
     *
     * @param filePath the path to the JSON file.
     * @return true if the JSON structure is valid, false otherwise.
     * @throws IOException if there is an error reading the file.
     * @throws JsonSyntaxException if the JSON is not valid.
     */
    public static boolean validateJsonStructure(String filePath) throws IOException, JsonSyntaxException {
        try (FileReader reader = new FileReader(filePath)) {
            Maze maze = gson.fromJson(reader, Maze.class);
            return maze != null && maze.isValid();
        }
    }

    /**
     * Represents a Maze with validation capabilities.
     */
    private static class Maze {

        private String code;
        private String name;
        private String difficulty;
        private List<List<String>> grid;

        /**
         * Validates the Maze structure.
         *
         * @return true if the Maze contains valid data, false otherwise.
         */
        public boolean isValid() {
            if (code == null || name == null || difficulty == null || grid == null) {
                return false;
            }

            boolean hasStart = false;
            boolean hasEnd = false;

            for (List<String> row : grid) {
                for (String cell : row) {
                    if ("S".equals(cell)) {
                        hasStart = true;
                    } else if ("E".equals(cell)) {
                        hasEnd = true;
                    }
                }
            }

            return hasStart && hasEnd;
        }
    }
}
