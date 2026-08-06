package com.lab.fundamentals.abstractclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractClassesDemoTest {

    @Test
    void permanentAndContractorComputeMonthlyPay() {
        AbstractEmployee permanent = new PermanentStaff(
                "EMP-101", "Asha Verma", "Engineering", 90_000, 10_000);
        AbstractEmployee contractor = new ContractorStaff(
                "CTR-202", "Rohit Sen", "Engineering", 800, 160);

        assertEquals(100_000, permanent.monthlyPay());
        assertEquals(128_000, contractor.monthlyPay());
        assertEquals("Asha Verma (EMP-101)", permanent.displayName());
        assertEquals("Rohit Sen (CTR-202)", contractor.displayName());
    }

    @Test
    void abstractBaseTotalsPayrollViaSupertypeRefs() {
        AbstractEmployee[] staff = AbstractBaseDemo.sampleStaff();

        assertEquals(3, staff.length);
        assertEquals(363_000, AbstractBaseDemo.totalPayroll(staff));
        assertEquals(2, AbstractBaseDemo.countByType(PermanentStaff.class, staff));
        assertEquals(1, AbstractBaseDemo.countByType(ContractorStaff.class, staff));
    }

    @Test
    void templateHookAppliesTaxAfterMonthlyPay() {
        AbstractEmployee permanent = new PermanentStaff(
                "EMP-101", "Asha Verma", "Engineering", 90_000, 10_000);

        assertEquals(80_000, TemplateHookDemo.netPay(permanent, 0.20));
        assertEquals(20_000, TemplateHookDemo.taxWithheld(permanent, 0.20));
        assertEquals(permanent.processPayroll(0.10), TemplateHookDemo.netPay(permanent, 0.10));
    }

    @Test
    void templateHookTotalsNetPayroll() {
        AbstractEmployee[] staff = {
                new PermanentStaff("EMP-1", "A", "Eng", 100_000, 0),
                new ContractorStaff("CTR-1", "B", "Eng", 500, 100)
        };

        assertEquals(120_000, AbstractBaseDemo.totalPayroll(staff));
        assertEquals(96_000, TemplateHookDemo.totalNetPayroll(0.20, staff));
    }

    @Test
    void runAbstractPayrollUsesBaseAndTemplateDemos() {
        AbstractEmployee[] staff = AbstractBaseDemo.sampleStaff();
        AbstractClassesDemo.AbstractPayrollResult result =
                AbstractClassesDemo.runAbstractPayroll(staff, 0.18);

        assertEquals(3, result.employeeCount());
        assertEquals(2, result.permanentCount());
        assertEquals(1, result.contractorCount());
        assertEquals(363_000, result.grossTotal());
        assertEquals(result.grossTotal() - result.netTotal(), result.taxTotal(), 0.0001);
        assertEquals(363_000 * 0.82, result.netTotal(), 0.0001);
        assertEquals(0.18, result.taxRate());
        assertEquals(3, result.displayNames().length);
        assertTrue(result.displayNames()[0].contains("EMP-101"));
    }
}
