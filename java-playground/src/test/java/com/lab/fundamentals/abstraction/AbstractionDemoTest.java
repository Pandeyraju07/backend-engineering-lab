package com.lab.fundamentals.abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractionDemoTest {

    @Test
    void abstractProcessorProcessesValidPayable() {
        PaymentProcessor processor = new BankTransferProcessor();
        Payable payable = new SalaryPayment("EMP-601", 85_000, "INR");

        String result = AbstractIdeaDemo.runProcess(processor, payable);

        assertTrue(result.startsWith("PAID|BANK_TRANSFER|EMP-601|"));
        assertTrue(AbstractIdeaDemo.rejectsInvalid(processor));
    }

    @Test
    void interfacePayableImplementedBySalaryPayment() {
        Payable payable = InterfaceVsClassDemo.sampleSalary();

        assertEquals("EMP-602 owes 92500.00 INR", InterfaceVsClassDemo.summarize(payable));
        assertTrue(InterfaceVsClassDemo.isSalaryPayment(payable));
        assertEquals(92_500, payable.amountDue());
    }

    @Test
    void paymentFlowIntegratesAbstractAndInterface() {
        AbstractionDemo.PaymentResult result = AbstractionDemo.runPaymentFlow(
                new SalaryPayment("EMP-601", 85_000, "INR"),
                new BankTransferProcessor()
        );

        assertEquals("EMP-601", result.payeeId());
        assertEquals(85_000, result.amount());
        assertEquals("BANK_TRANSFER", result.channel());
        assertTrue(result.usesSalaryPayment());
        assertTrue(result.valid());
        assertTrue(result.processResult().contains("PAID|"));
        assertTrue(result.rejectsInvalid());
    }
}
