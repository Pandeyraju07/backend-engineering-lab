package com.lab.fundamentals.abstraction;

/**
 * Abstract payment processor — shared validation; subclasses implement process().
 */
abstract class PaymentProcessor {

    private final String channelName;

    protected PaymentProcessor(String channelName) {
        this.channelName = channelName;
    }

    String channelName() {
        return channelName;
    }

    /** Shared pre-check before channel-specific processing. */
    final boolean validate(Payable payable) {
        return payable != null
                && payable.payeeId() != null
                && !payable.payeeId().isBlank()
                && payable.amountDue() > 0;
    }

    abstract String process(Payable payable);
}
