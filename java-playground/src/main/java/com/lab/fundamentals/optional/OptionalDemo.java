package com.lab.fundamentals.optional;

import java.util.List;
import java.util.Optional;

/**
 * HRMS directory lookup — Optional create + chain helpers in one employee find flow.
 */
public class OptionalDemo {

    public static void main(String[] args) {
        OptionalLookupResult result = runEmployeeLookup(
                OptionalCreateDemo.sampleDirectory(), "E001", "E999");
        System.out.println(result);
    }

    static OptionalLookupResult runEmployeeLookup(
            List<Employee> directory, String knownId, String missingId) {
        Optional<Employee> found = OptionalCreateDemo.findById(directory, knownId);
        Optional<Employee> missing = OptionalCreateDemo.findById(directory, missingId);
        Optional<Employee> nullableEmpty = OptionalCreateDemo.ofNullableEmployee(null);

        String email = OptionalChainDemo.emailOrDefault(found, "noreply@hrms.lab");
        String missingEmail = OptionalChainDemo.emailOrDefault(missing, "noreply@hrms.lab");
        String department = OptionalChainDemo.departmentOrThrow(found);
        String displayName = OptionalChainDemo.displayName(found);
        Optional<String> normalized = OptionalChainDemo.normalizedEmail(found);
        double salary = OptionalChainDemo.salaryOrZero(found);

        return new OptionalLookupResult(
                OptionalCreateDemo.isPresent(found),
                !OptionalCreateDemo.isPresent(missing),
                nullableEmpty.isEmpty(),
                email,
                missingEmail,
                department,
                displayName,
                normalized.orElse(""),
                salary
        );
    }

    record OptionalLookupResult(
            boolean foundPresent,
            boolean missingAbsent,
            boolean nullableWasEmpty,
            String resolvedEmail,
            String fallbackEmail,
            String department,
            String displayName,
            String normalizedEmail,
            double salary
    ) {
        @Override
        public String toString() {
            return ("OptionalLookup{found=%b, missingAbsent=%b, nullableEmpty=%b, email=%s, "
                    + "fallback=%s, dept=%s, name=%s, normalized=%s, salary=%.2f}")
                    .formatted(foundPresent, missingAbsent, nullableWasEmpty, resolvedEmail,
                            fallbackEmail, department, displayName, normalizedEmail, salary);
        }
    }
}
