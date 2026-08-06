package com.lab.fundamentals.encapsulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncapsulationDemoTest {

    @Test
    void gettersAndSettersUpdateSalarySafely() {
        BankSalaryAccount account = GetterSetterDemo.openAccount("ACC-1001", "Raju Kumar", 80_000);

        assertEquals("ACC-1001", account.getAccountId());
        assertEquals("Raju Kumar", account.getEmployeeName());
        assertEquals(80_000, account.getSalary());
        assertEquals(85_000, GetterSetterDemo.applyRaise(account, 5_000));
        assertEquals("Raju Kumar=85000.0", GetterSetterDemo.displayNameAndSalary(account));
    }

    @Test
    void validationRejectsNegativeSalaryAndBlankName() {
        assertTrue(ValidationDemo.rejectsNegativeSalary());
        assertTrue(ValidationDemo.rejectsBlankName());

        assertThrows(IllegalArgumentException.class,
                () -> new BankSalaryAccount("ACC-1", "Valid", -10));
        assertThrows(IllegalArgumentException.class,
                () -> new BankSalaryAccount("ACC-1", "", 50_000));
        assertThrows(IllegalArgumentException.class,
                () -> new BankSalaryAccount("  ", "Valid", 50_000));
    }

    @Test
    void validationBlocksInvalidUpdatesOnExistingAccount() {
        BankSalaryAccount account = GetterSetterDemo.openAccount("ACC-1002", "Anita", 60_000);

        assertFalse(ValidationDemo.trySetSalary(account, -1));
        assertEquals(60_000, account.getSalary());
        assertFalse(ValidationDemo.trySetEmployeeName(account, " "));
        assertEquals("Anita", account.getEmployeeName());

        ValidationDemo.assertValidUpdate(account, "Anita Desai", 65_000);
        assertEquals("Anita Desai", account.getEmployeeName());
        assertEquals(65_000, account.getSalary());
    }

    @Test
    void onboardSalaryAccountUsesGettersSettersAndValidation() {
        EncapsulationDemo.EncapsulatedEmployeeResult result =
                EncapsulationDemo.onboardSalaryAccount("ACC-2001", "Priya Nair", 75_000, 8_000);

        assertEquals("ACC-2001", result.accountId());
        assertEquals("Priya Nair", result.employeeName());
        assertEquals(83_000, result.salary());
        assertTrue(result.active());
        assertTrue(result.validationEnforced());
        assertEquals("Priya Nair=83000.0", result.display());
    }
}
