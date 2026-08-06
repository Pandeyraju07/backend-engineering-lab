package com.lab.fundamentals.classes;

/**
 * Simple HRMS employee class — fields and methods (not a record) to teach class structure.
 */
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

    void rename(String newName) {
        if (newName != null && !newName.isBlank()) {
            name = newName.trim();
        }
    }

    void transferTo(String newDepartment) {
        if (newDepartment != null && !newDepartment.isBlank()) {
            department = newDepartment.trim();
        }
    }

    void applyRaise(double percent) {
        if (percent > 0) {
            salary += salary * percent;
        }
    }

    void activate() {
        active = true;
    }

    void deactivate() {
        active = false;
    }

    @Override
    public String toString() {
        return "Employee{id='%s', name='%s', dept='%s', salary=%.2f, active=%b}"
                .formatted(employeeId, name, department, salary, active);
    }
}
