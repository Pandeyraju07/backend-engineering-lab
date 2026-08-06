package com.lab.fundamentals.methodreference;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodReferenceDemoTest {

    @Test
    void staticRefsFormatIdsAndParseSalaries() {
        assertEquals(List.of("EMP-1001", "EMP-1002", "EMP-1003"),
                StaticRefDemo.formatIds(List.of("1001", "1002", "EMP-1003")));
        assertEquals(List.of(80_000, 92_500),
                StaticRefDemo.parseSalaries(List.of("80000", "92500")));
    }

    @Test
    void instanceRefsMapNamesDepartmentsAndBoundPrefix() {
        List<Employee> roster = List.of(
                new Employee("EMP-1001", "Raju Kumar", "Engineering", 82_000),
                new Employee("EMP-1002", "Anita Desai", "HR", 95_000)
        );

        assertEquals(List.of("Raju Kumar", "Anita Desai"), InstanceRefDemo.mapDisplayNames(roster));
        assertEquals(List.of("ENGINEERING", "HR"), InstanceRefDemo.mapDepartmentLabels(roster));
        assertEquals(List.of("Badge:1001", "Badge:1002"),
                InstanceRefDemo.prefixIds(List.of("1001", "1002"), "Badge:"));
    }

    @Test
    void constructorRefCreatesPlaceholderEmployees() {
        List<Employee> hires = ConstructorRefDemo.createFromIds(List.of("EMP-2100", "EMP-2101"));

        assertEquals(2, hires.size());
        assertEquals("EMP-2100", hires.getFirst().employeeId());
        assertTrue(hires.getFirst().isPlaceholder());
        assertTrue(ConstructorRefDemo.allPlaceholders(hires));
    }

    @Test
    void importHiresIntegratesAllMethodReferenceDemos() {
        MethodReferenceDemo.MethodRefResult result = MethodReferenceDemo.importHires(
                List.of("1001", "1002"),
                List.of("80000", "92500")
        );

        assertEquals(List.of("EMP-1001", "EMP-1002"), result.formattedIds());
        assertEquals(List.of(80_000, 92_500), result.salaries());
        assertEquals(2, result.employees().size());
        assertEquals(List.of("Pending Hire", "Pending Hire"), result.displayNames());
        assertEquals(List.of("UNASSIGNED", "UNASSIGNED"), result.departmentLabels());
        assertEquals(List.of("Badge:1001", "Badge:1002"), result.badgeLabels());
        assertTrue(result.allPlaceholders());
    }
}
