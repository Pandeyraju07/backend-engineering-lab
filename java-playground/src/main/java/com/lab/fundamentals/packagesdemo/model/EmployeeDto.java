package com.lab.fundamentals.packagesdemo.model;

/**
 * Simple HRMS employee transfer object living in its own model subpackage.
 */
public class EmployeeDto {

    private final String employeeId;
    private final String name;
    private final String department;
    private final double salary;

    public EmployeeDto(String employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String employeeId() {
        return employeeId;
    }

    public String name() {
        return name;
    }

    public String department() {
        return department;
    }

    public double salary() {
        return salary;
    }

    @Override
    public String toString() {
        return "EmployeeDto{id='%s', name='%s', dept='%s', salary=%.2f}"
                .formatted(employeeId, name, department, salary);
    }
}
