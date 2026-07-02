package com.lab.fundamentals.methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodsDemoTest {

    @Test
    void staticMethodGeneratesEmployeeId() {
        String id1 = StaticMethodDemo.generateEmployeeId();
        String id2 = StaticMethodDemo.generateEmployeeId();
        assertTrue(id1.startsWith("EMP-"));
        assertNotEquals(id1, id2);
    }

    @Test
    void overloadingCalculatesDifferentBonuses() {
        double byRating = MethodOverloadingDemo.calculateBonus(80_000, 'A');
        double byDept = MethodOverloadingDemo.calculateBonus(80_000, "Engineering", 'A');
        assertTrue(byDept > byRating);
    }

    @Test
    void varargsDistributesBonusToMultipleEmployees() {
        assertEquals(6_000, VarargsMethodDemo.distributeBonus(2_000, "E1", "E2", "E3"));
    }

    @Test
    void passByValueDoesNotReassignReference() {
        Employee employee = new Employee("EMP-1", "Test", "IT", 50_000);
        PassByValueDemo.tryReassignEmployee(employee);
        assertEquals("EMP-1", employee.employeeId());
    }

    @Test
    void passByValueMutatesObjectState() {
        Employee employee = new Employee("EMP-2", "Test", "IT", 50_000);
        PassByValueDemo.applyPromotion(employee, 5_000);
        assertEquals(55_000, employee.salary());
    }

    @Test
    void onboardingUsesAllMethodTypes() {
        MethodsDemo.OnboardingResult result = MethodsDemo.onboardEmployee(
                "Raju Kumar", "Backend Engineering", 82_000, 'A', "EMAIL", "SMS");

        assertTrue(result.employee().active());
        assertTrue(result.joiningBonus() > 0);
        assertEquals(2, result.notifications().size());
    }
}
