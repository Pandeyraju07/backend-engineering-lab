package com.lab.fundamentals.lambda;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LambdaDemoTest {

    @Test
    void predicateLambdaFiltersActiveEmployees() {
        List<Employee> roster = LambdaSyntaxDemo.sampleRoster();
        List<Employee> active = LambdaSyntaxDemo.filter(roster, employee -> employee.active());

        assertEquals(3, active.size());
        assertEquals(List.of("Asha", "Meera", "Kiran"), LambdaSyntaxDemo.namesOf(active));
    }

    @Test
    void captureUsesEffectivelyFinalThreshold() {
        List<Employee> roster = LambdaSyntaxDemo.sampleRoster();

        assertEquals(3, LambdaCaptureDemo.aboveThreshold(roster, 60_000).size());
        assertEquals(2, LambdaCaptureDemo.activeAboveThreshold(roster, 60_000).size());
        assertEquals("Asha", LambdaCaptureDemo.activeAboveThreshold(roster, 60_000).getFirst().name());
    }

    @Test
    void filterActiveIntegratesSyntaxAndCapture() {
        LambdaDemo.LambdaFilterResult result = LambdaDemo.filterActiveEmployees();

        assertEquals(4, result.totalCount());
        assertEquals(3, result.activeCount());
        assertEquals(2, result.activeAboveThresholdCount());
        assertEquals(List.of("Asha", "Meera", "Kiran"), result.activeNames());
        assertEquals(70_000 + 72_000 + 55_000, result.activePayroll());
    }
}
