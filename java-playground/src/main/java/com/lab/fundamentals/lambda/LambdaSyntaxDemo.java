package com.lab.fundamentals.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/** Lambda syntax — filter employees with a {@link Predicate} lambda. */
public class LambdaSyntaxDemo {

    public static void main(String[] args) {
        List<Employee> roster = sampleRoster();
        List<Employee> active = filter(roster, employee -> employee.active());
        System.out.println(active);
    }

    static List<Employee> sampleRoster() {
        return List.of(
                new Employee("E001", "Asha", true, 70_000),
                new Employee("E002", "Ravi", false, 65_000),
                new Employee("E003", "Meera", true, 72_000),
                new Employee("E004", "Kiran", true, 55_000)
        );
    }

    static List<Employee> filter(List<Employee> employees, Predicate<Employee> predicate) {
        List<Employee> matched = new ArrayList<>();
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                matched.add(employee);
            }
        }
        return List.copyOf(matched);
    }

    static List<String> namesOf(List<Employee> employees) {
        return employees.stream().map(Employee::name).toList();
    }
}
