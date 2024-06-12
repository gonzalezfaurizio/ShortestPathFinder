package com.shortestpathfinder.utils;

import java.io.File;

/**
 * Utility class for file operations.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class FileUtils {

    /**
     * Checks if the provided file is a valid JSON file.
     *
     * @param file the file to be checked.
     * @return true if the file is not null, exists, is a file, and has a
     * ".json" extension; false otherwise.
     */
    public static boolean isValidJsonFile(File file) {
        return file != null && file.exists() && file.isFile() && file.getName().endsWith(".json");
    }
}
