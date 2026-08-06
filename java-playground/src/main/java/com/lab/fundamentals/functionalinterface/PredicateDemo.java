package com.lab.fundamentals.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/** Predicate — filter active staff and high earners on the HRMS roster. */
public class PredicateDemo {

    static final double HIGH_EARNER_THRESHOLD = 80_000;

    public static void main(String[] args) {
        List<Employee> roster = sampleRoster();
        System.out.println("Active: " + filter(roster, isActive()));
        System.out.println("High earners: " + filter(roster, isHighEarner(HIGH_EARNER_THRESHOLD)));
    }

    static Predicate<Employee> isActive() {
        return employee -> employee != null && employee.active();
    }

    static Predicate<Employee> isHighEarner(double threshold) {
        return employee -> employee != null && employee.salary() >= threshold;
    }

    static Predicate<Employee> isActiveHighEarner(double threshold) {
        return isActive().and(isHighEarner(threshold));
    }

    static List<Employee> filter(List<Employee> roster, Predicate<Employee> predicate) {
        List<Employee> matched = new ArrayList<>();
        if (roster == null || predicate == null) {
            return matched;
        }
        for (Employee employee : roster) {
            if (predicate.test(employee)) {
                matched.add(employee);
            }
        }
        return matched;
    }

    static List<Employee> sampleRoster() {
        return List.of(
                new Employee("E001", "Asha", "Engineering", "asha@hrms.lab", 95_000, true),
                new Employee("E002", "Ravi", "People Ops", "ravi@hrms.lab", 72_000, true),
                new Employee("E003", "Meera", "Finance", "meera@hrms.lab", 88_000, false),
                new Employee("E004", "Kiran", "Engineering", "kiran@hrms.lab", 81_000, true)
        );
    }
}
