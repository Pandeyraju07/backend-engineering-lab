package com.lab.fundamentals.datatypes;

/** Wrapper types — boxing/unboxing and null-safe parsing for payroll intake. */
public class WrapperDemo {

    public static void main(String[] args) {
        Double salary = parseSalary("92000.75");
        Character grade = toGrade('B');

        System.out.println("Wrappers: parsedSalary=" + salary + ", grade=" + grade);
        System.out.println("Wrappers: null salary=" + parseSalary(null) + ", null grade=" + toGrade(null));

        // Autoboxing / unboxing demo
        Integer leaveDays = 12;
        int days = leaveDays;
        System.out.println("Wrappers: boxed leave=" + leaveDays + ", unboxed=" + days);
    }

    static Double parseSalary(String raw) {
        if (raw == null || raw.isBlank()) {
            return null;
        }
        try {
            return Double.valueOf(raw.trim());
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    static char toGrade(Character grade) {
        if (grade == null) {
            return 'C';
        }
        char value = Character.toUpperCase(grade);
        return switch (value) {
            case 'A', 'B', 'C', 'D' -> value;
            default -> 'C';
        };
    }
}
