/**
 *
 */
package org.deroesch.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Experiments with arg validation
 */
class ValidationTest {

    private static final int TEN = 10;
    private static final String HELLO = "hello";
    private Validation v;

    @BeforeEach
    void setup() {
        v = new Validation(TEN, HELLO);
    }

    /**
     * Test method for {@link org.deroesch.validation.Validation#hashCode()}.
     *
     * @throws CloneNotSupportedException
     */
    @Test
    void testHashCode() throws CloneNotSupportedException {
        final ValidationUtils v1 = (ValidationUtils) v.clone();
        final ValidationUtils v2 = (ValidationUtils) v.clone();

        assertEquals(v1.hashCode(), v2.hashCode());
    }

    /**
     * Test method for
     * {@link org.deroesch.validation.Validation#Validation(java.lang.Integer, java.lang.String)}.
     */
    @Test
    void testFieldConstructor() {
        final int int15 = 15;
        final String string15 = "Fifteen";

        v = new Validation(int15, string15);

        assertEquals(int15, v.getInteger());
        assertEquals(string15, v.getString());
    }

    /**
     * Test method for {@link org.deroesch.validation.Validation#getInteger()}.
     */
    @Test
    void testGetInteger() {
        final Integer i = v.getInteger();
        assertNotNull(i);
        assertEquals(TEN, i);
    }

    /**
     * Test method for
     * {@link org.deroesch.validation.Validation#setInteger(java.lang.Integer)}.
     */
    @Test
    void testSetInteger() {
        final int i = 11;
        v.setInteger(i);
        assertEquals(i, v.getInteger());

        // Test bad arg
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            v.setInteger(-1);
        });

        // Test null arg
        Assertions.assertThrows(NullPointerException.class, () -> {
            v.setInteger(null);
        });
    }

    /**
     * Test method for {@link org.deroesch.validation.Validation#getString()}.
     */
    @Test
    void testGetString() {
        final String str = v.getString();
        assertNotNull(str);
        assertEquals(HELLO, str);
    }

    /**
     * Test method for
     * {@link org.deroesch.validation.Validation#setString(java.lang.String)}.
     */
    @Test
    void testSetString() {
        final String there = "there";
        v.setString(there);
        assertEquals(there, v.getString());

        // Test null arg
        Assertions.assertThrows(NullPointerException.class, () -> {
            v.setInteger(null);
        });
    }

    /**
     * Test method for
     * {@link org.deroesch.validation.Validation#equals(java.lang.Object)}.
     *
     * @throws CloneNotSupportedException
     */
    @Test
    void testEqualsObject() throws CloneNotSupportedException {
        final ValidationUtils v1 = (ValidationUtils) v.clone();
        final ValidationUtils v2 = (ValidationUtils) v.clone();
        final Object obj = new Object();

        assertEquals(v1, v2);
        assertEquals(v2, v1);
        assertEquals(v2, v2);
        assertFalse(v1.equals(null));
        assertFalse(v1.equals(obj));
        assertFalse(obj.equals(v2));
        assertFalse(v1.equals(new Validation(20, HELLO)));
        assertFalse(v1.equals(new Validation(TEN, "Sorry")));
        assertFalse(v1 == v2);
    }

    /**
     * Test method for {@link org.deroesch.validation.Validation#toString()}.
     */
    @Test
    void testToString() {
        final String s = String.format("Validation [integer=%s, string=%s]", TEN, HELLO);
        assertEquals(s, v.toString());
    }

}
