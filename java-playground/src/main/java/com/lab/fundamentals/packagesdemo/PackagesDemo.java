package com.lab.fundamentals.packagesdemo;

import com.lab.fundamentals.packagesdemo.model.EmployeeDto;
import com.lab.fundamentals.packagesdemo.service.EmployeeService;

/**
 * HRMS packages lesson — model/service imports and FQCN same-name types in one flow.
 */
public class PackagesDemo {

    public static void main(String[] args) {
        PackageFlowResult result = runPackageFlow(
                "EMP-401", "Asha Verma", "Engineering", 90_000, "2026-04-01");
        System.out.println(result);
    }

    static PackageFlowResult runPackageFlow(
            String employeeId,
            String name,
            String department,
            double salary,
            String isoHireDate
    ) {
        String description = PackageImportDemo.createAndDescribe(
                employeeId, name, department, salary);
        EmployeeDto employee = new EmployeeService()
                .create(employeeId, name, department, salary);
        String hireStamp = SameNameTypeDemo.hireStamp(employeeId, isoHireDate);
        boolean fqcnDateUsed = SameNameTypeDemo.usesFullyQualifiedDate(hireStamp);

        return new PackageFlowResult(
                employee.employeeId(),
                employee.name(),
                employee.department(),
                employee.salary(),
                description,
                hireStamp,
                fqcnDateUsed
        );
    }

    record PackageFlowResult(
            String employeeId,
            String name,
            String department,
            double salary,
            String description,
            String hireStamp,
            boolean fullyQualifiedDateUsed
    ) {
        @Override
        public String toString() {
            return "PackageFlowResult{id=%s, name=%s, dept=%s, salary=%.2f, desc=%s, fqcnDate=%b}"
                    .formatted(employeeId, name, department, salary, description,
                            fullyQualifiedDateUsed);
        }
    }
}
