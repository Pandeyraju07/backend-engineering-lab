package com.lab.fundamentals.abstraction;

/** Concrete channel — pays via NEFT/IMPS style bank transfer. */
class BankTransferProcessor extends PaymentProcessor {

    BankTransferProcessor() {
        super("BANK_TRANSFER");
    }

    @Override
    String process(Payable payable) {
        if (!validate(payable)) {
            return "REJECTED|" + channelName();
        }
        return "PAID|%s|%s|%.2f %s".formatted(
                channelName(),
                payable.payeeId(),
                payable.amountDue(),
                payable.currency()
        );
    }
}
