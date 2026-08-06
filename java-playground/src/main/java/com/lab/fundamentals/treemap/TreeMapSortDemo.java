package com.lab.fundamentals.treemap;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

/** TreeMap sorted keys — employeeId lexicographic salary ledger. */
public class TreeMapSortDemo {

    public static void main(String[] args) {
        NavigableMap<String, Double> salaries = seedSortedSalaries();
        System.out.println(sortedEmployeeIds(salaries));
        System.out.println("first=" + firstEmployee(salaries) + ", last=" + lastEmployee(salaries));
    }

    static NavigableMap<String, Double> seedSortedSalaries() {
        NavigableMap<String, Double> salaries = new TreeMap<>();
        salaries.put("E030", 95_000.0);
        salaries.put("E010", 70_000.0);
        salaries.put("E020", 85_000.0);
        salaries.put("E015", 78_000.0);
        return salaries;
    }

    static List<String> sortedEmployeeIds(NavigableMap<String, Double> salaries) {
        return new ArrayList<>(salaries.keySet());
    }

    static String firstEmployee(NavigableMap<String, Double> salaries) {
        return salaries.firstKey();
    }

    static String lastEmployee(NavigableMap<String, Double> salaries) {
        return salaries.lastKey();
    }

    static NavigableMap<Double, String> salaryToEmployee(NavigableMap<String, Double> salaries) {
        NavigableMap<Double, String> bySalary = new TreeMap<>();
        salaries.forEach((id, salary) -> bySalary.put(salary, id));
        return bySalary;
    }
}
