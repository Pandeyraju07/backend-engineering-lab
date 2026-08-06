package com.lab.fundamentals.io;

/** Parsed HR onboarding form fields. */
record OnboardingForm(String name, String department, double salary) {

    OnboardingForm {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException("department is required");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("salary must be non-negative");
        }
    }
}
