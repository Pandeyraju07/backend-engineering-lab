package com.lab.fundamentals.throwthrows;

/**
 * throws — checked Exception declared on HR policy load.
 */
public class ThrowsDemo {

    public static void main(String[] args) {
        try {
            System.out.println(loadPolicy("PROBATION_90_DAYS"));
            loadPolicy("  ");
        } catch (Exception ex) {
            System.out.println("policy error: " + ex.getMessage());
        }
    }

    /**
     * Loads a hire policy name. Blank / null policy throws checked {@link Exception}.
     */
    static String loadPolicy(String policyName) throws Exception {
        if (policyName == null || policyName.isBlank()) {
            throw new Exception("hire policy is required");
        }
        return policyName.trim();
    }
}
