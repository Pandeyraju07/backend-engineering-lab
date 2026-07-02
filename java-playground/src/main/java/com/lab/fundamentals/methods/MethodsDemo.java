package com.lab.fundamentals.methods;

import java.util.List;

/**
 * HRMS employee onboarding — uses all method types in one flow.
 */
public class MethodsDemo {

    public static void main(String[] args) {
        OnboardingResult result = onboardEmployee("Raju Kumar", "Backend Engineering", 82_000, 'A',
                "EMAIL", "SMS", "PUSH");
        System.out.println(result);
    }

    static OnboardingResult onboardEmployee(String name, String department, double salary, char rating,
                                            String... notificationChannels) {
        if (!StaticMethodDemo.isValidEmail(toEmail(name))) {
            throw new IllegalArgumentException("Invalid employee email derived from name");
        }

        String employeeId = StaticMethodDemo.generateEmployeeId();
        Employee employee = new Employee(employeeId, name, department, salary);

        employee.activate();
        employee.promote(calculateJoiningBonus(salary, rating));

        double finalBonus = calculateJoiningBonus(employee);
        List<String> notifications = VarargsMethodDemo.sendNotifications(
                "Welcome " + name, notificationChannels);

        return new OnboardingResult(employee, finalBonus, notifications);
    }

    private static String toEmail(String name) {
        return name.toLowerCase().replace(" ", ".") + "@company.com";
    }

    private static double calculateJoiningBonus(double salary, char rating) {
        return MethodOverloadingDemo.calculateBonus(salary, rating) * 0.10;
    }

    private static double calculateJoiningBonus(Employee employee) {
        return MethodOverloadingDemo.calculateBonus(employee) * 0.10;
    }

    record OnboardingResult(Employee employee, double joiningBonus, List<String> notifications) {
        @Override
        public String toString() {
            return "OnboardingResult{employee=%s, joiningBonus=%.2f, notifications=%d}"
                    .formatted(employee, joiningBonus, notifications.size());
        }
    }
}
