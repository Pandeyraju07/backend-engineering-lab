package com.lab.fundamentals.abstractclasses;

/** Permanent HRMS staff — monthly salary plus fixed benefits. */
final class PermanentStaff extends AbstractEmployee {

    private final double monthlySalary;
    private final double benefits;

    PermanentStaff(String employeeId, String name, String department, double monthlySalary, double benefits) {
        super(employeeId, name, department);
        if (monthlySalary < 0 || benefits < 0) {
            throw new IllegalArgumentException("salary and benefits must be non-negative");
        }
        this.monthlySalary = monthlySalary;
        this.benefits = benefits;
    }

    @Override
    double monthlyPay() {
        return monthlySalary + benefits;
    }

    double monthlySalary() {
        return monthlySalary;
    }

    double benefits() {
        return benefits;
    }
}
