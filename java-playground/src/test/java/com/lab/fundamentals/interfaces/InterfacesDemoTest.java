package com.lab.fundamentals.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterfacesDemoTest {

    @Test
    void interfaceContractCallsNotifyAndPay() {
        Notifiable notifier = new EmailNotifier("raju@company.com");
        Payable payout = new SalaryPayout("EMP-701", 88_000, "INR", "raju@company.com");

        assertEquals("EMAIL→raju@company.com: Payslip ready",
                InterfaceContractDemo.callNotify(notifier, "Payslip ready"));
        assertEquals("EMP-701|88000.00|INR", InterfaceContractDemo.callPaySummary(payout));
        assertEquals("EMAIL", InterfaceContractDemo.channelOf(notifier));
    }

    @Test
    void defaultMethodProducesAuditTrail() {
        Payable payout = new SalaryPayout("EMP-702", 95_000, "INR", "anita@company.com");

        assertEquals("AUDIT|EMP-702|95000.00 INR", DefaultMethodDemo.runAudit(payout));
        assertTrue(DefaultMethodDemo.usesDefaultAudit(payout));
    }

    @Test
    void multipleInterfacesOnSalaryPayout() {
        SalaryPayout payout = MultipleInterfaceDemo.samplePayout();

        assertTrue(MultipleInterfaceDemo.implementsBoth(payout));
        assertTrue(MultipleInterfaceDemo.asPayableAndNotifiable(payout).startsWith("EMP-703;EMAIL;"));
    }

    @Test
    void interfaceFlowIntegratesAllDemos() {
        InterfacesDemo.InterfaceFlowResult result = InterfacesDemo.runInterfaceFlow(
                new SalaryPayout("EMP-701", 88_000, "INR", "raju@company.com")
        );

        assertEquals("EMP-701|88000.00|INR", result.paySummary());
        assertTrue(result.notifyResult().contains("Payslip ready"));
        assertEquals("AUDIT|EMP-701|88000.00 INR", result.audit());
        assertTrue(result.usedDefaultAudit());
        assertTrue(result.implementsBoth());
        assertEquals("EMAIL", result.channel());
    }
}
