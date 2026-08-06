package com.lab.fundamentals.operators;

/** Relational operators — seniority and high-earner checks for HRMS policies. */
public class RelationalDemo {

    private static final int SENIOR_YEARS = 5;

    public static void main(String[] args) {
        System.out.println("Relational: senior(6)=" + isSenior(6) + ", senior(3)=" + isSenior(3));
        System.out.println("Relational: highEarner=" + isHighEarner(120_000, 100_000));
    }

    static boolean isSenior(int years) {
        return years >= SENIOR_YEARS;
    }

    static boolean isHighEarner(double salary, double threshold) {
        return salary > threshold;
    }
}
