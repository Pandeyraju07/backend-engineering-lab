package com.lab.fundamentals.customexception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomExceptionDemoTest {

    @Test
    void validateEmployeeIdAcceptsEmpPatternAndThrowsChecked() {
        assertDoesNotThrow(() ->
                assertEquals("EMP-1001", CheckedCustomDemo.validateEmployeeId("EMP-1001")));

        assertThrows(InvalidEmployeeException.class,
                () -> CheckedCustomDemo.validateEmployeeId("bad"));
        assertThrows(InvalidEmployeeException.class,
                () -> CheckedCustomDemo.validateEmployeeId("  "));
        assertThrows(InvalidEmployeeException.class,
                () -> CheckedCustomDemo.validateEmployeeId(null));
    }

    @Test
    void requireNetPayAcceptsZeroAndThrowsUncheckedOnNegative() {
        assertEquals(0.0, UncheckedCustomDemo.requireNetPay(0));
        assertEquals(42_500, UncheckedCustomDemo.requireNetPay(42_500));
        assertThrows(PayrollRuntimeException.class,
                () -> UncheckedCustomDemo.requireNetPay(-0.01));
    }

    @Test
    void customExceptionsAreCorrectCheckedVsUnchecked() {
        assertTrue(Exception.class.isAssignableFrom(InvalidEmployeeException.class));
        assertFalse(RuntimeException.class.isAssignableFrom(InvalidEmployeeException.class));
        assertTrue(RuntimeException.class.isAssignableFrom(PayrollRuntimeException.class));
    }

    @Test
    void customExceptionFlowIntegratesCheckedAndUnchecked() {
        CustomExceptionDemo.CustomExceptionFlowResult result =
                CustomExceptionDemo.runCustomExceptionFlow("EMP-2201", 68_000);

        assertEquals("EMP-2201", result.employeeId());
        assertEquals(68_000, result.netPay());
        assertTrue(result.idValid());
        assertTrue(result.netPayOk());
        assertTrue(result.badIdRejected());
        assertTrue(result.negativeNetRejected());
        assertTrue(result.flowOk());
        assertTrue(result.summary().startsWith("OK|EMP-2201|"));
    }

    @Test
    void customExceptionFlowFailsOnBadId() {
        CustomExceptionDemo.CustomExceptionFlowResult result =
                CustomExceptionDemo.runCustomExceptionFlow("X-1", 10_000);

        assertFalse(result.idValid());
        assertTrue(result.netPayOk());
        assertFalse(result.flowOk());
        assertTrue(result.summary().startsWith("FAIL|"));
    }
}
