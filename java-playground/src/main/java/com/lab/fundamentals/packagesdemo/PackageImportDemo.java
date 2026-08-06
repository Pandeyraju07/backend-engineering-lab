package com.lab.fundamentals.packagesdemo;

import com.lab.fundamentals.packagesdemo.model.EmployeeDto;
import com.lab.fundamentals.packagesdemo.service.EmployeeService;

/**
 * Import demo — brings model and service types into the packagesdemo root package.
 */
public class PackageImportDemo {

    public static void main(String[] args) {
        System.out.println(createAndDescribe("EMP-401", "Asha Verma", "Engineering", 90_000));
    }

    static String createAndDescribe(String employeeId, String name, String department, double salary) {
        EmployeeService service = new EmployeeService();
        EmployeeDto employee = service.create(employeeId, name, department, salary);
        return service.describe(employee);
    }

    static EmployeeDto sampleEmployee() {
        return new EmployeeService().create("EMP-401", "Asha Verma", "Engineering", 90_000);
    }
}
