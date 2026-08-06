package com.lab.fundamentals.polymorphism;

/** Permanent payee — monthly salary with fixed benefits. */
class PermanentEmployee extends Employee {

    private final double benefits;

    PermanentEmployee(String employeeId, String name, String department,
                      double baseSalary, double benefits) {
        super(employeeId, name, department, baseSalary);
        this.benefits = benefits;
    }

    double benefits() {
        return benefits;
    }

    @Override
    double calculatePay() {
        return baseSalary + benefits;
    }

    @Override
    String employmentType() {
        return "PERMANENT";
    }
}
