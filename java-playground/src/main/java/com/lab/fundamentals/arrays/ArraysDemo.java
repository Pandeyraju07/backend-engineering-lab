package com.lab.fundamentals.arrays;

import java.util.Arrays;

/**
 * HRMS monthly attendance payroll — uses 1D, 2D, copy, and sort/search arrays in one flow.
 */
public class ArraysDemo {

    private static final int WORKING_DAYS = 22;
    private static final double FULL_ATTENDANCE_THRESHOLD = 0.90;
    private static final double ATTENDANCE_PENALTY = 0.05;

    public static void main(String[] args) {
        AttendancePayrollResult result = runAttendancePayroll(
                OneDimensionalArrayDemo.buildSampleEmployees(8), WORKING_DAYS);
        System.out.println(result);
    }

    static AttendancePayrollResult runAttendancePayroll(EmployeeSnapshot[] employees, int workingDays) {
        double[] currentSalaries = OneDimensionalArrayDemo.extractSalaries(employees);
        double[] salarySnapshot = ArrayCopyDemo.snapshotSalaries(currentSalaries);

        boolean[][] attendance = MultiDimensionalArrayDemo.buildSampleAttendance(
                employees.length, workingDays);
        int[] presentDays = MultiDimensionalArrayDemo.countPresentDays(attendance);

        double[] revisedSalaries = applyAttendanceAdjustments(currentSalaries, presentDays, workingDays);
        int[] changed = ArrayCopyDemo.changedIndexes(salarySnapshot, revisedSalaries);

        double[] ranked = ArraySortSearchDemo.rankSalariesAscending(revisedSalaries);
        double topPay = ArraySortSearchDemo.topEarner(revisedSalaries);
        double teamAvg = OneDimensionalArrayDemo.averageSalary(revisedSalaries);
        double attendancePercent = MultiDimensionalArrayDemo.teamAttendancePercent(attendance);

        return new AttendancePayrollResult(
                employees.length,
                changed.length,
                teamAvg,
                topPay,
                attendancePercent,
                ranked
        );
    }

    private static double[] applyAttendanceAdjustments(double[] salaries, int[] presentDays, int workingDays) {
        double[] revised = Arrays.copyOf(salaries, salaries.length);
        for (int i = 0; i < revised.length; i++) {
            double ratio = (double) presentDays[i] / workingDays;
            if (ratio < FULL_ATTENDANCE_THRESHOLD) {
                revised[i] = revised[i] * (1 - ATTENDANCE_PENALTY);
            }
        }
        return revised;
    }

    record AttendancePayrollResult(
            int employeeCount,
            int adjustedCount,
            double averageSalary,
            double topSalary,
            double teamAttendancePercent,
            double[] rankedSalaries
    ) {
        @Override
        public String toString() {
            return "AttendancePayroll{employees=%d, adjusted=%d, avg=%.2f, top=%.2f, attendance=%.1f%%, ranked=%s}"
                    .formatted(employeeCount, adjustedCount, averageSalary, topSalary,
                            teamAttendancePercent, Arrays.toString(rankedSalaries));
        }
    }
}
