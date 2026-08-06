package com.lab.fundamentals.methodreference;

import java.util.List;

/**
 * Static method references — {@code Type::staticMethod} on HRMS id and salary streams.
 */
public class StaticRefDemo {

    public static void main(String[] args) {
        List<String> ids = formatIds(List.of("1001", "1002", "EMP-1003"));
        List<Integer> salaries = parseSalaries(List.of("80000", "92500", "110000"));
        System.out.println("Static refs: ids=" + ids + ", salaries=" + salaries);
    }

    /** Maps raw badge numbers with {@code Employee::formatId}. */
    static List<String> formatIds(List<String> rawIds) {
        if (rawIds == null) {
            throw new IllegalArgumentException("rawIds is required");
        }
        return rawIds.stream().map(Employee::formatId).toList();
    }

    /** Maps salary strings with {@code Integer::parseInt}. */
    static List<Integer> parseSalaries(List<String> salaryTexts) {
        if (salaryTexts == null) {
            throw new IllegalArgumentException("salaryTexts is required");
        }
        return salaryTexts.stream().map(Integer::parseInt).toList();
    }
}
