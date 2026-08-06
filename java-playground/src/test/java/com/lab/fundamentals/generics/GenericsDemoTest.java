package com.lab.fundamentals.generics;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GenericsDemoTest {

    @Test
    void genericRepositorySavesAndFindsEmployees() {
        Repository<Employee> repo = GenericClassDemo.employeeRepository(
                new Employee("E001", "Asha", 70_000),
                new Employee("E002", "Ravi", 65_000)
        );

        assertEquals(2, repo.size());
        assertEquals("Asha", GenericClassDemo.findById(repo, "E001").orElseThrow().name());
        assertEquals("Ravi", GenericClassDemo.findByName(repo, "Ravi").orElseThrow().name());
        assertEquals(Optional.empty(), GenericClassDemo.findById(repo, "E999"));
    }

    @Test
    void genericMethodsReturnIdentityAndFirstNonNull() {
        Employee employee = new Employee("E010", "Meera", 72_000);

        assertSame(employee, GenericMethodDemo.identity(employee));
        assertEquals("Engineering", GenericMethodDemo.firstNonNull(null, "Engineering", "Finance"));
        assertNull(GenericMethodDemo.firstNonNull(null, null));
    }

    @Test
    void boundedTypesSumAndMaxSalaries() {
        assertEquals(207_000.0, BoundedTypeDemo.sum(List.of(70_000, 65_000, 72_000)));
        assertEquals(72_000.0, BoundedTypeDemo.maxSalary(List.of(70_000.0, 65_000.5, 72_000.0)));
        assertThrows(IllegalArgumentException.class, () -> BoundedTypeDemo.maxSalary(List.of()));
    }

    @Test
    void employeeRepoIntegratesClassMethodAndBounds() {
        GenericsDemo.GenericRepoResult result = GenericsDemo.runEmployeeRepo();

        assertEquals(3, result.storedCount());
        assertEquals("Asha", result.foundName());
        assertEquals("Engineering", result.department());
        assertEquals(207_000.0, result.payrollTotal());
        assertEquals(72_000.0, result.maxSalary());
    }
}
