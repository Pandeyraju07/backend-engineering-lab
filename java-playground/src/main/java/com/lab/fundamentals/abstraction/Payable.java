package com.lab.fundamentals.abstraction;

/** Contract for anything that can produce an HRMS payment amount. */
interface Payable {

    String payeeId();

    double amountDue();

    String currency();
}
