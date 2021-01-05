package org.deroesch.validation;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * Helper utilities
 */
public class ValidationUtils {

    /**
     * Implements NotNull and positiveOrZero for Integers
     */
    public static Integer positiveOrZero(@NotNull @PositiveOrZero final Integer integer) {
        Objects.requireNonNull(integer);
        if (integer < 0)
            throw new IllegalArgumentException("integer must be >= 0");
        return integer;
    }

}