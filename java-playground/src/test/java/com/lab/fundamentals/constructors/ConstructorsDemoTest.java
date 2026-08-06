package com.lab.fundamentals.constructors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorsDemoTest {

    @Test
    void defaultConstructorCreatesPlaceholderWorker() {
        Worker worker = DefaultConstructorDemo.createDefaultWorker();

        assertEquals("EMP-0000", worker.employeeId());
        assertEquals("Unassigned", worker.name());
        assertEquals(40_000, worker.salary());
        assertTrue(DefaultConstructorDemo.isPlaceholder(worker));
    }

    @Test
    void parameterizedConstructorCreatesHire() {
        Worker worker = ParameterizedConstructorDemo.create("EMP-1001", "Raju Kumar", 82_000);

        assertEquals("EMP-1001", worker.employeeId());
        assertEquals("Raju Kumar", worker.name());
        assertEquals(82_000, worker.salary());
        assertEquals("Associate", worker.role());
    }

    @Test
    void parameterizedConstructorRejectsInvalidInput() {
        assertThrows(IllegalArgumentException.class,
                () -> ParameterizedConstructorDemo.create("", "Raju", 50_000));
        assertThrows(IllegalArgumentException.class,
                () -> ParameterizedConstructorDemo.create("EMP-1", "  ", 50_000));
        assertThrows(IllegalArgumentException.class,
                () -> ParameterizedConstructorDemo.create("EMP-1", "Raju", -1));
    }

    @Test
    void constructorChainingCreatesIntern() {
        Worker intern = ConstructorChainingDemo.createIntern("Priya Nair");

        assertTrue(intern.employeeId().startsWith("INT-"));
        assertEquals("Priya Nair", intern.name());
        assertEquals("Intern", intern.role());
        assertEquals(25_000, intern.salary());
        assertTrue(ConstructorChainingDemo.isIntern(intern));
    }

    @Test
    void hireTeamUsesAllConstructorPaths() {
        ConstructorsDemo.ConstructionResult result =
                ConstructorsDemo.hireTeam("EMP-2100", "Anita Desai", 95_000, "Vikram Shah");

        assertTrue(result.placeholderDetected());
        assertTrue(result.internDetected());
        assertEquals("Anita Desai", result.hire().name());
        assertEquals(95_000, result.hire().salary());
        assertEquals("Vikram Shah", result.intern().name());
        assertEquals("Intern", result.intern().role());
    }
}
