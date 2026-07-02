package com.lab.fundamentals.methods;

/** Method overloading — same method name, different parameters. */
public class MethodOverloadingDemo {

    public static void main(String[] args) {
        System.out.printf("Overloading: rating only=%.2f%n", calculateBonus(85_000, 'A'));
        System.out.printf("Overloading: dept+rating=%.2f%n", calculateBonus(85_000, "Engineering", 'A'));
        System.out.printf("Overloading: employee object=%.2f%n", calculateBonus(
                new Employee("EMP-200", "Alice", "Engineering", 90_000)));
    }

    static double calculateBonus(double salary, char rating) {
        return salary * ratingMultiplier(rating);
    }

    static double calculateBonus(double salary, String department, char rating) {
        double base = calculateBonus(salary, rating);
        return "Engineering".equalsIgnoreCase(department) ? base * 1.05 : base;
    }

    static double calculateBonus(Employee employee) {
        char rating = employee.salary() >= 90_000 ? 'A' : 'B';
        return calculateBonus(employee.salary(), employee.department(), rating);
    }

    private static double ratingMultiplier(char rating) {
        return switch (Character.toUpperCase(rating)) {
            case 'A' -> 0.15;
            case 'B' -> 0.10;
            case 'C' -> 0.05;
            default -> 0.0;
        };
    }
}
