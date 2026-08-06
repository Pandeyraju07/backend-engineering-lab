package com.lab.fundamentals.interfaces;

/**
 * HRMS interface flow — contracts, default methods, and multiple interfaces together.
 */
public class InterfacesDemo {

    public static void main(String[] args) {
        InterfaceFlowResult result = runInterfaceFlow(
                new SalaryPayout("EMP-701", 88_000, "INR", "raju@company.com")
        );
        System.out.println(result);
    }

    static InterfaceFlowResult runInterfaceFlow(SalaryPayout payout) {
        String notifyResult = InterfaceContractDemo.callNotify(payout, "Payslip ready");
        String paySummary = InterfaceContractDemo.callPaySummary(payout);
        String audit = DefaultMethodDemo.runAudit(payout);
        boolean defaultAudit = DefaultMethodDemo.usesDefaultAudit(payout);
        String multi = MultipleInterfaceDemo.asPayableAndNotifiable(payout);
        boolean both = MultipleInterfaceDemo.implementsBoth(payout);

        return new InterfaceFlowResult(
                paySummary,
                notifyResult,
                audit,
                defaultAudit,
                multi,
                both,
                InterfaceContractDemo.channelOf(payout)
        );
    }

    record InterfaceFlowResult(
            String paySummary,
            String notifyResult,
            String audit,
            boolean usedDefaultAudit,
            String multiInterfaceSummary,
            boolean implementsBoth,
            String channel
    ) {
        @Override
        public String toString() {
            return "InterfaceFlow{pay=%s, notify=%s, audit=%s, both=%b, channel=%s}"
                    .formatted(paySummary, notifyResult, audit, implementsBoth, channel);
        }
    }
}
