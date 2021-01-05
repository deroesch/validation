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
        Objects.requireNonNull(integer, "argument must be non-null");
        if (integer < 0)
            throw new IllegalArgumentException("argument must be >= 0");
        return integer;
    }

}