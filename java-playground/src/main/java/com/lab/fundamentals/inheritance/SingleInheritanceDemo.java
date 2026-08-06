package com.lab.fundamentals.inheritance;

/**
 * Single inheritance — PermanentEmployee extends Employee and uses base fields.
 */
public class SingleInheritanceDemo {

    public static void main(String[] args) {
        PermanentEmployee emp = createSamplePermanent();
        System.out.printf("SingleInheritance: id=%s, name=%s, dept=%s, base=%.2f%n",
                emp.employeeId(), emp.name(), emp.department(), emp.baseSalary());
    }

    static PermanentEmployee createSamplePermanent() {
        return new PermanentEmployee("EMP-101", "Raju Kumar", "Engineering", 90_000, 12_000, 0.12);
    }

    /** Reads inherited base fields from a permanent employee. */
    static String baseFieldSummary(PermanentEmployee employee) {
        return "%s|%s|%s|%.2f".formatted(
                employee.employeeId(),
                employee.name(),
                employee.department(),
                employee.baseSalary()
        );
    }
}
