package com.lab.fundamentals.accessmodifiers;

/**
 * Same-package subclass — can read protected {@code basePay} and default-package fields.
 */
class SubEmployee extends PackageEmployee {

    private final String title;

    SubEmployee(String employeeId, String department, double basePay, String title) {
        super(employeeId, department, basePay);
        this.title = title;
    }

    String title() {
        return title;
    }

    /** Demonstrates protected field access from a subclass. */
    double protectedBasePay() {
        return basePay;
    }

    /** Demonstrates default (package) field access from a subclass in the same package. */
    String packageDepartment() {
        return department;
    }

    double applyRaise(double percent) {
        basePay = basePay * (1 + percent);
        return basePay;
    }

    @Override
    public String toString() {
        return "SubEmployee{id='%s', dept='%s', title='%s', basePay=%.2f}"
                .formatted(employeeId, department, title, basePay);
    }
}
