package com.lab.fundamentals.packagesdemo.service;

import com.lab.fundamentals.packagesdemo.model.EmployeeDto;

/**
 * HRMS service that builds and describes employees from the model package.
 */
public class EmployeeService {

    public EmployeeDto create(String employeeId, String name, String department, double salary) {
        if (employeeId == null || employeeId.isBlank()) {
            throw new IllegalArgumentException("employeeId is required");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        return new EmployeeDto(employeeId.trim(), name.trim(),
                department == null ? "" : department.trim(), salary);
    }

    public String describe(EmployeeDto employee) {
        return "%s (%s) in %s @ %.2f"
                .formatted(employee.name(), employee.employeeId(),
                        employee.department(), employee.salary());
    }
}
