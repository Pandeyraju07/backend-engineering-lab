package com.lab.fundamentals.wildcards;

import java.util.List;

/** Upper-bounded wildcard — {@code List<? extends Number>} average for payroll figures. */
public class UpperBoundDemo {

    public static void main(String[] args) {
        System.out.println(average(List.of(70_000, 65_000, 72_000)));
        System.out.println(average(List.of(70_000.0, 65_000.5)));
    }

    static double average(List<? extends Number> amounts) {
        if (amounts == null || amounts.isEmpty()) {
            throw new IllegalArgumentException("amounts must not be empty");
        }
        double total = 0;
        for (Number amount : amounts) {
            total += amount.doubleValue();
        }
        return total / amounts.size();
    }
}
