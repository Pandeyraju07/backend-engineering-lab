package com.lab.fundamentals.variables;

/** HRMS employee onboarding — all Java variable concepts in one example. */
public class VariablesDemo {

    private static int totalEmployeesRegistered = 0;

    private static final String COMPANY_NAME = "Acme Corp";
    private static final int MAX_EMPLOYEE_AGE = 65;
    private static final double MIN_SALARY = 20_000.0;

    public static void main(String[] args) {
        demonstratePrimitiveAndReferenceVariables();
        demonstrateLocalScope();
        demonstrateVarKeyword();
        demonstrateFinalVariables("EMP-1001");
        demonstrateInstanceVsStatic();
        demonstrateShadowing();
        demonstrateDefaultFieldValues();
        demonstrateReferenceBehavior();
    }

    private static void demonstratePrimitiveAndReferenceVariables() {
        byte tierCode = 1;
        short leaveBalance = 12;
        int age = 28;
        long employeeNumber = 9_001_234_567L;
        float bonusPercent = 10.5f;
        double salary = 85_000.75;
        char performanceGrade = 'A';
        boolean isActive = true;

        String fullName = "Raju Kumar";
        String department = "Backend Engineering";
        int[] skillRatings = {4, 5, 5, 4};

        System.out.printf("Employee: %s | Dept: %s | Age: %d | Salary: %.2f | Active: %b%n",
                fullName, department, age, salary, isActive);
        System.out.printf("Tier: %d | Leave: %d | Emp#: %d | Bonus: %.1f%% | Grade: %c%n",
                tierCode, leaveBalance, employeeNumber, bonusPercent, performanceGrade);
        System.out.println("Skill ratings: " + skillRatings.length);
    }

    private static void demonstrateLocalScope() {
        String officeLocation = "Bangalore";

        if (isValidLocation(officeLocation)) {
            String welcomeMessage = "Welcome to " + officeLocation;
            System.out.println(welcomeMessage);
        }

        for (int day = 1; day <= 3; day++) {
            System.out.println("Onboarding day: " + day);
        }
    }

    private static boolean isValidLocation(String location) {
        return location != null && !location.isBlank();
    }

    private static void demonstrateVarKeyword() {
        var employeeId = "EMP-2048";
        var baseSalary = 72_000.0;
        var roles = new String[]{"DEVELOPER", "REVIEWER"};

        System.out.println("employeeId: " + employeeId);
        System.out.println("baseSalary: " + baseSalary);
        System.out.println("role: " + roles[0]);
    }

    private static void demonstrateFinalVariables(String employeeId) {
        final String onboardingBatch = "BATCH-2026-Q2";
        final double taxRate = 0.18;

        double grossSalary = 90_000;
        final double netSalary = grossSalary * (1 - taxRate);

        System.out.println("Batch: " + onboardingBatch);
        System.out.println("Employee: " + employeeId);
        System.out.printf("Net salary: %.2f%n", netSalary);
    }

    private static void demonstrateInstanceVsStatic() {
        Employee first = new Employee("EMP-001", "Alice", 30, 80_000);
        Employee second = new Employee("EMP-002", "Bob", 27, 75_000);

        first.promote(5_000);
        second.promote(3_000);

        System.out.println(first);
        System.out.println(second);
        System.out.println("Total registered: " + totalEmployeesRegistered);
        System.out.println("Company: " + COMPANY_NAME);
    }

    private static void demonstrateShadowing() {
        Employee employee = new Employee("EMP-010", "Carol", 32, 95_000);
        employee.updateName("Carol Updated");
        System.out.println(employee);
    }

    private static void demonstrateDefaultFieldValues() {
        System.out.println(new DefaultValueSnapshot());
    }

    private static void demonstrateReferenceBehavior() {
        Employee original = new Employee("EMP-020", "David", 29, 70_000);
        Employee alias = original;

        alias.promote(2_000);
        System.out.println("original: " + original);
        System.out.println("alias: " + alias);

        String status = "ACTIVE";
        String statusCopy = status;
        status = "INACTIVE";
        System.out.println("status: " + status + " | statusCopy: " + statusCopy);
    }

    static class Employee {

        private final String employeeId;
        private String name;
        private int age;
        private double salary;
        private boolean active = true;

        Employee(String employeeId, String name, int age, double salary) {
            validateEmployee(employeeId, name, age, salary);

            this.employeeId = employeeId;
            this.name = name;
            this.age = age;
            this.salary = salary;

            totalEmployeesRegistered++;
        }

        void promote(double increment) {
            if (increment <= 0) {
                throw new IllegalArgumentException("Increment must be positive");
            }
            salary += increment;
        }

        void updateName(String name) {
            System.out.println("Parameter name: " + name);
            System.out.println("Field name: " + this.name);
            this.name = name;
        }

        private static void validateEmployee(String employeeId, String name, int age, double salary) {
            if (employeeId == null || employeeId.isBlank()) {
                throw new IllegalArgumentException("employeeId is required");
            }
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name is required");
            }
            if (age <= 0 || age > MAX_EMPLOYEE_AGE) {
                throw new IllegalArgumentException("Invalid age: " + age);
            }
            if (salary < MIN_SALARY) {
                throw new IllegalArgumentException("Salary below minimum: " + salary);
            }
        }

        @Override
        public String toString() {
            return "Employee{id='%s', name='%s', age=%d, salary=%.2f, active=%b}"
                    .formatted(employeeId, name, age, salary, active);
        }
    }

    static class DefaultValueSnapshot {
        byte byteDefault;
        short shortDefault;
        int intDefault;
        long longDefault;
        float floatDefault;
        double doubleDefault;
        char charDefault;
        boolean booleanDefault;
        String referenceDefault;

        @Override
        public String toString() {
            return """
                    Defaults -> byte=%d, short=%d, int=%d, long=%d, float=%f, double=%f, char=%c, boolean=%b, String=%s
                    """.formatted(
                    byteDefault, shortDefault, intDefault, longDefault,
                    floatDefault, doubleDefault, charDefault, booleanDefault, referenceDefault
            );
        }
    }
}
