package com.lab.fundamentals.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 * HRMS leave desk — LocalDate, Period/Duration, and formatting in one flow.
 */
public class DatetimeDemo {

    public static void main(String[] args) {
        LeaveDateResult result = planLeave(
                new LeaveWindow(LocalDate.of(2026, 8, 10), LocalDate.of(2026, 8, 14)),
                LocalDate.of(2026, 8, 6),
                LocalTime.of(9, 0),
                LocalTime.of(18, 0)
        );
        System.out.println(result);
    }

    /**
     * Computes leave length, upcoming status, return date, letter text, and shift hours.
     */
    static LeaveDateResult planLeave(
            LeaveWindow window,
            LocalDate asOf,
            LocalTime shiftStart,
            LocalTime shiftEnd
    ) {
        LocalDate today = LocalDateDemo.today(asOf);
        int leaveDays = PeriodDurationDemo.leaveCalendarDays(window);
        Period period = PeriodDurationDemo.leavePeriod(window);
        boolean upcoming = LocalDateDemo.isUpcoming(window, today);
        LocalDate returnDate = LocalDateDemo.returnToWork(window.start(), leaveDays);
        boolean returnAfterLeave = !LocalDateDemo.startsBefore(returnDate, window.end());
        String formattedStart = FormattingDemo.formatLeaveDate(window.start());
        String formattedEnd = FormattingDemo.formatLeaveDate(window.end());
        String letterRange = FormattingDemo.formatWindow(window);
        long shiftHours = PeriodDurationDemo.shiftHours(shiftStart, shiftEnd);

        return new LeaveDateResult(
                window,
                today,
                leaveDays,
                period,
                upcoming,
                returnDate,
                returnAfterLeave,
                formattedStart,
                formattedEnd,
                letterRange,
                shiftHours
        );
    }

    record LeaveDateResult(
            LeaveWindow window,
            LocalDate asOf,
            int leaveDays,
            Period leavePeriod,
            boolean upcoming,
            LocalDate returnToWork,
            boolean returnOnOrAfterEnd,
            String formattedStart,
            String formattedEnd,
            String letterRange,
            long shiftHours
    ) {
        @Override
        public String toString() {
            return "LeaveDateResult{range=%s, days=%d, upcoming=%b, return=%s, shiftHours=%d}"
                    .formatted(letterRange, leaveDays, upcoming, returnToWork, shiftHours);
        }
    }
}
