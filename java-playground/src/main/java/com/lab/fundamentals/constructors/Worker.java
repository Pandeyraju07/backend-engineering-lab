package com.lab.fundamentals.constructors;

/**
 * HRMS worker entity demonstrating default, parameterized, and chaining constructors.
 */
class Worker {

    private static final String DEFAULT_ID = "EMP-0000";
    private static final String DEFAULT_NAME = "Unassigned";
    private static final String DEFAULT_ROLE = "Associate";
    private static final double DEFAULT_SALARY = 40_000;

    private final String employeeId;
    private final String name;
    private final String role;
    private final double salary;

    /** Default / no-arg path — placeholder hire before details are filled in. */
    Worker() {
        this(DEFAULT_ID, DEFAULT_NAME, DEFAULT_ROLE, DEFAULT_SALARY);
    }

    /** Parameterized constructor used for a full hire record. */
    Worker(String employeeId, String name, double salary) {
        this(employeeId, name, DEFAULT_ROLE, salary);
    }

    /** Full constructor — all other constructors chain here via {@code this(...)}. */
    Worker(String employeeId, String name, String role, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    String employeeId() {
        return employeeId;
    }

    String name() {
        return name;
    }

    String role() {
        return role;
    }

    double salary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Worker{id='%s', name='%s', role='%s', salary=%.2f}"
                .formatted(employeeId, name, role, salary);
    }
}
