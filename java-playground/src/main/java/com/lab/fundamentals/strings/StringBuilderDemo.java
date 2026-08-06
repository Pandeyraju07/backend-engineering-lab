package com.lab.fundamentals.strings;

/** StringBuilder — efficient mutable building of HRMS display names and department lists. */
public class StringBuilderDemo {

    public static void main(String[] args) {
        String display = buildDisplayName("Raju", "Kumar");
        String departments = joinDepartments("Engineering", "HR", "Finance");

        System.out.println("StringBuilder: displayName=" + display);
        System.out.println("StringBuilder: departments=" + departments);
    }

    static String buildDisplayName(String... parts) {
        if (parts == null || parts.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String part : parts) {
            if (part == null || part.isBlank()) {
                continue;
            }
            if (!builder.isEmpty()) {
                builder.append(' ');
            }
            builder.append(part.trim());
        }
        return builder.toString();
    }

    static String joinDepartments(String... departments) {
        if (departments == null || departments.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < departments.length; i++) {
            String dept = departments[i];
            if (dept == null || dept.isBlank()) {
                continue;
            }
            if (!builder.isEmpty()) {
                builder.append(" | ");
            }
            builder.append(dept.trim());
        }
        return builder.toString();
    }
}
