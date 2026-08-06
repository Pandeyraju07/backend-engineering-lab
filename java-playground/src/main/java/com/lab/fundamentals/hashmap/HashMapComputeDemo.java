package com.lab.fundamentals.hashmap;

import java.util.HashMap;
import java.util.Map;

/** HashMap computeIfAbsent / merge — default salary and raise accumulation. */
public class HashMapComputeDemo {

    public static final double DEFAULT_SALARY = 50_000.0;

    public static void main(String[] args) {
        Map<String, Double> salaries = new HashMap<>();
        ensureDefault(salaries, "E100");
        applyRaise(salaries, "E100", 5_000);
        System.out.println("E100 after raise: " + salaries.get("E100"));
    }

    static double ensureDefault(Map<String, Double> salaries, String employeeId) {
        return salaries.computeIfAbsent(employeeId, id -> DEFAULT_SALARY);
    }

    static double applyRaise(Map<String, Double> salaries, String employeeId, double raiseAmount) {
        salaries.merge(employeeId, raiseAmount, Double::sum);
        return salaries.get(employeeId);
    }

    static int bumpAttendance(Map<String, Integer> attendance, String employeeId) {
        attendance.merge(employeeId, 1, Integer::sum);
        return attendance.get(employeeId);
    }
}
