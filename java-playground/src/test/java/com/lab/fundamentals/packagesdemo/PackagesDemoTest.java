package com.lab.fundamentals.packagesdemo;

import com.lab.fundamentals.packagesdemo.model.EmployeeDto;
import com.lab.fundamentals.packagesdemo.service.EmployeeService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackagesDemoTest {

    @Test
    void modelAndServiceCreateAndDescribeEmployee() {
        EmployeeService service = new EmployeeService();
        EmployeeDto employee = service.create("EMP-401", "Asha Verma", "Engineering", 90_000);

        assertEquals("EMP-401", employee.employeeId());
        assertEquals("Asha Verma", employee.name());
        assertEquals("Engineering", employee.department());
        assertEquals(90_000, employee.salary());
        assertEquals("Asha Verma (EMP-401) in Engineering @ 90000.00",
                service.describe(employee));
    }

    @Test
    void packageImportDemoWiresModelAndService() {
        String description = PackageImportDemo.createAndDescribe(
                "EMP-401", "Asha Verma", "Engineering", 90_000);

        assertEquals("Asha Verma (EMP-401) in Engineering @ 90000.00", description);
        assertEquals("EMP-401", PackageImportDemo.sampleEmployee().employeeId());
    }

    @Test
    void sameNameTypeDemoUsesFullyQualifiedDate() {
        String stamp = SameNameTypeDemo.hireStamp("EMP-402", "2026-04-01");

        assertTrue(stamp.contains("EMP-402"));
        assertTrue(stamp.contains("2026-04-01"));
        assertTrue(SameNameTypeDemo.usesFullyQualifiedDate(stamp));
    }

    @Test
    void runPackageFlowIntegratesImportAndFqcnDemos() {
        PackagesDemo.PackageFlowResult result = PackagesDemo.runPackageFlow(
                "EMP-401", "Asha Verma", "Engineering", 90_000, "2026-04-01");

        assertEquals("EMP-401", result.employeeId());
        assertEquals("Asha Verma", result.name());
        assertEquals("Engineering", result.department());
        assertEquals(90_000, result.salary());
        assertTrue(result.description().contains("EMP-401"));
        assertTrue(result.hireStamp().contains("2026-04-01"));
        assertTrue(result.fullyQualifiedDateUsed());
    }
}
