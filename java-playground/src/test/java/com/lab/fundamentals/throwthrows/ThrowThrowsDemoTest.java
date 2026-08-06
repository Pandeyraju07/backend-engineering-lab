package com.lab.fundamentals.throwthrows;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThrowThrowsDemoTest {

    @Test
    void requirePositiveSalaryAcceptsValidAndThrowsOnInvalid() {
        assertEquals(50_000, ThrowDemo.requirePositiveSalary(50_000));
        assertThrows(IllegalArgumentException.class, () -> ThrowDemo.requirePositiveSalary(0));
        assertThrows(IllegalArgumentException.class, () -> ThrowDemo.requirePositiveSalary(-100));
    }

    @Test
    void loadPolicyThrowsCheckedExceptionWhenBlank() {
        assertDoesNotThrow(() -> assertEquals("PROBATION", ThrowsDemo.loadPolicy("PROBATION")));
        Exception blank = assertThrows(Exception.class, () -> ThrowsDemo.loadPolicy("  "));
        assertTrue(blank.getMessage().contains("required"));
        assertThrows(Exception.class, () -> ThrowsDemo.loadPolicy(null));
    }

    @Test
    void processHireCatchesAndReturnsStatus() {
        String ok = PropagateDemo.processHire("Raju Kumar", 82_000);
        assertTrue(ok.startsWith("HIRED|Raju Kumar|"));
        assertTrue(ok.contains("STANDARD_HIRE"));

        assertEquals("REJECTED|blank name", PropagateDemo.processHire("  ", 50_000));
        assertTrue(PropagateDemo.processHire("Anita", -5).startsWith("REJECTED|"));
    }

    @Test
    void validationFlowIntegratesThrowThrowsAndPropagate() {
        ThrowThrowsDemo.ValidationFlowResult result =
                ThrowThrowsDemo.runValidationFlow("Priya Nair", 75_000);

        assertEquals("Priya Nair", result.name());
        assertEquals(75_000, result.salary());
        assertTrue(result.salaryOk());
        assertTrue(result.policyOk());
        assertEquals("STANDARD_HIRE", result.policy());
        assertTrue(result.blankPolicyRejected());
        assertTrue(result.hired());
        assertTrue(result.hireStatus().startsWith("HIRED|"));
    }

    @Test
    void validationFlowRejectsNonPositiveSalary() {
        ThrowThrowsDemo.ValidationFlowResult result =
                ThrowThrowsDemo.runValidationFlow("Temp", -1);

        assertFalse(result.salaryOk());
        assertFalse(result.hired());
        assertTrue(result.hireStatus().startsWith("REJECTED|"));
        assertTrue(result.blankPolicyRejected());
    }
}
