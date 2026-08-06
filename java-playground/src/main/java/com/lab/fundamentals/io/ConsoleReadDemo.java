package com.lab.fundamentals.io;

/**
 * Console-style line parsing without blocking on System.in —
 * helpers accept the line text directly (pipe-delimited).
 */
public class ConsoleReadDemo {

    public static void main(String[] args) {
        OnboardingForm form = parseOnboardingLine("Raju Kumar|Backend Engineering|82000");
        System.out.println("Parsed: " + form);
    }

    /** Parses {@code name|dept|salary} into an {@link OnboardingForm}. */
    static OnboardingForm parseOnboardingLine(String line) {
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("onboarding line is required");
        }

        String[] parts = line.split("\\|", -1);
        if (parts.length != 3) {
            throw new IllegalArgumentException("expected name|dept|salary, got: " + line);
        }

        String name = parts[0].trim();
        String department = parts[1].trim();
        double salary = Double.parseDouble(parts[2].trim());
        return new OnboardingForm(name, department, salary);
    }
}
