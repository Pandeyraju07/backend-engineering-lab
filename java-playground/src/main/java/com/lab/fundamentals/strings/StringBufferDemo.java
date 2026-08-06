package com.lab.fundamentals.strings;

/**
 * StringBuffer — synchronized buffer helpers for thread-safe HRMS ID prefixing.
 */
public class StringBufferDemo {

    private static final String ID_PREFIX = "EMP-";

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Badge:");
        appendIdPrefix(buffer, "1001");
        System.out.println("StringBuffer: " + buffer);
    }

    static StringBuffer appendIdPrefix(StringBuffer buffer, String id) {
        if (buffer == null) {
            throw new IllegalArgumentException("Buffer is required");
        }
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Employee id is required");
        }
        String trimmed = id.trim();
        if (!trimmed.startsWith(ID_PREFIX)) {
            buffer.append(ID_PREFIX);
        }
        buffer.append(trimmed);
        return buffer;
    }

    static String formatBadge(String id) {
        StringBuffer buffer = new StringBuffer();
        appendIdPrefix(buffer, id);
        return buffer.toString();
    }
}
