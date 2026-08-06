package com.lab.fundamentals.throwthrows;

/**
 * throw — reject non-positive HRMS salary with IllegalArgumentException.
 */
public class ThrowDemo {

    public static void main(String[] args) {
        System.out.println("ok=" + requirePositiveSalary(50_000));
        try {
            requirePositiveSalary(-1);
        } catch (IllegalArgumentException ex) {
            System.out.println("rejected: " + ex.getMessage());
        }
    }

    /** Returns salary when {@code > 0}; otherwise throws. */
    static double requirePositiveSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("salary must be positive: " + salary);
        }
        return salary;
    }
}
