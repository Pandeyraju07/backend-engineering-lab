package com.lab.fundamentals.wildcards;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WildcardsDemoTest {

    @Test
    void upperBoundAveragesAnyNumberList() {
        assertEquals(69_000.0, UpperBoundDemo.average(List.of(70_000, 65_000, 72_000)));
        assertEquals(67_500.25, UpperBoundDemo.average(List.of(70_000.0, 65_000.5)), 0.001);
        assertThrows(IllegalArgumentException.class, () -> UpperBoundDemo.average(List.of()));
    }

    @Test
    void lowerBoundAcceptsIntegersIntoNumberList() {
        List<Number> grades = new ArrayList<>();
        LowerBoundDemo.addNumbers(grades, 1, 2, 3);

        assertEquals(3, LowerBoundDemo.countEntries(grades));
        assertEquals(List.of(1, 2, 3), grades);
    }

    @Test
    void unboundedReportsSizeAndPrintsAnyList() {
        List<Department> departments = List.of(
                new Department("ENG", "Engineering", 12),
                new Department("HR", "People Ops", 4)
        );

        assertEquals(2, UnboundedDemo.sizeOf(departments));
        assertEquals(2, UnboundedDemo.printAll(departments).size());
        assertTrue(UnboundedDemo.printAll(departments).getFirst().contains("ENG"));
    }

    @Test
    void pecsDeptListIntegratesUpperLowerAndUnbounded() {
        WildcardsDemo.WildcardResult result = WildcardsDemo.runPecsDeptList();

        assertEquals(3, result.departmentCount());
        assertEquals((12 + 4 + 6) / 3.0, result.averageHeadcount());
        assertEquals(3, result.gradesStored());
        assertEquals(3, result.printedLines());
    }
}
