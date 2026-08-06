package com.lab.fundamentals.treeset;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/** TreeSet natural order — sorted unique employee IDs. */
public class NaturalOrderDemo {

    public static void main(String[] args) {
        List<String> sorted = sortedEmployeeIds("EMP-3", "EMP-1", "EMP-2", "EMP-1");
        System.out.println("Natural sorted ids: " + sorted);
    }

    static List<String> sortedEmployeeIds(String... ids) {
        TreeSet<String> sorted = new TreeSet<>();
        if (ids != null) {
            for (String id : ids) {
                if (id != null && !id.isBlank()) {
                    sorted.add(id.trim());
                }
            }
        }
        return new ArrayList<>(sorted);
    }

    static TreeSet<String> asNaturalSet(String... ids) {
        TreeSet<String> sorted = new TreeSet<>();
        if (ids != null) {
            for (String id : ids) {
                if (id != null && !id.isBlank()) {
                    sorted.add(id.trim());
                }
            }
        }
        return sorted;
    }

    static String first(TreeSet<String> ids) {
        return ids == null || ids.isEmpty() ? null : ids.first();
    }

    static String last(TreeSet<String> ids) {
        return ids == null || ids.isEmpty() ? null : ids.last();
    }

    static List<EmployeeId> asEmployeeIds(String... ids) {
        List<EmployeeId> list = new ArrayList<>();
        for (String id : sortedEmployeeIds(ids)) {
            list.add(new EmployeeId(id));
        }
        return list;
    }
}
