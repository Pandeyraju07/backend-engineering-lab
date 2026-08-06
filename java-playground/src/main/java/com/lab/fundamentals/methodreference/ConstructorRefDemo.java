package com.lab.fundamentals.methodreference;

import java.util.List;

/**
 * Constructor references — {@code Employee::new} builds placeholder hires from formatted ids.
 */
public class ConstructorRefDemo {

    public static void main(String[] args) {
        List<Employee> hires = createFromIds(List.of("EMP-2100", "EMP-2101"));
        System.out.println("Constructor refs: " + hires);
    }

    /** Maps each id with {@code Employee::new} (single-arg constructor). */
    static List<Employee> createFromIds(List<String> employeeIds) {
        if (employeeIds == null) {
            throw new IllegalArgumentException("employeeIds is required");
        }
        return employeeIds.stream().map(Employee::new).toList();
    }

    static boolean allPlaceholders(List<Employee> employees) {
        return employees != null
                && !employees.isEmpty()
                && employees.stream().allMatch(Employee::isPlaceholder);
    }
}
