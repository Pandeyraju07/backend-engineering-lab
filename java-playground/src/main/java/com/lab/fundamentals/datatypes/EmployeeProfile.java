package com.lab.fundamentals.datatypes;

/** HRMS employee profile spanning Java primitive types. */
record EmployeeProfile(
        byte tier,
        short leaveBalance,
        int age,
        long employeeNumber,
        float bonusPercent,
        double salary,
        char grade,
        boolean active,
        String name
) {
}
