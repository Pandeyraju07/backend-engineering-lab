package com.lab.fundamentals.operators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorsDemoTest {

    @Test
    void arithmeticCalculatesNetAndOvertime() {
        assertEquals(64_000, ArithmeticDemo.calculateNet(80_000, 0.20));
        assertEquals(5_500, ArithmeticDemo.overtimePay(500, 10));
    }

    @Test
    void relationalChecksSeniorityAndEarnings() {
        assertTrue(RelationalDemo.isSenior(5));
        assertFalse(RelationalDemo.isSenior(4));
        assertTrue(RelationalDemo.isHighEarner(120_000, 100_000));
        assertFalse(RelationalDemo.isHighEarner(90_000, 100_000));
    }

    @Test
    void logicalApprovesBonusWhenEligible() {
        assertTrue(LogicalDemo.canApproveBonus(true, false, true));
        assertTrue(LogicalDemo.canApproveBonus(false, true, true));
        assertFalse(LogicalDemo.canApproveBonus(true, true, false));
        assertFalse(LogicalDemo.canApproveBonus(false, false, true));
    }

    @Test
    void bitwiseGrantsAndChecksFlags() {
        int flags = BitwiseDemo.FLAG_VIEW_PAYROLL;
        flags = BitwiseDemo.grantFlag(flags, BitwiseDemo.FLAG_APPROVE_BONUS);

        assertTrue(BitwiseDemo.hasFlag(flags, BitwiseDemo.FLAG_VIEW_PAYROLL));
        assertTrue(BitwiseDemo.hasFlag(flags, BitwiseDemo.FLAG_APPROVE_BONUS));
        assertFalse(BitwiseDemo.hasFlag(flags, BitwiseDemo.FLAG_ADMIN));
    }

    @Test
    void payrollEvaluationUsesAllOperatorDemos() {
        PayrollInput input = new PayrollInput(
                120_000,
                0.20,
                6,
                false,
                BitwiseDemo.FLAG_VIEW_PAYROLL
        );

        OperatorsDemo.OperatorPayrollResult result = OperatorsDemo.evaluatePayroll(input, 10);

        assertEquals(96_000, result.netPay());
        assertEquals(5_500, result.overtimePay());
        assertTrue(result.senior());
        assertTrue(result.highEarner());
        assertTrue(BitwiseDemo.hasFlag(result.flags(), BitwiseDemo.FLAG_APPROVE_BONUS));
        assertTrue(result.bonusApproved());
    }
}
