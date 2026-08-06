package com.lab.fundamentals.streams;

import java.util.List;

/** Stream filter + map — active employees and their display names. */
public class FilterMapDemo {

    public static void main(String[] args) {
        List<Employee> roster = sampleRoster();
        System.out.println("Active names: " + activeNames(roster));
        System.out.println("Engineering: " + namesInDepartment(roster, "Engineering"));
    }

    static List<Employee> sampleRoster() {
        return List.of(
                new Employee("E001", "Asha", "Engineering", 95_000, true),
                new Employee("E002", "Ravi", "People Ops", 72_000, true),
                new Employee("E003", "Meera", "Finance", 88_000, false),
                new Employee("E004", "Kiran", "Engineering", 81_000, true),
                new Employee("E005", "Neha", "Finance", 76_000, true)
        );
    }

    static List<Employee> activeEmployees(List<Employee> roster) {
        if (roster == null) {
            return List.of();
        }
        return roster.stream()
                .filter(employee -> employee != null && employee.active())
                .toList();
    }

    static List<String> activeNames(List<Employee> roster) {
        return activeEmployees(roster).stream()
                .map(Employee::name)
                .toList();
    }

    static List<String> namesInDepartment(List<Employee> roster, String department) {
        if (roster == null || department == null) {
            return List.of();
        }
        return roster.stream()
                .filter(employee -> employee != null && employee.active())
                .filter(employee -> department.equals(employee.dept()))
                .map(Employee::name)
                .toList();
    }

    static List<String> uppercaseActiveNames(List<Employee> roster) {
        return activeNames(roster).stream()
                .map(String::toUpperCase)
                .toList();
    }
}
