package com.lab.fundamentals.interfaces;

/**
 * HRMS payout contract with a default audit() helper.
 */
interface Payable {

    String payeeId();

    double amountDue();

    String currency();

    /** Default audit trail entry for any payable. */
    default String audit() {
        return "AUDIT|%s|%.2f %s".formatted(payeeId(), amountDue(), currency());
    }
}
