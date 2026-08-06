package com.lab.fundamentals.trycatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * try-with-resources — read first payroll line from in-memory content.
 */
public class TryWithResourcesDemo {

    public static void main(String[] args) {
        String first = readFirstLine("EMP-1001|85000\nEMP-1002|72000\n");
        System.out.println("firstLine=" + first);
    }

    /**
     * Opens {@link StringReader}/{@link BufferedReader} and returns the first non-null line,
     * or empty string when content is blank / unreadable.
     */
    static String readFirstLine(String content) {
        if (content == null) {
            return "";
        }
        try (BufferedReader reader = new BufferedReader(new StringReader(content))) {
            String line = reader.readLine();
            return line == null ? "" : line;
        } catch (IOException ex) {
            return "";
        }
    }
}
