package com.lab.fundamentals.inheritance;

/**
 * HRMS inheritance payroll — single inheritance, super, and override in one flow.
 */
public class InheritanceDemo {

    public static void main(String[] args) {
        InheritanceResult result = runInheritancePayroll();
        System.out.println(result);
    }

    static InheritanceResult runInheritancePayroll() {
        PermanentEmployee permanent = SingleInheritanceDemo.createSamplePermanent();
        ContractEmployee contract = new ContractEmployee(
                "EMP-301", "Suresh Patel", "Support", 0, 650, 140);

        String baseFields = SingleInheritanceDemo.baseFieldSummary(permanent);
        String superDescribe = SuperKeywordDemo.describe(permanent);
        double permanentPay = MethodOverrideDemo.overriddenPay(permanent);
        double contractPay = MethodOverrideDemo.overriddenPay(contract);
        double totalPay = permanentPay + contractPay;

        return new InheritanceResult(
                baseFields,
                superDescribe,
                SuperKeywordDemo.usesSuperDescribe(permanent),
                permanentPay,
                contractPay,
                totalPay,
                MethodOverrideDemo.permanentPayDiffersFromBase(permanent)
        );
    }

    record InheritanceResult(
            String baseFieldSummary,
            String permanentDescribe,
            boolean usedSuperDescribe,
            double permanentPay,
            double contractPay,
            double totalPay,
            boolean payOverridden
    ) {
        @Override
        public String toString() {
            return "InheritanceResult{base=%s, permanentPay=%.2f, contractPay=%.2f, total=%.2f, super=%b, override=%b}"
                    .formatted(baseFieldSummary, permanentPay, contractPay, totalPay,
                            usedSuperDescribe, payOverridden);
        }
    }
}
