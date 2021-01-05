package org.deroesch.validation;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * Experiments with arg validation
 */
public class Validation implements Cloneable {

    public Validation(@NotNull @PositiveOrZero final Integer integer, @NotNull final String string) {
        setInteger(integer);
        setString(string);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @return the integer
     */
    @NotNull
    @PositiveOrZero
    public Integer getInteger() {
        return ValidationUtils.positiveOrZero(integer);
    }

    /**
     * @param integer the integer to set
     */
    public void setInteger(@NotNull @PositiveOrZero final Integer integer) {
        this.integer = ValidationUtils.positiveOrZero(integer);
    }

    /**
     * @return the string
     */
    @NotNull
    public String getString() {
        return Objects.requireNonNull(string);
    }

    /**
     * @param string the string to set
     */
    public void setString(@NotNull final String string) {
        this.string = Objects.requireNonNull(string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(integer, string);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Validation)) {
            return false;
        }
        final Validation other = (Validation) obj;
        return Objects.equals(integer, other.integer) && Objects.equals(string, other.string);
    }

    @NotNull
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Validation [integer=");
        builder.append(integer);
        builder.append(", string=");
        builder.append(string);
        builder.append("]");
        return builder.toString();
    }

    @NotNull
    @PositiveOrZero
    Integer integer;

    @NotNull
    String string;

}
