package com.lab.fundamentals.accessmodifiers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessModifiersDemoTest {

    @Test
    void publicEmployeeExposesIdAndHidesSalaryBehindGetter() {
        PublicEmployee employee = PublicPrivateDemo.createPublicEmployee("EMP-3001", "Raju Kumar", 82_000);

        assertEquals("EMP-3001", employee.employeeId);
        assertEquals("Raju Kumar", employee.name);
        assertEquals(82_000, employee.getSalary());
        assertTrue(PublicPrivateDemo.describe(employee).contains("salary=82000"));
    }

    @Test
    void privateSalaryUpdatedOnlyThroughPackageMethod() {
        PublicEmployee employee = PublicPrivateDemo.createPublicEmployee("EMP-3001", "Raju", 50_000);

        assertEquals(55_000, PublicPrivateDemo.raiseSalary(employee, 5_000));
        assertEquals(55_000, employee.getSalary());
        assertEquals(55_000, PublicPrivateDemo.raiseSalary(employee, -100));
    }

    @Test
    void subclassReadsProtectedAndDefaultFields() {
        SubEmployee employee = ProtectedDefaultDemo.createSubEmployee(
                "EMP-3002", "Engineering", 70_000, "Engineer");

        assertEquals(70_000, employee.protectedBasePay());
        assertEquals("Engineering", employee.packageDepartment());
        assertEquals("EMP-3002@Engineering", employee.summary());
        assertEquals(77_000, ProtectedDefaultDemo.grantRaise(employee, 0.10), 0.001);
    }

    @Test
    void packageEmployeeIsVisibleInsidePackage() {
        PackageEmployee employee = ProtectedDefaultDemo.createPackageEmployee(
                "EMP-3003", "HR", 60_000);

        assertEquals("EMP-3003@HR", employee.summary());
        assertEquals(60_000, employee.basePay);
    }

    @Test
    void reviewAccessUsesPublicPrivateAndProtectedDefault() {
        AccessModifiersDemo.AccessResult result = AccessModifiersDemo.reviewAccess(
                "EMP-3100", "Raju Kumar", 82_000,
                "EMP-3101", "Engineering", 70_000, "Engineer", 0.10);

        assertEquals(87_000, result.publicSalaryAfterRaise());
        assertEquals(77_000, result.subBasePayAfterRaise(), 0.001);
        assertTrue(result.publicEmployeeView().contains("EMP-3100"));
        assertTrue(result.subEmployeeView().contains("title=Engineer"));
        assertEquals("EMP-3101-PKG@Engineering", result.packageEmployeeSummary());
    }
}
