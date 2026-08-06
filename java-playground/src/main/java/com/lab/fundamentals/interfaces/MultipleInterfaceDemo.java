package com.lab.fundamentals.interfaces;

/**
 * Multiple interfaces — SalaryPayout is both Payable and Notifiable.
 */
public class MultipleInterfaceDemo {

    public static void main(String[] args) {
        SalaryPayout payout = samplePayout();
        System.out.println(asPayableAndNotifiable(payout));
    }

    static SalaryPayout samplePayout() {
        return new SalaryPayout("EMP-703", 72_500, "INR", "vikram@company.com");
    }

    static String asPayableAndNotifiable(SalaryPayout payout) {
        Payable payable = payout;
        Notifiable notifiable = payout;
        return "%s;%s;%s".formatted(
                payable.payeeId(),
                notifiable.channel(),
                notifiable.notify("Salary credited")
        );
    }

    static boolean implementsBoth(Object candidate) {
        return candidate instanceof Payable && candidate instanceof Notifiable;
    }
}
