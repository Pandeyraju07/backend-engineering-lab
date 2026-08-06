package com.lab.fundamentals.typecasting;

/** Payroll money amount — stored as integer cents, viewable as double currency units. */
record PayrollAmount(long cents, String currency) {

    PayrollAmount {
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("currency is required");
        }
    }

    static PayrollAmount ofCents(long cents, String currency) {
        return new PayrollAmount(cents, currency);
    }

    static PayrollAmount ofAmount(double amount, String currency) {
        return new PayrollAmount(Math.round(amount * 100), currency);
    }

    double amount() {
        return cents / 100.0;
    }
}
