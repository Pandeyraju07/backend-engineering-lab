package com.lab.fundamentals.io;

/** Formatted output — printf-style employee lines for HR reports. */
public class FormattedOutputDemo {

    public static void main(String[] args) {
        String line = formatEmployeeLine("EMP-1001", "Raju Kumar", 82_000);
        System.out.println(line);
    }

    /** Formats id (left), name (padded), and salary (2 decimal places) into one report line. */
    static String formatEmployeeLine(String id, String name, double salary) {
        return String.format("%-10s | %-24s | %12.2f", id, name, salary);
    }
}
