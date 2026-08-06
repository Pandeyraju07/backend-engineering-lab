package com.lab.fundamentals.methodreference;

/**
 * HRMS employee used across method-reference demos (static, instance, constructor).
 */
class Employee {

    private final String employeeId;
    private final String name;
    private final String department;
    private final double salary;

    /** Single-arg constructor — used with {@code Employee::new} from formatted ids. */
    Employee(String employeeId) {
        this(employeeId, "Pending Hire", "Unassigned", 0);
    }

    Employee(String employeeId, String name, String department, double salary) {
        if (employeeId == null || employeeId.isBlank()) {
            throw new IllegalArgumentException("employeeId is required");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException("department is required");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("salary must be non-negative");
        }
        this.employeeId = employeeId.trim();
        this.name = name.trim();
        this.department = department.trim();
        this.salary = salary;
    }

    /** Formats a numeric badge into a standard HRMS id — target for {@code Employee::formatId}. */
    static String formatId(String rawNumericId) {
        if (rawNumericId == null || rawNumericId.isBlank()) {
            throw new IllegalArgumentException("raw id is required");
        }
        String trimmed = rawNumericId.trim();
        if (trimmed.startsWith("EMP-")) {
            return trimmed;
        }
        return "EMP-" + trimmed;
    }

    String employeeId() {
        return employeeId;
    }

    String name() {
        return name;
    }

    String department() {
        return department;
    }

    double salary() {
        return salary;
    }

    /** Unbound instance method target — {@code Employee::displayName}. */
    String displayName() {
        return name;
    }

    /** Unbound instance method target — {@code Employee::departmentLabel}. */
    String departmentLabel() {
        return department.toUpperCase();
    }

    boolean isPlaceholder() {
        return "Pending Hire".equals(name) && salary == 0;
    }

    @Override
    public String toString() {
        return "Employee{id='%s', name='%s', dept='%s', salary=%.2f}"
                .formatted(employeeId, name, department, salary);
    }
}
