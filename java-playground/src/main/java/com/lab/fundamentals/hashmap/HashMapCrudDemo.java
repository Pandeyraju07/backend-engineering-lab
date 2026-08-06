package com.lab.fundamentals.hashmap;

import java.util.HashMap;
import java.util.Map;

/** HashMap put/get/remove — employeeId → salary ledger. */
public class HashMapCrudDemo {

    public static void main(String[] args) {
        Map<String, Double> salaries = seedSalaries();
        System.out.println("E001: " + lookupSalary(salaries, "E001"));
        System.out.println("After remove E003 size=" + removeEmployee(salaries, "E003"));
    }

    static Map<String, Double> seedSalaries() {
        Map<String, Double> salaries = new HashMap<>();
        salaries.put("E001", 75_000.0);
        salaries.put("E002", 82_000.0);
        salaries.put("E003", 68_000.0);
        return salaries;
    }

    static void putSalary(Map<String, Double> salaries, String employeeId, double salary) {
        salaries.put(employeeId, salary);
    }

    static Double lookupSalary(Map<String, Double> salaries, String employeeId) {
        return salaries.get(employeeId);
    }

    static boolean containsEmployee(Map<String, Double> salaries, String employeeId) {
        return salaries.containsKey(employeeId);
    }

    static int removeEmployee(Map<String, Double> salaries, String employeeId) {
        salaries.remove(employeeId);
        return salaries.size();
    }
}
