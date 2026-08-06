package com.lab.fundamentals.finalkeyword;

/**
 * HRMS final-keyword lesson — final vars, methods, and classes in one flow.
 */
public class FinalKeywordDemo {

    public static void main(String[] args) {
        FinalFlowResult result = runFinalFlow("  emp-501  ", "Priya Nair");
        System.out.println(result);
    }

    static FinalFlowResult runFinalFlow(String rawId, String name) {
        String normalized = FinalVariableDemo.normalizeId(rawId);
        String badge = FinalVariableDemo.badgeLabel(rawId, name);

        FinalMethodDemo.DepartmentPolicy policy = new FinalMethodDemo.DepartmentPolicy();
        double taxRate = FinalMethodDemo.lockedTaxRate(policy);
        double bonusRate = FinalMethodDemo.adjustableBonusRate(policy);
        boolean taxLocked = FinalMethodDemo.taxRateIsFinalConstant();

        FinalClassDemo.EmployeeId employeeId = FinalClassDemo.wrap(rawId);
        String idDisplay = FinalClassDemo.display(employeeId);

        return new FinalFlowResult(
                normalized,
                badge,
                taxRate,
                bonusRate,
                taxLocked,
                employeeId.value(),
                idDisplay
        );
    }

    record FinalFlowResult(
            String normalizedId,
            String badgeLabel,
            double taxRate,
            double bonusRate,
            boolean taxRateLockedAcrossPolicies,
            String finalClassId,
            String idDisplay
    ) {
        @Override
        public String toString() {
            return ("FinalFlowResult{id=%s, badge=%s, tax=%.2f, bonus=%.2f, "
                    + "taxLocked=%b, finalClassId=%s, display=%s}")
                    .formatted(normalizedId, badgeLabel, taxRate, bonusRate,
                            taxRateLockedAcrossPolicies, finalClassId, idDisplay);
        }
    }
}
