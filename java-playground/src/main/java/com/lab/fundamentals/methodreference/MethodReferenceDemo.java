package com.lab.fundamentals.methodreference;

import java.util.List;

/**
 * HRMS hire import — static, instance, and constructor method references in one stream flow.
 */
public class MethodReferenceDemo {

    public static void main(String[] args) {
        MethodRefResult result = importHires(
                List.of("1001", "1002", "1003"),
                List.of("80000", "92500", "110000")
        );
        System.out.println(result);
    }

    /**
     * Formats raw ids, builds employees via constructor refs, then maps display labels.
     */
    static MethodRefResult importHires(List<String> rawIds, List<String> salaryTexts) {
        List<String> formattedIds = StaticRefDemo.formatIds(rawIds);
        List<Integer> salaries = StaticRefDemo.parseSalaries(salaryTexts);
        List<Employee> placeholders = ConstructorRefDemo.createFromIds(formattedIds);
        List<String> displayNames = InstanceRefDemo.mapDisplayNames(placeholders);
        List<String> departmentLabels = InstanceRefDemo.mapDepartmentLabels(placeholders);
        List<String> badgeLabels = InstanceRefDemo.prefixIds(rawIds, "Badge:");

        return new MethodRefResult(
                formattedIds,
                salaries,
                placeholders,
                displayNames,
                departmentLabels,
                badgeLabels,
                ConstructorRefDemo.allPlaceholders(placeholders)
        );
    }

    record MethodRefResult(
            List<String> formattedIds,
            List<Integer> salaries,
            List<Employee> employees,
            List<String> displayNames,
            List<String> departmentLabels,
            List<String> badgeLabels,
            boolean allPlaceholders
    ) {
        @Override
        public String toString() {
            return "MethodRefResult{ids=%s, salaries=%s, employees=%d, placeholders=%b}"
                    .formatted(formattedIds, salaries, employees.size(), allPlaceholders);
        }
    }
}
