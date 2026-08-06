package com.lab.fundamentals.operators;

/** Arithmetic operators — net pay and overtime for payroll runs. */
public class ArithmeticDemo {

    public static void main(String[] args) {
        double net = calculateNet(80_000, 0.20);
        double overtime = overtimePay(500, 10);
        System.out.printf("Arithmetic: net=%.2f, overtime=%.2f%n", net, overtime);
    }

    static double calculateNet(double gross, double taxRate) {
        if (gross < 0 || taxRate < 0 || taxRate > 1) {
            throw new IllegalArgumentException("Invalid gross salary or tax rate");
        }
        return gross * (1 - taxRate);
    }

    static double overtimePay(double hourly, int hours) {
        if (hourly < 0 || hours < 0) {
            throw new IllegalArgumentException("Hourly rate and hours must be non-negative");
        }
        int regularHours = Math.min(hours, 8);
        int extraHours = Math.max(hours - 8, 0);
        return (regularHours * hourly) + (extraHours * hourly * 1.5);
    }
}
