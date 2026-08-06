package com.lab.fundamentals.abstractclasses;

/**
 * Template-method demo — {@link AbstractEmployee#processPayroll(double)} calls abstract
 * {@link AbstractEmployee#monthlyPay()} then a concrete tax step.
 */
public class TemplateHookDemo {

    public static void main(String[] args) {
        AbstractEmployee permanent = new PermanentStaff(
                "EMP-101", "Asha Verma", "Engineering", 90_000, 10_000);
        double net = netPay(permanent, 0.20);
        System.out.printf("TemplateHook: %s net=%.2f%n", permanent.displayName(), net);
    }

    /** Runs the abstract-class payroll template for one employee. */
    static double netPay(AbstractEmployee employee, double taxRate) {
        if (employee == null) {
            throw new IllegalArgumentException("employee is required");
        }
        return employee.processPayroll(taxRate);
    }

    /** Sums template net pay across a workforce. */
    static double totalNetPayroll(double taxRate, AbstractEmployee... staff) {
        if (staff == null) {
            throw new IllegalArgumentException("staff is required");
        }
        double total = 0;
        for (AbstractEmployee employee : staff) {
            total += netPay(employee, taxRate);
        }
        return total;
    }

    /** Tax withheld for one employee using the same concrete tax step as the template. */
    static double taxWithheld(AbstractEmployee employee, double taxRate) {
        if (employee == null) {
            throw new IllegalArgumentException("employee is required");
        }
        double gross = employee.monthlyPay();
        return employee.calculateTax(gross, taxRate);
    }
}
