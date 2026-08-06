package com.lab.fundamentals.strings;

/**
 * String immutability — concat, substring, and equals for HRMS name/email formatting.
 */
public class StringImmutableDemo {

    private static final String COMPANY_DOMAIN = "@company.com";

    public static void main(String[] args) {
        String first = "Raju";
        String last = "Kumar";

        String email = buildEmail(first, last);
        String normalized = normalizeName("  raju   kumar  ");

        System.out.println("Immutable: email=" + email);
        System.out.println("Immutable: normalized='" + normalized + "'");
        System.out.println("Immutable: equals? " + email.equals(buildEmail("Raju", "Kumar")));
        System.out.println("Immutable: local-part=" + email.substring(0, email.indexOf('@')));
    }

    static String buildEmail(String first, String last) {
        if (first == null || last == null) {
            throw new IllegalArgumentException("First and last name are required");
        }
        String local = (first.trim() + "." + last.trim()).toLowerCase().replace(" ", "");
        return local + COMPANY_DOMAIN;
    }

    static String normalizeName(String raw) {
        if (raw == null || raw.isBlank()) {
            return "";
        }
        String trimmed = raw.trim().replaceAll("\\s+", " ");
        String[] parts = trimmed.split(" ");
        String result = "";
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.isEmpty()) {
                continue;
            }
            String titled = Character.toUpperCase(part.charAt(0))
                    + (part.length() > 1 ? part.substring(1).toLowerCase() : "");
            result = result.isEmpty() ? titled : result.concat(" ").concat(titled);
        }
        return result;
    }

    static boolean sameEmail(String left, String right) {
        return left != null && left.equals(right);
    }
}
