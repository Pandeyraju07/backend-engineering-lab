package com.lab.fundamentals.optional;

import java.util.List;
import java.util.Optional;

/** Optional creation — of, ofNullable, empty, and findById directory lookup. */
public class OptionalCreateDemo {

    public static void main(String[] args) {
        System.out.println("Found: " + findById(sampleDirectory(), "E001"));
        System.out.println("Missing: " + findById(sampleDirectory(), "E999"));
        System.out.println("Empty: " + emptyEmployee());
    }

    static List<Employee> sampleDirectory() {
        return List.of(
                new Employee("E001", "Asha", "Engineering", "asha@hrms.lab", 95_000),
                new Employee("E002", "Ravi", "People Ops", "ravi@hrms.lab", 72_000),
                new Employee("E003", "Meera", "Finance", "meera@hrms.lab", 88_000)
        );
    }

    static Optional<Employee> ofEmployee(Employee employee) {
        return Optional.of(employee);
    }

    static Optional<Employee> ofNullableEmployee(Employee employee) {
        return Optional.ofNullable(employee);
    }

    static Optional<Employee> emptyEmployee() {
        return Optional.empty();
    }

    static Optional<Employee> findById(List<Employee> directory, String id) {
        if (directory == null || id == null || id.isBlank()) {
            return Optional.empty();
        }
        return directory.stream()
                .filter(employee -> employee != null && id.equals(employee.id()))
                .findFirst();
    }

    static boolean isPresent(Optional<Employee> maybe) {
        return maybe != null && maybe.isPresent();
    }
}
