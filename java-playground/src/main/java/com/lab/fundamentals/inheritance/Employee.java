package com.lab.fundamentals.inheritance;

/** Base HRMS employee — shared fields and pay for inheritance demos. */
class Employee {

    private final String employeeId;
    private final String name;
    private final String department;
    protected final double baseSalary;

    Employee(String employeeId, String name, String department, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
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

    double baseSalary() {
        return baseSalary;
    }

    /** Default pay is base salary; subclasses override for permanent / contract rules. */
    double calculatePay() {
        return baseSalary;
    }

    String describe() {
        return "Employee{id='%s', name='%s', dept='%s', base=%.2f}"
                .formatted(employeeId, name, department, baseSalary);
    }
}
