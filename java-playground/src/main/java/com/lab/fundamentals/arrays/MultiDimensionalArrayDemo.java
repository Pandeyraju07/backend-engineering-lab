package com.lab.fundamentals.arrays;

/** 2D arrays — monthly attendance grid [employee][day] (HRMS timesheet). */
public class MultiDimensionalArrayDemo {

    public static void main(String[] args) {
        boolean[][] attendance = buildSampleAttendance(3, 5);
        int[] presentDays = countPresentDays(attendance);

        for (int i = 0; i < presentDays.length; i++) {
            System.out.printf("2D array: EMP-%d present=%d / %d%n",
                    i + 1, presentDays[i], attendance[i].length);
        }
        System.out.printf("Team attendance: %.1f%%%n", teamAttendancePercent(attendance));
    }

    /**
     * Builds a sample attendance matrix.
     * Day is marked present when (employeeIndex + day) % 3 != 0.
     */
    static boolean[][] buildSampleAttendance(int employeeCount, int workingDays) {
        boolean[][] attendance = new boolean[employeeCount][workingDays];
        for (int emp = 0; emp < employeeCount; emp++) {
            for (int day = 0; day < workingDays; day++) {
                attendance[emp][day] = (emp + day) % 3 != 0;
            }
        }
        return attendance;
    }

    static int[] countPresentDays(boolean[][] attendance) {
        int[] presentDays = new int[attendance.length];
        for (int emp = 0; emp < attendance.length; emp++) {
            int present = 0;
            for (boolean dayPresent : attendance[emp]) {
                if (dayPresent) {
                    present++;
                }
            }
            presentDays[emp] = present;
        }
        return presentDays;
    }

    static double teamAttendancePercent(boolean[][] attendance) {
        if (attendance.length == 0 || attendance[0].length == 0) {
            return 0;
        }
        int present = 0;
        int total = 0;
        for (boolean[] employeeDays : attendance) {
            for (boolean dayPresent : employeeDays) {
                total++;
                if (dayPresent) {
                    present++;
                }
            }
        }
        return (present * 100.0) / total;
    }

    static int absentDays(boolean[][] attendance, int employeeIndex) {
        if (employeeIndex < 0 || employeeIndex >= attendance.length) {
            return 0;
        }
        int absent = 0;
        for (boolean dayPresent : attendance[employeeIndex]) {
            if (!dayPresent) {
                absent++;
            }
        }
        return absent;
    }
}
