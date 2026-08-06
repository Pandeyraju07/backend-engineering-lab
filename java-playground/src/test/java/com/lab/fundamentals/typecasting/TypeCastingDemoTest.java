package com.lab.fundamentals.typecasting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeCastingDemoTest {

    @Test
    void wideningConvertsIntSalaryToDouble() {
        assertEquals(75_000.0, WideningDemo.widenSalary(75_000));
        assertNotEquals(0L, WideningDemo.combineIdAndAmount(1001, 7_500_000L));
    }

    @Test
    void narrowingTruncatesRupeesAndClampsBonus() {
        assertEquals(82_450, NarrowingDemo.toWholeRupees(82_450.75));
        assertEquals(100, NarrowingDemo.clampBonusPercent(112.5));
        assertEquals(0, NarrowingDemo.clampBonusPercent(-5));
        assertEquals(25, NarrowingDemo.clampBonusPercent(25.9));
    }

    @Test
    void objectCastDowncastsIntegerAndReadsLong() {
        assertEquals(42, ObjectCastDemo.asInteger(Integer.valueOf(42)));
        assertNull(ObjectCastDemo.asInteger(Double.valueOf(3.14)));
        assertEquals(7_500_000L, ObjectCastDemo.safeLongValue(Long.valueOf(7_500_000L)));
        assertEquals(0L, ObjectCastDemo.safeLongValue(null));
    }

    @Test
    void payrollAmountStoresCentsAndAmount() {
        PayrollAmount fromCents = PayrollAmount.ofCents(8_245_000L, "INR");
        PayrollAmount fromAmount = PayrollAmount.ofAmount(82_450.0, "INR");

        assertEquals(82_450.0, fromCents.amount());
        assertEquals(8_245_000L, fromAmount.cents());
        assertEquals("INR", fromAmount.currency());
    }

    @Test
    void convertPayrollNumbersUsesAllCastTypes() {
        TypeCastingDemo.CastingResult result =
                TypeCastingDemo.convertPayrollNumbers(1001, 82_450, 12.5);

        assertEquals(82_450.0, result.widenedSalary());
        assertEquals(82_450, result.wholeRupees());
        assertEquals(12, result.bonusPercent());
        assertEquals(1001, result.employeeIdAsInteger());
        assertEquals(8_245_000L, result.safeCents());
        assertEquals("INR", result.payrollAmount().currency());
    }
}
