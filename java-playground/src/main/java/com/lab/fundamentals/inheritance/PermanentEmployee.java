package com.lab.fundamentals.inheritance;

/** Permanent staff — salary plus benefits minus PF contribution. */
class PermanentEmployee extends Employee {

    private final double benefits;
    private final double pfRate;

    PermanentEmployee(String employeeId, String name, String department,
                      double baseSalary, double benefits, double pfRate) {
        super(employeeId, name, department, baseSalary);
        this.benefits = benefits;
        this.pfRate = pfRate;
    }

    double benefits() {
        return benefits;
    }

    double pfRate() {
        return pfRate;
    }

    @Override
    double calculatePay() {
        return baseSalary + benefits - (baseSalary * pfRate);
    }

    @Override
    String describe() {
        return super.describe() + " [permanent benefits=%.2f, pfRate=%.0f%%]"
                .formatted(benefits, pfRate * 100);
    }
}
