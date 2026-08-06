package com.lab.fundamentals.linkedhashset;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** LinkedHashSet insertion order — keeps first-seen department sequence. */
public class InsertionOrderDemo {

    public static void main(String[] args) {
        List<String> ordered = orderedDepartments(
                "Engineering", "People Ops", "Engineering", "Finance", "People Ops"
        );
        System.out.println("Ordered unique departments: " + ordered);
    }

    static List<String> orderedDepartments(String... departments) {
        Set<String> ordered = new LinkedHashSet<>();
        if (departments != null) {
            for (String department : departments) {
                if (department != null && !department.isBlank()) {
                    ordered.add(department.trim());
                }
            }
        }
        return new ArrayList<>(ordered);
    }

    static Set<String> asLinkedSet(String... departments) {
        Set<String> ordered = new LinkedHashSet<>();
        if (departments != null) {
            for (String department : departments) {
                if (department != null && !department.isBlank()) {
                    ordered.add(department.trim());
                }
            }
        }
        return ordered;
    }

    static List<Department> asDepartmentList(String... departments) {
        List<Department> list = new ArrayList<>();
        for (String name : orderedDepartments(departments)) {
            list.add(new Department(name));
        }
        return list;
    }
}
