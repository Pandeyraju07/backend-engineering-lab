package com.lab.fundamentals.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap key-value storage — O(1) average get/put, not thread-safe.
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> employeeSalaries = new HashMap<>();

        employeeSalaries.put("E001", 75000);
        employeeSalaries.put("E002", 82000);
        employeeSalaries.put("E003", 68000);

        System.out.println("Size: " + employeeSalaries.size());
        System.out.println("E001 salary: " + employeeSalaries.get("E001"));
        System.out.println("Contains E002: " + employeeSalaries.containsKey("E002"));

        employeeSalaries.forEach((id, salary) ->
                System.out.printf("%s -> %d%n", id, salary));
    }
}
