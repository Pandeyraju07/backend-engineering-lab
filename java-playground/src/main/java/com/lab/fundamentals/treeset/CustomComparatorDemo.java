package com.lab.fundamentals.treeset;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * TreeSet custom Comparator — reverse natural order or sort employee IDs by length.
 */
public class CustomComparatorDemo {

    static final Comparator<String> REVERSE_ORDER = Comparator.reverseOrder();
    static final Comparator<String> BY_LENGTH_THEN_VALUE =
            Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder());

    public static void main(String[] args) {
        System.out.println("Reverse: " + reverseSortedIds("EMP-1", "EMP-3", "EMP-2"));
        System.out.println("By length: " + lengthSortedIds("E-10", "EMP-1", "E-2", "STAFF-9"));
    }

    static List<String> reverseSortedIds(String... ids) {
        return sortedWith(REVERSE_ORDER, ids);
    }

    static List<String> lengthSortedIds(String... ids) {
        return sortedWith(BY_LENGTH_THEN_VALUE, ids);
    }

    static TreeSet<String> reverseSet(String... ids) {
        return setWith(REVERSE_ORDER, ids);
    }

    static TreeSet<String> lengthSet(String... ids) {
        return setWith(BY_LENGTH_THEN_VALUE, ids);
    }

    private static List<String> sortedWith(Comparator<String> comparator, String... ids) {
        return new ArrayList<>(setWith(comparator, ids));
    }

    private static TreeSet<String> setWith(Comparator<String> comparator, String... ids) {
        TreeSet<String> sorted = new TreeSet<>(comparator);
        if (ids != null) {
            for (String id : ids) {
                if (id != null && !id.isBlank()) {
                    sorted.add(id.trim());
                }
            }
        }
        return sorted;
    }
}
