package com.lab.fundamentals.abstractclasses;

/**
 * HRMS abstract-class payroll — polymorphic base refs plus template-method net pay in one flow.
 */
public class AbstractClassesDemo {

    private static final double DEFAULT_TAX_RATE = 0.18;

    public static void main(String[] args) {
        AbstractPayrollResult result = runAbstractPayroll(
                AbstractBaseDemo.sampleStaff(), DEFAULT_TAX_RATE);
        System.out.println(result);
    }

    /**
     * Builds a payroll summary using {@link AbstractBaseDemo} totals and
     * {@link TemplateHookDemo} net/tax template hooks.
     */
    static AbstractPayrollResult runAbstractPayroll(AbstractEmployee[] staff, double taxRate) {
        if (staff == null || staff.length == 0) {
            throw new IllegalArgumentException("staff roster is required");
        }

        double grossTotal = AbstractBaseDemo.totalPayroll(staff);
        double netTotal = TemplateHookDemo.totalNetPayroll(taxRate, staff);
        double taxTotal = grossTotal - netTotal;

        int permanentCount = AbstractBaseDemo.countByType(PermanentStaff.class, staff);
        int contractorCount = AbstractBaseDemo.countByType(ContractorStaff.class, staff);

        String[] displayNames = new String[staff.length];
        for (int i = 0; i < staff.length; i++) {
            displayNames[i] = staff[i].displayName();
        }

        return new AbstractPayrollResult(
                staff.length,
                permanentCount,
                contractorCount,
                grossTotal,
                taxTotal,
                netTotal,
                taxRate,
                displayNames
        );
    }

    record AbstractPayrollResult(
            int employeeCount,
            int permanentCount,
            int contractorCount,
            double grossTotal,
            double taxTotal,
            double netTotal,
            double taxRate,
            String[] displayNames
    ) {
        @Override
        public String toString() {
            return ("AbstractPayroll{employees=%d, permanent=%d, contractors=%d, "
                    + "gross=%.2f, tax=%.2f, net=%.2f, taxRate=%.0f%%}")
                    .formatted(employeeCount, permanentCount, contractorCount,
                            grossTotal, taxTotal, netTotal, taxRate * 100);
        }
    }
}
