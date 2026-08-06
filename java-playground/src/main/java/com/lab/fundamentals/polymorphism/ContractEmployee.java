package com.lab.fundamentals.polymorphism;

/** Contract payee — hourly rate × billed hours. */
class ContractEmployee extends Employee {

    private final double hourlyRate;
    private final int hoursWorked;

    ContractEmployee(String employeeId, String name, String department,
                     double hourlyRate, int hoursWorked) {
        super(employeeId, name, department, 0);
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
    String employmentType() {
        return "CONTRACT";
    }
}
