package com.lab.fundamentals.trycatch;

/**
 * Multi-catch — safe int parse for employee headcount / leave days.
 */
public class MultiCatchDemo {

    public static void main(String[] args) {
        System.out.println("safeParseInt(\"12\")=" + safeParseInt("12"));
        System.out.println("safeParseInt(null)=" + safeParseInt(null));
        System.out.println("safeParseInt(\"x\")=" + safeParseInt("x"));
    }

    /**
     * Parses an int; returns {@code -1} on {@link NumberFormatException} or {@link NullPointerException}.
     */
    static int safeParseInt(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException | NullPointerException ex) {
            return -1;
        }
    }
}
