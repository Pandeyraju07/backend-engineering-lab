package com.lab.fundamentals.datetime;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class DatetimeDemoTest {

    @Test
    void localDateHandlesTodayPlusDaysAndIsBefore() {
        LocalDate asOf = LocalDate.of(2026, 8, 6);
        LeaveWindow leave = new LeaveWindow(LocalDate.of(2026, 8, 10), LocalDate.of(2026, 8, 14));

        assertEquals(asOf, LocalDateDemo.today(asOf));
        assertEquals(LocalDate.of(2026, 8, 15), LocalDateDemo.returnToWork(leave.start(), 5));
        assertTrue(LocalDateDemo.startsBefore(asOf, leave.start()));
        assertTrue(LocalDateDemo.isUpcoming(leave, asOf));
        assertFalse(LocalDateDemo.isUpcoming(leave, LocalDate.of(2026, 8, 10)));
    }

    @Test
    void periodAndDurationMeasureLeaveAndShift() {
        LeaveWindow leave = new LeaveWindow(LocalDate.of(2026, 8, 10), LocalDate.of(2026, 8, 14));

        assertEquals(5, PeriodDurationDemo.leaveCalendarDays(leave));
        assertEquals(Period.ofDays(5), PeriodDurationDemo.leavePeriod(leave));
        assertEquals(Duration.ofHours(9),
                PeriodDurationDemo.shiftDuration(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        assertEquals(9, PeriodDurationDemo.shiftHours(LocalTime.of(9, 0), LocalTime.of(18, 0)));
    }

    @Test
    void formattingFormatsAndParsesLeaveDates() {
        LocalDate start = LocalDate.of(2026, 8, 10);
        String formatted = FormattingDemo.formatLeaveDate(start);

        assertEquals("10-Aug-2026", formatted);
        assertEquals(start, FormattingDemo.parseLeaveDate(formatted));
        assertEquals("10-Aug-2026 to 14-Aug-2026",
                FormattingDemo.formatWindow(
                        new LeaveWindow(start, LocalDate.of(2026, 8, 14))));
        assertThrows(IllegalArgumentException.class,
                () -> FormattingDemo.parseLeaveDate("2026-08-10"));
    }

    @Test
    void leaveWindowRejectsInvertedRange() {
        assertThrows(IllegalArgumentException.class,
                () -> new LeaveWindow(LocalDate.of(2026, 8, 14), LocalDate.of(2026, 8, 10)));
    }

    @Test
    void planLeaveIntegratesAllDatetimeDemos() {
        LeaveWindow window = new LeaveWindow(LocalDate.of(2026, 8, 10), LocalDate.of(2026, 8, 14));
        DatetimeDemo.LeaveDateResult result = DatetimeDemo.planLeave(
                window,
                LocalDate.of(2026, 8, 6),
                LocalTime.of(9, 0),
                LocalTime.of(18, 0)
        );

        assertEquals(5, result.leaveDays());
        assertEquals(Period.ofDays(5), result.leavePeriod());
        assertTrue(result.upcoming());
        assertEquals(LocalDate.of(2026, 8, 15), result.returnToWork());
        assertTrue(result.returnOnOrAfterEnd());
        assertEquals("10-Aug-2026", result.formattedStart());
        assertEquals("14-Aug-2026", result.formattedEnd());
        assertEquals("10-Aug-2026 to 14-Aug-2026", result.letterRange());
        assertEquals(9, result.shiftHours());
    }
}
