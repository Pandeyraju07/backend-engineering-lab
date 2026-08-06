package com.lab.fundamentals.customexception;

/**
 * Unchecked custom exception — require non-negative net pay.
 */
public class UncheckedCustomDemo {

    public static void main(String[] args) {
        System.out.println("net=" + requireNetPay(42_500));
        try {
            requireNetPay(-10);
        } catch (PayrollRuntimeException ex) {
            System.out.println("payroll error: " + ex.getMessage());
        }
    }

    /** Returns net pay when {@code >= 0}; otherwise throws unchecked. */
    static double requireNetPay(double netPay) {
        if (netPay < 0) {
            throw new PayrollRuntimeException("net pay cannot be negative: " + netPay);
        }
        return netPay;
    }
}
