package com.lab.fundamentals.functionalinterface;

/** HRMS employee row for Predicate / Function / Consumer / Supplier demos. */
record Employee(
        String id,
        String name,
        String department,
        String email,
        double salary,
        boolean active
) {
}
