package com.lab.fundamentals.abstraction;

/** Salary line item that implements the Payable interface. */
class SalaryPayment implements Payable {

    private final String employeeId;
    private final double netSalary;
    private final String currency;

    SalaryPayment(String employeeId, double netSalary, String currency) {
        this.employeeId = employeeId;
        this.netSalary = netSalary;
        this.currency = currency;
    }

    @Override
    public String payeeId() {
        return employeeId;
    }

    @Override
    public double amountDue() {
        return netSalary;
    }

    @Override
    public String currency() {
        return currency;
    }
}
