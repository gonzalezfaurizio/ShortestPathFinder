package com.shortestpathfinder.utils;

import java.util.regex.Pattern;

/**
 * Utility class for common validations.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class ValidationUtils {

    /**
     * Pattern to validate names consisting of alphabetic characters, including
     * accented characters and the letter 'ñ'.
     */
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$");

    /**
     * Validates if the given name matches the defined pattern.
     *
     * @param name the name to be validated.
     * @return true if the name matches the pattern; false otherwise.
     */
    public static boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }
}
