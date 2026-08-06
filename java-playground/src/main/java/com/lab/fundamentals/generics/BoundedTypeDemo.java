package com.lab.fundamentals.generics;

import java.util.List;

/** Bounded type parameters — {@code <T extends Number>} for payroll math. */
public class BoundedTypeDemo {

    public static void main(String[] args) {
        System.out.println(sum(List.of(70_000, 65_000, 72_000)));
        System.out.println(maxSalary(List.of(70_000.0, 65_000.5, 72_000.0)));
    }

    static <T extends Number> double sum(List<T> amounts) {
        double total = 0;
        for (T amount : amounts) {
            total += amount.doubleValue();
        }
        return total;
    }

    static <T extends Number> double maxSalary(List<T> salaries) {
        if (salaries == null || salaries.isEmpty()) {
            throw new IllegalArgumentException("salaries must not be empty");
        }
        double max = salaries.getFirst().doubleValue();
        for (T salary : salaries) {
            max = Math.max(max, salary.doubleValue());
        }
        return max;
    }
}
