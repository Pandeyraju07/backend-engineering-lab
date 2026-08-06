package com.lab.fundamentals.throwthrows;

/**
 * Propagation — caller catches throw/throws failures and returns a status string.
 */
public class PropagateDemo {

    public static void main(String[] args) {
        System.out.println(processHire("Raju Kumar", 82_000));
        System.out.println(processHire("Anita", -5));
        System.out.println(processHire("  ", 50_000));
    }

    /**
     * Validates salary ({@link ThrowDemo}) then loads default hire policy ({@link ThrowsDemo}).
     * Returns {@code HIRED|name|salary|policy} or {@code REJECTED|reason}.
     */
    static String processHire(String name, double salary) {
        if (name == null || name.isBlank()) {
            return "REJECTED|blank name";
        }
        try {
            double validSalary = ThrowDemo.requirePositiveSalary(salary);
            String policy = ThrowsDemo.loadPolicy("STANDARD_HIRE");
            return "HIRED|%s|%.2f|%s".formatted(name.trim(), validSalary, policy);
        } catch (IllegalArgumentException ex) {
            return "REJECTED|" + ex.getMessage();
        } catch (Exception ex) {
            return "REJECTED|" + ex.getMessage();
        }
    }
}
