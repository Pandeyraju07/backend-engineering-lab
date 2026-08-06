package com.lab.fundamentals.interfaces;

/**
 * Default interface methods — Payable.audit() without override on SalaryPayout.
 */
public class DefaultMethodDemo {

    public static void main(String[] args) {
        Payable payout = new SalaryPayout("EMP-702", 95_000, "INR", "anita@company.com");
        System.out.println(runAudit(payout));
    }

    static String runAudit(Payable payable) {
        return payable.audit();
    }

    static boolean usesDefaultAudit(Payable payable) {
        String audit = runAudit(payable);
        return audit.startsWith("AUDIT|") && audit.contains(payable.payeeId());
    }
}
