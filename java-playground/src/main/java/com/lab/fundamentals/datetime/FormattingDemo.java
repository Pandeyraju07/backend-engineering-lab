package com.lab.fundamentals.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * {@link DateTimeFormatter} format/parse for HRMS leave letters.
 */
public class FormattingDemo {

    static final DateTimeFormatter LEAVE_LETTER =
            DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2026, 8, 10);
        String formatted = formatLeaveDate(start);
        System.out.println("Formatted: " + formatted);
        System.out.println("Parsed: " + parseLeaveDate(formatted));
    }

    static String formatLeaveDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("date is required");
        }
        return date.format(LEAVE_LETTER);
    }

    static LocalDate parseLeaveDate(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("date text is required");
        }
        try {
            return LocalDate.parse(text.trim(), LEAVE_LETTER);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("invalid leave date: " + text, ex);
        }
    }

    static String formatWindow(LeaveWindow window) {
        if (window == null) {
            throw new IllegalArgumentException("window is required");
        }
        return formatLeaveDate(window.start()) + " to " + formatLeaveDate(window.end());
    }
}
