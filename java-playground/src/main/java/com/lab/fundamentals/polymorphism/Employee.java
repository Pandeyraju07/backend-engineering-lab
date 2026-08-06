package com.lab.fundamentals.polymorphism;

/** Polymorphic payee base — subclasses override calculatePay(). */
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

    double calculatePay() {
        return baseSalary;
    }

    String employmentType() {
        return "GENERIC";
    }
}
