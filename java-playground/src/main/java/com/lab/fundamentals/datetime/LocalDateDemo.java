package com.lab.fundamentals.datetime;

import java.time.LocalDate;

/**
 * {@link LocalDate} basics — today, plusDays, and isBefore for leave planning.
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        LocalDate asOf = LocalDate.of(2026, 8, 6);
        LeaveWindow leave = new LeaveWindow(LocalDate.of(2026, 8, 10), LocalDate.of(2026, 8, 14));
        System.out.println("As of: " + asOf);
        System.out.println("Return date: " + returnToWork(leave.start(), 5));
        System.out.println("Upcoming? " + isUpcoming(leave, asOf));
    }

    /** Anchor date for demos/tests (avoids flaky {@code LocalDate.now()} assertions). */
    static LocalDate today(LocalDate asOf) {
        if (asOf == null) {
            throw new IllegalArgumentException("asOf is required");
        }
        return asOf;
    }

    /** Adds leave days to a start date — typically the first day back at work. */
    static LocalDate returnToWork(LocalDate leaveStart, long leaveDays) {
        if (leaveStart == null) {
            throw new IllegalArgumentException("leaveStart is required");
        }
        if (leaveDays < 1) {
            throw new IllegalArgumentException("leaveDays must be at least 1");
        }
        return leaveStart.plusDays(leaveDays);
    }

    static boolean startsBefore(LocalDate left, LocalDate right) {
        if (left == null || right == null) {
            throw new IllegalArgumentException("both dates are required");
        }
        return left.isBefore(right);
    }

    /** True when the leave window has not started yet relative to {@code asOf}. */
    static boolean isUpcoming(LeaveWindow window, LocalDate asOf) {
        if (window == null || asOf == null) {
            throw new IllegalArgumentException("window and asOf are required");
        }
        return asOf.isBefore(window.start());
    }
}
