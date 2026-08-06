package com.lab.fundamentals.optional;

/** HRMS employee row for Optional create / chain / lookup demos. */
record Employee(
        String id,
        String name,
        String department,
        String email,
        double salary
) {
}
