package com.lab.fundamentals.abstraction;

/**
 * HRMS payment channel — abstract processor + Payable interface in one flow.
 */
public class AbstractionDemo {

    public static void main(String[] args) {
        PaymentResult result = runPaymentFlow(
                new SalaryPayment("EMP-601", 85_000, "INR"),
                new BankTransferProcessor()
        );
        System.out.println(result);
    }

    static PaymentResult runPaymentFlow(Payable payable, PaymentProcessor processor) {
        String interfaceSummary = InterfaceVsClassDemo.summarize(payable);
        boolean interfaceImpl = InterfaceVsClassDemo.isSalaryPayment(payable);
        boolean valid = processor.validate(payable);
        String processResult = AbstractIdeaDemo.runProcess(processor, payable);
        boolean rejectedInvalid = AbstractIdeaDemo.rejectsInvalid(processor);

        return new PaymentResult(
                payable.payeeId(),
                payable.amountDue(),
                processor.channelName(),
                interfaceSummary,
                interfaceImpl,
                valid,
                processResult,
                rejectedInvalid
        );
    }

    record PaymentResult(
            String payeeId,
            double amount,
            String channel,
            String interfaceSummary,
            boolean usesSalaryPayment,
            boolean valid,
            String processResult,
            boolean rejectsInvalid
    ) {
        @Override
        public String toString() {
            return "PaymentResult{payee=%s, amount=%.2f, channel=%s, valid=%b, result=%s}"
                    .formatted(payeeId, amount, channel, valid, processResult);
        }
    }
}
