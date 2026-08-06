package com.lab.fundamentals.trycatch;

/**
 * try / catch / finally — parse a salary token and always run finally.
 */
public class TryCatchFinallyDemo {

    public static void main(String[] args) {
        SalaryParseOutcome ok = parseSalary("85000");
        SalaryParseOutcome bad = parseSalary("not-a-number");
        System.out.println("ok=" + ok + ", bad=" + bad);
    }

    /**
     * Parses {@code token} as a double. On failure returns {@code 0.0}.
     * {@code finallyRan} is always {@code true} after the attempt.
     */
    static SalaryParseOutcome parseSalary(String token) {
        double salary = 0.0;
        boolean success = false;
        boolean finallyRan = false;
        try {
            if (token == null || token.isBlank()) {
                throw new NumberFormatException("blank salary token");
            }
            salary = Double.parseDouble(token.trim());
            success = true;
        } catch (NumberFormatException ex) {
            salary = 0.0;
            success = false;
        } finally {
            finallyRan = true;
        }
        return new SalaryParseOutcome(salary, success, finallyRan);
    }

    /** Result of parseSalary including finally-ran flag. */
    record SalaryParseOutcome(double salary, boolean success, boolean finallyRan) {
    }
}
