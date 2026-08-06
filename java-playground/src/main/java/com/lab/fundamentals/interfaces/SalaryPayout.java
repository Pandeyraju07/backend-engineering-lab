package com.lab.fundamentals.interfaces;

/**
 * Salary payout that implements Payable and Notifiable (multiple interfaces).
 */
class SalaryPayout implements Payable, Notifiable {

    private final String employeeId;
    private final double netAmount;
    private final String currency;
    private final String email;

    SalaryPayout(String employeeId, double netAmount, String currency, String email) {
        this.employeeId = employeeId;
        this.netAmount = netAmount;
        this.currency = currency;
        this.email = email;
    }

    @Override
    public String payeeId() {
        return employeeId;
    }

    @Override
    public double amountDue() {
        return netAmount;
    }

    @Override
    public String currency() {
        return currency;
    }

    @Override
    public String channel() {
        return "EMAIL";
    }

    @Override
    public String notify(String message) {
        return "EMAIL→%s: %s".formatted(email, message);
    }
}
