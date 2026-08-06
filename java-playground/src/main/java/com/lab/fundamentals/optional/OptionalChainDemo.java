package com.lab.fundamentals.optional;

import java.util.Optional;

/** Optional chaining — map, flatMap, orElse, and orElseThrow for HRMS lookups. */
public class OptionalChainDemo {

    public static void main(String[] args) {
        Optional<Employee> found = OptionalCreateDemo.findById(OptionalCreateDemo.sampleDirectory(), "E001");
        System.out.println("Email: " + emailOrDefault(found, "noreply@hrms.lab"));
        System.out.println("Dept: " + departmentOrThrow(found));
    }

    static String emailOrDefault(Optional<Employee> maybe, String defaultEmail) {
        if (maybe == null) {
            return defaultEmail;
        }
        return maybe.map(Employee::email).orElse(defaultEmail);
    }

    static String departmentOrThrow(Optional<Employee> maybe) {
        if (maybe == null) {
            throw new IllegalArgumentException("Employee optional was null");
        }
        return maybe.map(Employee::department)
                .orElseThrow(() -> new IllegalStateException("Employee not found"));
    }

    static Optional<String> emailOptional(Optional<Employee> maybe) {
        if (maybe == null) {
            return Optional.empty();
        }
        return maybe.map(Employee::email);
    }

    static Optional<String> normalizedEmail(Optional<Employee> maybe) {
        if (maybe == null) {
            return Optional.empty();
        }
        return maybe.flatMap(employee -> Optional.ofNullable(employee.email())
                .map(String::trim)
                .filter(email -> !email.isBlank())
                .map(String::toLowerCase));
    }

    static String displayName(Optional<Employee> maybe) {
        if (maybe == null) {
            return "Unknown";
        }
        return maybe.map(Employee::name).orElse("Unknown");
    }

    static double salaryOrZero(Optional<Employee> maybe) {
        if (maybe == null) {
            return 0;
        }
        return maybe.map(Employee::salary).orElse(0.0);
    }
}
