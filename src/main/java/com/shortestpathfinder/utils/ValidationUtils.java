package com.shortestpathfinder.utils;

import java.util.regex.Pattern;

/**
 * Utility class for common validations.
 * 
 * @version 1.0
 * @since 2024-05-21
 * 
 * @authors:
 * - GONZALEZ ALFARO FAURIZIO
 * - RODRIGUEZ GUTIERREZ REBECA
 * - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class ValidationUtils {

    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$");

    public static boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }
}
