package com.lab.fundamentals.throwthrows;

/**
 * HRMS hire validation — throw, throws, and caller propagation in one flow.
 */
public class ThrowThrowsDemo {

    public static void main(String[] args) {
        ValidationFlowResult result = runValidationFlow("Priya Nair", 75_000);
        System.out.println(result);
    }

    static ValidationFlowResult runValidationFlow(String name, double salary) {
        boolean salaryOk;
        try {
            ThrowDemo.requirePositiveSalary(salary);
            salaryOk = true;
        } catch (IllegalArgumentException ex) {
            salaryOk = false;
        }

        boolean policyOk;
        String policy = "";
        try {
            policy = ThrowsDemo.loadPolicy("STANDARD_HIRE");
            policyOk = true;
        } catch (Exception ex) {
            policyOk = false;
        }

        boolean blankPolicyRejected;
        try {
            ThrowsDemo.loadPolicy("  ");
            blankPolicyRejected = false;
        } catch (Exception ex) {
            blankPolicyRejected = true;
        }

        String hireStatus = PropagateDemo.processHire(name, salary);
        boolean hired = hireStatus.startsWith("HIRED|");

        return new ValidationFlowResult(
                name,
                salary,
                salaryOk,
                policy,
                policyOk,
                blankPolicyRejected,
                hireStatus,
                hired
        );
    }

    record ValidationFlowResult(
            String name,
            double salary,
            boolean salaryOk,
            String policy,
            boolean policyOk,
            boolean blankPolicyRejected,
            String hireStatus,
            boolean hired
    ) {
        @Override
        public String toString() {
            return "ValidationFlowResult{name=%s, salary=%.2f, hired=%b, status=%s}"
                    .formatted(name, salary, hired, hireStatus);
        }
    }
}
