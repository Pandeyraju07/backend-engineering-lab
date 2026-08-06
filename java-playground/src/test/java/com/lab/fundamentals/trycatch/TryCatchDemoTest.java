package com.lab.fundamentals.trycatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TryCatchDemoTest {

    @Test
    void parseSalarySucceedsAndFinallyAlwaysRuns() {
        TryCatchFinallyDemo.SalaryParseOutcome ok = TryCatchFinallyDemo.parseSalary("85000");
        TryCatchFinallyDemo.SalaryParseOutcome bad = TryCatchFinallyDemo.parseSalary("abc");
        TryCatchFinallyDemo.SalaryParseOutcome blank = TryCatchFinallyDemo.parseSalary("  ");

        assertTrue(ok.success());
        assertEquals(85_000, ok.salary());
        assertTrue(ok.finallyRan());

        assertFalse(bad.success());
        assertEquals(0.0, bad.salary());
        assertTrue(bad.finallyRan());

        assertFalse(blank.success());
        assertTrue(blank.finallyRan());
    }

    @Test
    void multiCatchSafeParseIntHandlesNullAndBadInput() {
        assertEquals(12, MultiCatchDemo.safeParseInt("12"));
        assertEquals(-1, MultiCatchDemo.safeParseInt(null));
        assertEquals(-1, MultiCatchDemo.safeParseInt("x"));
        assertEquals(-1, MultiCatchDemo.safeParseInt("  "));
    }

    @Test
    void tryWithResourcesReadsFirstPayrollLine() {
        assertEquals(
                "EMP-1001|85000",
                TryWithResourcesDemo.readFirstLine("EMP-1001|85000\nEMP-1002|72000\n")
        );
        assertEquals("", TryWithResourcesDemo.readFirstLine(""));
        assertEquals("", TryWithResourcesDemo.readFirstLine(null));
    }

    @Test
    void parsePayrollSafelyIntegratesAllHelpers() {
        TryCatchDemo.ParseResult result =
                TryCatchDemo.parsePayrollSafely(new PayrollLine("EMP-9001|85000.50"));

        assertEquals("EMP-9001", result.employeeId());
        assertEquals(85_000.50, result.salary());
        assertTrue(result.finallyRan());
        assertEquals(9001, result.parsedCode());
        assertTrue(result.success());
    }

    @Test
    void parsePayrollSafelyFailsGracefullyOnBadSalary() {
        TryCatchDemo.ParseResult result =
                TryCatchDemo.parsePayrollSafely(new PayrollLine("EMP-1|not-money"));

        assertEquals("EMP-1", result.employeeId());
        assertEquals(0.0, result.salary());
        assertTrue(result.finallyRan());
        assertFalse(result.success());
    }
}
