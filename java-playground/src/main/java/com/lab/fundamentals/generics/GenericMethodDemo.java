package com.lab.fundamentals.generics;

/** Generic methods — identity and first-non-null helpers for HRMS values. */
public class GenericMethodDemo {

    public static void main(String[] args) {
        Employee employee = new Employee("E010", "Meera", 72_000);
        System.out.println(identity(employee));
        System.out.println(firstNonNull(null, "Engineering", "Finance"));
    }

    static <T> T identity(T value) {
        return value;
    }

    @SafeVarargs
    static <T> T firstNonNull(T... values) {
        if (values == null) {
            return null;
        }
        for (T value : values) {
            if (value != null) {
                return value;
            }
        }
        return null;
    }
}
