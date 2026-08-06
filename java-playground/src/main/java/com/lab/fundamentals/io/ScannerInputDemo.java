package com.lab.fundamentals.io;

import java.util.Scanner;

/**
 * Scanner input — reads CSV onboarding fields from a String-backed Scanner
 * (never blocks on real System.in).
 */
public class ScannerInputDemo {

    public static void main(String[] args) {
        OnboardingForm form = readForm("Priya Sharma,People Ops,75000");
        System.out.println("Scanner form: " + form);
    }

    /** Reads {@code name,department,salary} via {@code new Scanner(input)}. */
    static OnboardingForm readForm(String csvLine) {
        if (csvLine == null || csvLine.isBlank()) {
            throw new IllegalArgumentException("csv line is required");
        }

        try (Scanner scanner = new Scanner(csvLine)) {
            scanner.useDelimiter(",");
            if (!scanner.hasNext()) {
                throw new IllegalArgumentException("missing name in: " + csvLine);
            }
            String name = scanner.next().trim();

            if (!scanner.hasNext()) {
                throw new IllegalArgumentException("missing department in: " + csvLine);
            }
            String department = scanner.next().trim();

            if (!scanner.hasNext()) {
                throw new IllegalArgumentException("missing salary in: " + csvLine);
            }
            double salary = Double.parseDouble(scanner.next().trim());

            return new OnboardingForm(name, department, salary);
        }
    }
}
