package com.lab.fundamentals.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Collectors — group HRMS staff by department and join names for reports. */
public class CollectorsDemo {

    public static void main(String[] args) {
        List<Employee> roster = FilterMapDemo.sampleRoster();
        System.out.println("By dept: " + groupByDepartment(roster));
        System.out.println("Joined: " + joinActiveNames(roster));
    }

    static Map<String, List<Employee>> groupByDepartment(List<Employee> roster) {
        if (roster == null) {
            return Map.of();
        }
        return roster.stream()
                .filter(employee -> employee != null)
                .collect(Collectors.groupingBy(Employee::dept));
    }

    static Map<String, Long> countByDepartment(List<Employee> roster) {
        if (roster == null) {
            return Map.of();
        }
        return roster.stream()
                .filter(employee -> employee != null && employee.active())
                .collect(Collectors.groupingBy(Employee::dept, Collectors.counting()));
    }

    static String joinActiveNames(List<Employee> roster) {
        if (roster == null) {
            return "";
        }
        return roster.stream()
                .filter(employee -> employee != null && employee.active())
                .map(Employee::name)
                .collect(Collectors.joining(", "));
    }

    static String joinDepartmentNames(List<Employee> roster, String department) {
        if (roster == null || department == null) {
            return "";
        }
        return roster.stream()
                .filter(employee -> employee != null && department.equals(employee.dept()))
                .map(Employee::name)
                .collect(Collectors.joining(" | "));
    }
}
