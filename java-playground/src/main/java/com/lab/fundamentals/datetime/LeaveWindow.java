package com.lab.fundamentals.datetime;

import java.time.LocalDate;

/**
 * Inclusive leave date range for HRMS absence planning.
 */
record LeaveWindow(LocalDate start, LocalDate end) {

    LeaveWindow {
        if (start == null || end == null) {
            throw new IllegalArgumentException("start and end are required");
        }
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("end must not be before start");
        }
    }
}
