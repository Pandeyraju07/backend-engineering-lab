package com.lab.fundamentals.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysDemoTest {

    @Test
    void oneDimensionalExtractsAndAveragesSalaries() {
        EmployeeSnapshot[] employees = OneDimensionalArrayDemo.buildSampleEmployees(4);
        double[] salaries = OneDimensionalArrayDemo.extractSalaries(employees);

        assertEquals(4, salaries.length);
        assertEquals(60_000, salaries[0]);
        assertEquals(67_500, OneDimensionalArrayDemo.averageSalary(salaries));
    }

    @Test
    void multiDimensionalCountsPresentDays() {
        boolean[][] attendance = MultiDimensionalArrayDemo.buildSampleAttendance(2, 3);
        int[] presentDays = MultiDimensionalArrayDemo.countPresentDays(attendance);

        assertEquals(2, presentDays.length);
        assertEquals(2, presentDays[0]);
        assertTrue(MultiDimensionalArrayDemo.teamAttendancePercent(attendance) > 0);
    }

    @Test
    void arrayCopyKeepsIndependentSnapshot() {
        double[] salaries = {50_000, 60_000, 70_000};
        double[] snapshot = ArrayCopyDemo.snapshotSalaries(salaries);

        salaries[0] = 55_000;

        assertTrue(ArrayCopyDemo.hasSameSalaries(snapshot, new double[]{50_000, 60_000, 70_000}));
        assertArrayEquals(new int[]{0}, ArrayCopyDemo.changedIndexes(snapshot, salaries));
    }

    @Test
    void sortAndSearchFindsRankedSalary() {
        double[] salaries = {75_000, 60_000, 90_000};
        double[] ranked = ArraySortSearchDemo.rankSalariesAscending(salaries);

        assertArrayEquals(new double[]{60_000, 75_000, 90_000}, ranked);
        assertEquals(1, ArraySortSearchDemo.findSalaryIndex(ranked, 75_000));
        assertEquals(90_000, ArraySortSearchDemo.topEarner(salaries));
    }

    @Test
    void attendancePayrollUsesAllArrayTypes() {
        EmployeeSnapshot[] employees = OneDimensionalArrayDemo.buildSampleEmployees(6);
        ArraysDemo.AttendancePayrollResult result = ArraysDemo.runAttendancePayroll(employees, 10);

        assertEquals(6, result.employeeCount());
        assertTrue(result.averageSalary() > 0);
        assertTrue(result.topSalary() >= result.averageSalary());
        assertEquals(6, result.rankedSalaries().length);
        assertTrue(result.teamAttendancePercent() > 0);
    }
}
