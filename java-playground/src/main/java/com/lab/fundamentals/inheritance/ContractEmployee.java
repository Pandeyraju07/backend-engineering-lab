package com.lab.fundamentals.inheritance;

/** Contract staff — paid by hourly rate × hours worked. */
class ContractEmployee extends Employee {

    private final double hourlyRate;
    private final int hoursWorked;

    ContractEmployee(String employeeId, String name, String department,
                     double baseSalary, double hourlyRate, int hoursWorked) {
        super(employeeId, name, department, baseSalary);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    double hourlyRate() {
        return hourlyRate;
    }

    int hoursWorked() {
        return hoursWorked;
    }

    @Override
    double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    @Override
    String describe() {
        return super.describe() + " [contract rate=%.2f × %d hrs]"
                .formatted(hourlyRate, hoursWorked);
    }
}
