package com.lab.fundamentals.methods;

/** Employee entity used across method demos. */
class Employee {

    private final String employeeId;
    private String name;
    private String department;
    private double salary;
    private boolean active;

    Employee(String employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = false;
    }

    String employeeId() {
        return employeeId;
    }

    String name() {
        return name;
    }

    String department() {
        return department;
    }

    double salary() {
        return salary;
    }

    boolean active() {
        return active;
    }

    void promote(double increment) {
        if (increment > 0) {
            salary += increment;
        }
    }

    void transferTo(String newDepartment) {
        if (newDepartment != null && !newDepartment.isBlank()) {
            department = newDepartment;
        }
    }

    void activate() {
        active = true;
    }

    @Override
    public String toString() {
        return "Employee{id='%s', name='%s', dept='%s', salary=%.2f, active=%b}"
                .formatted(employeeId, name, department, salary, active);
    }
}
