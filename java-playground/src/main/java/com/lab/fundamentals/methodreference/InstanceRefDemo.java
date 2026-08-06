package com.lab.fundamentals.methodreference;

import java.util.List;

/**
 * Instance method references — bound {@code instance::method} and unbound {@code Type::instanceMethod}.
 */
public class InstanceRefDemo {

    public static void main(String[] args) {
        List<Employee> roster = List.of(
                new Employee("EMP-1001", "Raju Kumar", "Engineering", 82_000),
                new Employee("EMP-1002", "Anita Desai", "HR", 95_000)
        );
        System.out.println("Display names: " + mapDisplayNames(roster));
        System.out.println("Dept labels: " + mapDepartmentLabels(roster));
        System.out.println("Prefixed: " + prefixIds(List.of("1001", "1002"), "Badge:"));
    }

    /** Unbound instance refs — {@code Employee::displayName}. */
    static List<String> mapDisplayNames(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException("employees is required");
        }
        return employees.stream().map(Employee::displayName).toList();
    }

    /** Unbound instance refs — {@code Employee::departmentLabel}. */
    static List<String> mapDepartmentLabels(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException("employees is required");
        }
        return employees.stream().map(Employee::departmentLabel).toList();
    }

    /** Bound instance ref — {@code prefix::concat} on each raw id. */
    static List<String> prefixIds(List<String> rawIds, String prefix) {
        if (rawIds == null) {
            throw new IllegalArgumentException("rawIds is required");
        }
        if (prefix == null) {
            throw new IllegalArgumentException("prefix is required");
        }
        return rawIds.stream().map(prefix::concat).toList();
    }
}
