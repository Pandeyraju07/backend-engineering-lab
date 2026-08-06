package com.lab.fundamentals.datatypes;

/** Reference types — String and array identity vs content in HRMS skill catalogs. */
public class ReferenceTypeDemo {

    public static void main(String[] args) {
        String raw = "  raju kumar  ";
        String formatted = formatName(raw);
        int[] skillRatings = {4, 5, 3, 5};

        System.out.println("Reference: raw='" + raw + "', formatted='" + formatted + "'");
        System.out.println("Reference: skillCount=" + skillCount(skillRatings));
        System.out.println("Reference: same name object? " + (formatted == formatName(raw)));
    }

    static String formatName(String name) {
        if (name == null || name.isBlank()) {
            return "";
        }
        String trimmed = name.trim().replaceAll("\\s+", " ");
        String[] parts = trimmed.split(" ");
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.isEmpty()) {
                continue;
            }
            formatted.append(Character.toUpperCase(part.charAt(0)));
            if (part.length() > 1) {
                formatted.append(part.substring(1).toLowerCase());
            }
            if (i < parts.length - 1) {
                formatted.append(' ');
            }
        }
        return formatted.toString();
    }

    static int skillCount(int[] skillRatings) {
        if (skillRatings == null) {
            return 0;
        }
        int count = 0;
        for (int rating : skillRatings) {
            if (rating > 0) {
                count++;
            }
        }
        return count;
    }
}
