package com.lab.fundamentals.treeset;

import java.util.List;
import java.util.TreeSet;

/**
 * HRMS employee id index — natural TreeSet order plus custom Comparator views in one flow.
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        SortedIdResult result = runSortedIdIndex("EMP-3", "E-2", "EMP-1", "EMP-3", "STAFF-9", "EMP-2");
        System.out.println(result);
    }

    static SortedIdResult runSortedIdIndex(String... rawIds) {
        TreeSet<String> natural = NaturalOrderDemo.asNaturalSet(rawIds);
        List<String> naturalOrder = NaturalOrderDemo.sortedEmployeeIds(rawIds);
        List<String> reverseOrder = CustomComparatorDemo.reverseSortedIds(rawIds);
        List<String> lengthOrder = CustomComparatorDemo.lengthSortedIds(rawIds);

        return new SortedIdResult(
                NaturalOrderDemo.first(natural),
                NaturalOrderDemo.last(natural),
                naturalOrder,
                reverseOrder,
                lengthOrder,
                natural.size()
        );
    }

    record SortedIdResult(
            String firstId,
            String lastId,
            List<String> naturalOrder,
            List<String> reverseOrder,
            List<String> lengthOrder,
            int uniqueCount
    ) {
        @Override
        public String toString() {
            return "SortedId{first=%s, last=%s, natural=%s, reverse=%s, byLength=%s, unique=%d}"
                    .formatted(firstId, lastId, naturalOrder, reverseOrder, lengthOrder, uniqueCount);
        }
    }
}
