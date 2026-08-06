package com.lab.fundamentals.abstraction;

/**
 * Abstract class idea — PaymentProcessor defines process(); BankTransferProcessor implements it.
 */
public class AbstractIdeaDemo {

    public static void main(String[] args) {
        PaymentProcessor processor = new BankTransferProcessor();
        Payable payable = new SalaryPayment("EMP-601", 85_000, "INR");
        System.out.println(runProcess(processor, payable));
    }

    static String runProcess(PaymentProcessor processor, Payable payable) {
        return processor.process(payable);
    }

    static boolean rejectsInvalid(PaymentProcessor processor) {
        return runProcess(processor, new SalaryPayment(" ", -1, "INR")).startsWith("REJECTED");
    }
}
