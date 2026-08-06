package com.lab.fundamentals.polymorphism;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolymorphismDemoTest {

    @Test
    void runtimePolySumsMixedEmployeePay() {
        Employee[] payroll = RuntimePolyDemo.samplePayroll();

        assertEquals(3, payroll.length);
        assertEquals(2, RuntimePolyDemo.permanentCount(payroll));
        assertEquals(100_000 + 120_000 + 77_000, RuntimePolyDemo.totalPay(payroll));
    }

    @Test
    void upcastingKeepsOverriddenPayBehavior() {
        PermanentEmployee permanent = new PermanentEmployee(
                "EMP-501", "Kavita Nair", "HR", 80_000, 9_000);
        ContractEmployee contract = new ContractEmployee(
                "EMP-502", "Rohit Sen", "Ops", 600, 100);

        Employee asEmployee = UpcastingDemo.upcastPermanent(permanent);

        assertEquals("EMP-501|PERMANENT|89000.00", UpcastingDemo.describe(asEmployee));
        assertEquals("EMP-502|CONTRACT|60000.00", UpcastingDemo.describe(contract));
        assertEquals(89_000, asEmployee.calculatePay());
    }

    @Test
    void payrollProcessorIntegratesRuntimeAndUpcast() {
        PolymorphismDemo.PolyPayrollResult result =
                PolymorphismDemo.processPayroll(RuntimePolyDemo.samplePayroll());

        assertEquals(3, result.employeeCount());
        assertEquals(2, result.permanentCount());
        assertEquals(297_000, result.totalPay());
        assertTrue(result.firstEmployeeDescribe().startsWith("EMP-401|PERMANENT|"));
        assertEquals(89_000, result.upcastPay());
        assertTrue(result.upcastDescribe().contains("PERMANENT"));
    }
}
