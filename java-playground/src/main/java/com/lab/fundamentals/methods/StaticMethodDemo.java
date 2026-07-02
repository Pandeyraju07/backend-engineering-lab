package com.lab.fundamentals.methods;

import java.util.concurrent.atomic.AtomicInteger;

/** Static methods — utility helpers shared across the application. */
public class StaticMethodDemo {

    private static final AtomicInteger ID_SEQUENCE = new AtomicInteger(1000);

    public static void main(String[] args) {
        String id = generateEmployeeId();
        boolean validEmail = isValidEmail("raju@company.com");
        boolean invalidEmail = isValidEmail("invalid-email");

        System.out.println("Static methods: generatedId=" + id + ", validEmail=" + validEmail + ", invalidEmail=" + invalidEmail);
    }

    static String generateEmployeeId() {
        return "EMP-" + ID_SEQUENCE.incrementAndGet();
    }

    static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    static double applyTax(double grossSalary, double taxRate) {
        if (grossSalary < 0 || taxRate < 0 || taxRate > 1) {
            throw new IllegalArgumentException("Invalid salary or tax rate");
        }
        return grossSalary * (1 - taxRate);
    }
}
