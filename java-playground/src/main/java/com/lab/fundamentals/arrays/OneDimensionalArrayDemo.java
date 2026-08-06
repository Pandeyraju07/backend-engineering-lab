package com.lab.fundamentals.arrays;

import java.util.Arrays;

/** 1D arrays — salary ledger and leave balances (common HRMS aggregates). */
public class OneDimensionalArrayDemo {

    public static void main(String[] args) {
        EmployeeSnapshot[] employees = buildSampleEmployees(5);
        double[] salaries = extractSalaries(employees);

        System.out.println("1D array salaries: " + Arrays.toString(salaries));
        System.out.printf("Average salary: %.2f%n", averageSalary(salaries));
        System.out.printf("After 5%% raise: %s%n", Arrays.toString(applyRaise(salaries, 0.05)));
    }

    static EmployeeSnapshot[] buildSampleEmployees(int count) {
        EmployeeSnapshot[] employees = new EmployeeSnapshot[count];
        for (int i = 0; i < count; i++) {
            employees[i] = new EmployeeSnapshot(
                    "EMP-" + (i + 1),
                    "Employee-" + (i + 1),
                    60_000 + (i * 5_000)
            );
        }
        return employees;
    }

    static double[] extractSalaries(EmployeeSnapshot[] employees) {
        double[] salaries = new double[employees.length];
        for (int i = 0; i < employees.length; i++) {
            salaries[i] = employees[i].salary();
        }
        return salaries;
    }

    static double averageSalary(double[] salaries) {
        if (salaries.length == 0) {
            return 0;
        }
        double total = 0;
        for (double salary : salaries) {
            total += salary;
        }
        return total / salaries.length;
    }

    static double[] applyRaise(double[] salaries, double raisePercent) {
        double[] revised = new double[salaries.length];
        for (int i = 0; i < salaries.length; i++) {
            revised[i] = salaries[i] * (1 + raisePercent);
        }
        return revised;
    }
}
