package com.lab.fundamentals.finalkeyword;

/**
 * Final locals and parameters — normalize HRMS ids without reassigning the input.
 */
public class FinalVariableDemo {

    public static void main(String[] args) {
        System.out.println(normalizeId("  emp-501  "));
    }

    static String normalizeId(final String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id is required");
        }
        final String trimmed = id.trim();
        final String upper = trimmed.toUpperCase();
        return upper;
    }

    static String badgeLabel(final String id, final String name) {
        final String normalized = normalizeId(id);
        final String safeName = name == null ? "" : name.trim();
        return normalized + ":" + safeName;
    }
}
