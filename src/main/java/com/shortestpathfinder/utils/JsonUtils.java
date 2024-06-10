// File: src/com/shortestpathfinder/utils/JsonUtils.java
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
 * @version 1.0
 * @since 2024-05-21
 *
 * @authors: - GONZALEZ ALFARO FAURIZIO - RODRIGUEZ GUTIERREZ REBECA - RODRIGUEZ
 * RODRIGUEZ ANDREY ELADIO
 */
public class JsonUtils {

    private static final Gson gson = new Gson();

    public static <T> T fromJson(String filePath, Class<T> classOfT) throws IOException, JsonSyntaxException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, classOfT);
        }
    }

    public static <T> void toJson(String filePath, T object) throws IOException, JsonIOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(object, writer);
        }
    }

    public static boolean validateJsonStructure(String filePath) throws IOException, JsonSyntaxException {
        try (FileReader reader = new FileReader(filePath)) {
            Maze maze = gson.fromJson(reader, Maze.class);
            return maze != null && maze.isValid();
        }
    }

    private static class Maze {

        private String code;
        private String name;
        private String difficulty;
        private List<List<String>> grid;

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
