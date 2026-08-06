package com.lab.fundamentals.interfaces;

/**
 * Interface contracts — call methods through Notifiable and Payable references.
 */
public class InterfaceContractDemo {

    public static void main(String[] args) {
        Notifiable notifier = new EmailNotifier("raju@company.com");
        Payable payout = new SalaryPayout("EMP-701", 88_000, "INR", "raju@company.com");

        System.out.println(callNotify(notifier, "Payslip ready"));
        System.out.println(callPaySummary(payout));
    }

    static String callNotify(Notifiable notifiable, String message) {
        return notifiable.notify(message);
    }

    static String callPaySummary(Payable payable) {
        return "%s|%.2f|%s".formatted(payable.payeeId(), payable.amountDue(), payable.currency());
    }

    static String channelOf(Notifiable notifiable) {
        return notifiable.channel();
    }
}
