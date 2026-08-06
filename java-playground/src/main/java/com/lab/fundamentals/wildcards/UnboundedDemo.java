package com.lab.fundamentals.wildcards;

import java.util.ArrayList;
import java.util.List;

/** Unbounded wildcard — {@code List<?>} size and print any HRMS collection. */
public class UnboundedDemo {

    public static void main(String[] args) {
        List<Department> departments = List.of(
                new Department("ENG", "Engineering", 12),
                new Department("HR", "People Ops", 4)
        );
        System.out.println(sizeOf(departments));
        System.out.println(printAll(departments));
    }

    static int sizeOf(List<?> items) {
        return items.size();
    }

    static List<String> printAll(List<?> items) {
        List<String> lines = new ArrayList<>();
        for (Object item : items) {
            lines.add(String.valueOf(item));
        }
        return lines;
    }
}
