package com.lab.fundamentals.abstractclasses;

/** Contractor HRMS staff — paid by hourly rate × hours worked in the month. */
final class ContractorStaff extends AbstractEmployee {

    private final double hourlyRate;
    private final int hoursWorked;

    ContractorStaff(String employeeId, String name, String department, double hourlyRate, int hoursWorked) {
        super(employeeId, name, department);
        if (hourlyRate < 0 || hoursWorked < 0) {
            throw new IllegalArgumentException("hourlyRate and hoursWorked must be non-negative");
        }
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double monthlyPay() {
        return hourlyRate * hoursWorked;
    }

    double hourlyRate() {
        return hourlyRate;
    }

    int hoursWorked() {
        return hoursWorked;
    }
}
