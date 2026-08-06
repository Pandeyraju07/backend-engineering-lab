package com.lab.fundamentals.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 * {@link Period} for leave spans and {@link Duration} for a work shift.
 */
public class PeriodDurationDemo {

    public static void main(String[] args) {
        LeaveWindow leave = new LeaveWindow(
                LocalDate.of(2026, 8, 10),
                LocalDate.of(2026, 8, 14)
        );
        System.out.println("Leave days: " + leaveCalendarDays(leave));
        System.out.println("Leave period: " + leavePeriod(leave));
        System.out.println("Shift: " + shiftDuration(LocalTime.of(9, 0), LocalTime.of(18, 0)));
    }

    /**
     * Inclusive calendar days via {@code Period.between(start, end.plusDays(1))}.
     * Same-month windows use {@link Period#getDays()}; longer spans add normalized months/years.
     */
    static int leaveCalendarDays(LeaveWindow window) {
        Period period = leavePeriod(window);
        LocalDate probe = window.start().plus(period);
        return (int) (probe.toEpochDay() - window.start().toEpochDay());
    }

    /** Inclusive leave length as a {@link Period} (end is inclusive). */
    static Period leavePeriod(LeaveWindow window) {
        if (window == null) {
            throw new IllegalArgumentException("window is required");
        }
        return Period.between(window.start(), window.end().plusDays(1));
    }

    /** Duration of a same-day work shift (e.g. 09:00–18:00). */
    static Duration shiftDuration(LocalTime shiftStart, LocalTime shiftEnd) {
        if (shiftStart == null || shiftEnd == null) {
            throw new IllegalArgumentException("shift start and end are required");
        }
        if (shiftEnd.isBefore(shiftStart)) {
            throw new IllegalArgumentException("shift end must not be before start");
        }
        return Duration.between(shiftStart, shiftEnd);
    }

    static long shiftHours(LocalTime shiftStart, LocalTime shiftEnd) {
        return shiftDuration(shiftStart, shiftEnd).toHours();
    }
}
