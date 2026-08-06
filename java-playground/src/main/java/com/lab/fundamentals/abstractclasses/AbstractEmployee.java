package com.lab.fundamentals.abstractclasses;

/**
 * Abstract HRMS employee — subclasses supply {@link #monthlyPay()}; shared display and payroll template.
 */
abstract class AbstractEmployee {

    private final String employeeId;
    private final String name;
    private final String department;

    protected AbstractEmployee(String employeeId, String name, String department) {
        if (employeeId == null || employeeId.isBlank()) {
            throw new IllegalArgumentException("employeeId is required");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        this.employeeId = employeeId;
        this.name = name;
        this.department = department == null ? "" : department;
    }

    /** Subclasses define how gross monthly pay is calculated. */
    abstract double monthlyPay();

    /** Concrete helper shared by all staff types. */
    String displayName() {
        return "%s (%s)".formatted(name, employeeId);
    }

    /**
     * Template method: fixed payroll steps with a hook for {@link #monthlyPay()}.
     *
     * @param taxRate tax fraction in {@code [0, 1]}
     * @return net pay after concrete tax deduction
     */
    double processPayroll(double taxRate) {
        if (taxRate < 0 || taxRate > 1) {
            throw new IllegalArgumentException("taxRate must be between 0 and 1");
        }
        double gross = monthlyPay();
        double tax = calculateTax(gross, taxRate);
        return gross - tax;
    }

    /** Concrete tax step used by the payroll template. */
    protected double calculateTax(double gross, double taxRate) {
        return gross * taxRate;
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

    @Override
    public String toString() {
        return "%s{id='%s', name='%s', dept='%s', monthlyPay=%.2f}"
                .formatted(getClass().getSimpleName(), employeeId, name, department, monthlyPay());
    }
}
