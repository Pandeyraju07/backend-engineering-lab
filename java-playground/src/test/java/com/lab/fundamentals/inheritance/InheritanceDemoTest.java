package com.lab.fundamentals.inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InheritanceDemoTest {

    @Test
    void singleInheritanceExposesBaseFields() {
        PermanentEmployee emp = SingleInheritanceDemo.createSamplePermanent();

        assertEquals("EMP-101|Raju Kumar|Engineering|90000.00",
                SingleInheritanceDemo.baseFieldSummary(emp));
        assertEquals("EMP-101", emp.employeeId());
        assertEquals(90_000, emp.baseSalary());
    }

    @Test
    void superKeywordBuildsDescribeFromBaseAndSubclass() {
        PermanentEmployee emp = new PermanentEmployee(
                "EMP-102", "Anita Sharma", "HR", 75_000, 8_000, 0.10);

        String text = SuperKeywordDemo.describe(emp);

        assertTrue(text.contains("Anita Sharma"));
        assertTrue(text.contains("[permanent"));
        assertTrue(SuperKeywordDemo.usesSuperDescribe(emp));
    }

    @Test
    void methodOverrideCalculatesDifferentPayRules() {
        PermanentEmployee permanent = new PermanentEmployee(
                "EMP-201", "Vikram Rao", "Finance", 100_000, 15_000, 0.12);
        ContractEmployee contract = new ContractEmployee(
                "EMP-202", "Neha Gupta", "Ops", 0, 800, 160);

        assertEquals(103_000, MethodOverrideDemo.overriddenPay(permanent));
        assertEquals(128_000, MethodOverrideDemo.overriddenPay(contract));
        assertTrue(MethodOverrideDemo.permanentPayDiffersFromBase(permanent));
    }

    @Test
    void inheritancePayrollIntegratesAllDemos() {
        InheritanceDemo.InheritanceResult result = InheritanceDemo.runInheritancePayroll();

        assertTrue(result.baseFieldSummary().startsWith("EMP-101|"));
        assertTrue(result.usedSuperDescribe());
        assertEquals(90_000 + 12_000 - (90_000 * 0.12), result.permanentPay());
        assertEquals(650 * 140, result.contractPay());
        assertEquals(result.permanentPay() + result.contractPay(), result.totalPay());
        assertTrue(result.payOverridden());
    }
}
