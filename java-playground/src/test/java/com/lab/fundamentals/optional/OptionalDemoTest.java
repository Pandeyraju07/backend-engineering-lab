package com.lab.fundamentals.optional;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalDemoTest {

    @Test
    void createBuildsOfOfNullableEmptyAndFindById() {
        Employee asha = new Employee("E001", "Asha", "Engineering", "asha@hrms.lab", 95_000);
        List<Employee> directory = OptionalCreateDemo.sampleDirectory();

        assertTrue(OptionalCreateDemo.ofEmployee(asha).isPresent());
        assertTrue(OptionalCreateDemo.ofNullableEmployee(null).isEmpty());
        assertTrue(OptionalCreateDemo.emptyEmployee().isEmpty());

        Optional<Employee> found = OptionalCreateDemo.findById(directory, "E002");
        assertTrue(found.isPresent());
        assertEquals("Ravi", found.get().name());
        assertTrue(OptionalCreateDemo.findById(directory, "E999").isEmpty());
        assertTrue(OptionalCreateDemo.findById(directory, null).isEmpty());
    }

    @Test
    void chainMapsFlatMapsOrElseAndOrElseThrow() {
        Optional<Employee> found = OptionalCreateDemo.findById(
                OptionalCreateDemo.sampleDirectory(), "E001");
        Optional<Employee> missing = OptionalCreateDemo.findById(
                OptionalCreateDemo.sampleDirectory(), "E999");

        assertEquals("asha@hrms.lab", OptionalChainDemo.emailOrDefault(found, "noreply@hrms.lab"));
        assertEquals("noreply@hrms.lab", OptionalChainDemo.emailOrDefault(missing, "noreply@hrms.lab"));
        assertEquals("Engineering", OptionalChainDemo.departmentOrThrow(found));
        assertThrows(IllegalStateException.class, () -> OptionalChainDemo.departmentOrThrow(missing));
        assertEquals("asha@hrms.lab", OptionalChainDemo.emailOptional(found).orElseThrow());
        assertEquals("asha@hrms.lab", OptionalChainDemo.normalizedEmail(found).orElseThrow());
        assertEquals("Unknown", OptionalChainDemo.displayName(missing));
        assertEquals(0.0, OptionalChainDemo.salaryOrZero(missing));
    }

    @Test
    void employeeLookupIntegratesCreateAndChain() {
        OptionalDemo.OptionalLookupResult result = OptionalDemo.runEmployeeLookup(
                OptionalCreateDemo.sampleDirectory(), "E001", "E999");

        assertTrue(result.foundPresent());
        assertTrue(result.missingAbsent());
        assertTrue(result.nullableWasEmpty());
        assertEquals("asha@hrms.lab", result.resolvedEmail());
        assertEquals("noreply@hrms.lab", result.fallbackEmail());
        assertEquals("Engineering", result.department());
        assertEquals("Asha", result.displayName());
        assertEquals("asha@hrms.lab", result.normalizedEmail());
        assertEquals(95_000.0, result.salary());
    }
}
