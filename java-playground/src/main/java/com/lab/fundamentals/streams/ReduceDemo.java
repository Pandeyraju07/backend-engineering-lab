package com.lab.fundamentals.streams;

import java.util.List;
import java.util.OptionalDouble;

/** Stream reduce — roll up payroll totals from employee salaries. */
public class ReduceDemo {

    public static void main(String[] args) {
        List<Employee> roster = FilterMapDemo.sampleRoster();
        System.out.println("Total salary: " + totalSalary(roster));
        System.out.println("Active payroll: " + totalActiveSalary(roster));
    }

    static double totalSalary(List<Employee> roster) {
        if (roster == null) {
            return 0;
        }
        return roster.stream()
                .filter(employee -> employee != null)
                .map(Employee::salary)
                .reduce(0.0, Double::sum);
    }

    static double totalActiveSalary(List<Employee> roster) {
        if (roster == null) {
            return 0;
        }
        return roster.stream()
                .filter(employee -> employee != null && employee.active())
                .map(Employee::salary)
                .reduce(0.0, Double::sum);
    }

    static OptionalDouble maxSalary(List<Employee> roster) {
        if (roster == null) {
            return OptionalDouble.empty();
        }
        return roster.stream()
                .filter(employee -> employee != null)
                .mapToDouble(Employee::salary)
                .max();
    }

    static long activeCount(List<Employee> roster) {
        if (roster == null) {
            return 0;
        }
        return roster.stream()
                .filter(employee -> employee != null && employee.active())
                .count();
    }
}
