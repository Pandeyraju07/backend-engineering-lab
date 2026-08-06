package com.lab.fundamentals.streams;

/** HRMS employee row for Stream filter / map / collect / reduce demos. */
record Employee(
        String id,
        String name,
        String dept,
        double salary,
        boolean active
) {
}
