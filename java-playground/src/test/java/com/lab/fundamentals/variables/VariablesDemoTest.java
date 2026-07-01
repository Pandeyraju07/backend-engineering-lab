package com.lab.fundamentals.variables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariablesDemoTest {

    @Test
    void employeePromotionIncreasesSalary() {
        VariablesDemo.Employee employee =
                new VariablesDemo.Employee("EMP-TEST", "Raju", 28, 80_000);

        employee.promote(5_000);

        assertTrue(employee.toString().contains("85000.00"));
    }

    @Test
    void employeeRejectsInvalidSalary() {
        assertThrows(IllegalArgumentException.class,
                () -> new VariablesDemo.Employee("EMP-X", "Test", 25, 5_000));
    }

    @Test
    void employeeRejectsBlankId() {
        assertThrows(IllegalArgumentException.class,
                () -> new VariablesDemo.Employee("  ", "Test", 25, 50_000));
    }
}
