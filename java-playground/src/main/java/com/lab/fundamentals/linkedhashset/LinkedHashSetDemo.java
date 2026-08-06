package com.lab.fundamentals.linkedhashset;

import java.util.List;

/**
 * HRMS department tour — LinkedHashSet insertion order plus first-occurrence dedupe in one flow.
 */
public class LinkedHashSetDemo {

    public static void main(String[] args) {
        OrderedDeptResult result = runOrderedDepartments(
                "Engineering", "People Ops", "Engineering", "Finance", "People Ops", "Legal"
        );
        System.out.println(result);
    }

    static OrderedDeptResult runOrderedDepartments(String... rawDepartments) {
        List<String> ordered = InsertionOrderDemo.orderedDepartments(rawDepartments);
        List<String> deduped = DeduplicateDemo.dedupePreservingOrder(
                rawDepartments == null ? List.of() : List.of(rawDepartments)
        );
        int duplicatesRemoved = DeduplicateDemo.duplicateCount(
                rawDepartments == null ? List.of() : List.of(rawDepartments)
        );
        boolean orderPreserved = DeduplicateDemo.firstOccurrenceKept(
                rawDepartments == null ? List.of() : List.of(rawDepartments),
                ordered
        );

        return new OrderedDeptResult(
                ordered,
                deduped,
                duplicatesRemoved,
                orderPreserved,
                ordered.size()
        );
    }

    record OrderedDeptResult(
            List<String> insertionOrder,
            List<String> dedupedOrder,
            int duplicatesRemoved,
            boolean firstOccurrencePreserved,
            int uniqueCount
    ) {
        @Override
        public String toString() {
            return "OrderedDept{order=%s, deduped=%s, duplicatesRemoved=%d, preserved=%b, unique=%d}"
                    .formatted(insertionOrder, dedupedOrder, duplicatesRemoved,
                            firstOccurrencePreserved, uniqueCount);
        }
    }
}
