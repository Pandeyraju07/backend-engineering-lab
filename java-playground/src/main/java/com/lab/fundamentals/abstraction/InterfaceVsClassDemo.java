package com.lab.fundamentals.abstraction;

/**
 * Interface vs class — SalaryPayment implements Payable; callers depend on the interface type.
 */
public class InterfaceVsClassDemo {

    public static void main(String[] args) {
        Payable payable = sampleSalary();
        System.out.println(summarize(payable));
    }

    static Payable sampleSalary() {
        return new SalaryPayment("EMP-602", 92_500, "INR");
    }

    static String summarize(Payable payable) {
        return "%s owes %.2f %s".formatted(
                payable.payeeId(),
                payable.amountDue(),
                payable.currency()
        );
    }

    static boolean isSalaryPayment(Payable payable) {
        return payable instanceof SalaryPayment;
    }
}
