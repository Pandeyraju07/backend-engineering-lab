package com.lab.fundamentals.constructors;

/** Parameterized constructor — hire with id, name, and salary. */
public class ParameterizedConstructorDemo {

    public static void main(String[] args) {
        Worker worker = create("EMP-1001", "Raju Kumar", 82_000);
        System.out.println("Parameterized constructor: " + worker);
    }

    static Worker create(String id, String name, double salary) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("employee id is required");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("employee name is required");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("salary cannot be negative");
        }
        return new Worker(id, name, salary);
    }
}
