package com.lab.fundamentals.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** HashMap iteration — keySet, values, forEach over salary ledger. */
public class HashMapIterateDemo {

    public static void main(String[] args) {
        Map<String, Double> salaries = HashMapCrudDemo.seedSalaries();
        System.out.println("Keys: " + employeeIds(salaries));
        System.out.println("Sum: " + sumSalaries(salaries));
        System.out.println(formatEntries(salaries));
    }

    static Set<String> employeeIds(Map<String, Double> salaries) {
        return salaries.keySet();
    }

    static List<Double> salaryValues(Map<String, Double> salaries) {
        return new ArrayList<>(salaries.values());
    }

    static double sumSalaries(Map<String, Double> salaries) {
        double total = 0;
        for (double salary : salaries.values()) {
            total += salary;
        }
        return total;
    }

    static List<String> formatEntries(Map<String, Double> salaries) {
        List<String> lines = new ArrayList<>();
        salaries.forEach((id, salary) -> lines.add(id + "=" + salary));
        return lines;
    }

    static Map<String, Double> copyOf(Map<String, Double> salaries) {
        return new HashMap<>(salaries);
    }
}
