package com.lab.fundamentals.typecasting;

/** Widening conversions — int → long → double for salary math without precision loss. */
public class WideningDemo {

    public static void main(String[] args) {
        double salary = widenSalary(75_000);
        long key = combineIdAndAmount(1001, 7_500_000L);
        System.out.printf("Widening: salary=%.2f, combinedKey=%d%n", salary, key);
    }

    /** int salary (rupees) widens to long cents, then to double for display math. */
    static double widenSalary(int salaryRupees) {
        long cents = (long) salaryRupees * 100L;
        return (double) cents / 100.0;
    }

    /** Combines employee id (int) with payroll cents (long) into a single long key. */
    static long combineIdAndAmount(int id, long cents) {
        long wideId = id;
        return (wideId << 32) ^ cents;
    }
}
