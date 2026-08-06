package com.lab.fundamentals.inheritance;

/**
 * Method overriding — PermanentEmployee and ContractEmployee replace calculatePay().
 */
public class MethodOverrideDemo {

    public static void main(String[] args) {
        PermanentEmployee permanent = new PermanentEmployee(
                "EMP-201", "Vikram Rao", "Finance", 100_000, 15_000, 0.12);
        ContractEmployee contract = new ContractEmployee(
                "EMP-202", "Neha Gupta", "Ops", 0, 800, 160);

        System.out.printf("Override: permanent=%.2f, contract=%.2f%n",
                overriddenPay(permanent), overriddenPay(contract));
    }

    static double overriddenPay(Employee employee) {
        return employee.calculatePay();
    }

    /** Permanent pay = base + benefits − PF; not equal to raw baseSalary. */
    static boolean permanentPayDiffersFromBase(PermanentEmployee employee) {
        return employee.calculatePay() != employee.baseSalary();
    }
}
