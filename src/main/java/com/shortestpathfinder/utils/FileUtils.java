// File: src/com/shortestpathfinder/utils/FileUtils.java
package com.shortestpathfinder.utils;

import java.io.File;

/**
 * Utility class for file operations.
 * 
 * @version 1.0
 * @since 2024-05-21
 * 
 * @authors:
 * - GONZALEZ ALFARO FAURIZIO
 * - RODRIGUEZ GUTIERREZ REBECA
 * - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class FileUtils {

    public static boolean isValidJsonFile(File file) {
        return file != null && file.exists() && file.isFile() && file.getName().endsWith(".json");
    }
}
