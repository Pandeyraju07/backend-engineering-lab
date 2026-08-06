package com.lab.fundamentals.linkedhashset;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedHashSetDemoTest {

    @Test
    void insertionOrderPreservesFirstSeenDepartments() {
        List<String> ordered = InsertionOrderDemo.orderedDepartments(
                "Engineering", "People Ops", "Engineering", "Finance", "People Ops"
        );

        assertEquals(List.of("Engineering", "People Ops", "Finance"), ordered);
        assertEquals(3, InsertionOrderDemo.asLinkedSet(
                "Engineering", "People Ops", "Engineering", "Finance").size());
        assertEquals("Engineering", InsertionOrderDemo.asDepartmentList("Engineering", "Finance").get(0).name());
    }

    @Test
    void dedupeKeepsFirstOccurrenceAndCountsDuplicates() {
        List<String> raw = List.of("Engineering", "Finance", "Engineering", "Legal", "Finance");
        List<String> deduped = DeduplicateDemo.dedupePreservingOrder(raw);

        assertEquals(List.of("Engineering", "Finance", "Legal"), deduped);
        assertEquals(2, DeduplicateDemo.duplicateCount(raw));
        assertTrue(DeduplicateDemo.firstOccurrenceKept(raw, deduped));
    }

    @Test
    void orderedDepartmentsIntegratesOrderAndDedupe() {
        LinkedHashSetDemo.OrderedDeptResult result = LinkedHashSetDemo.runOrderedDepartments(
                "Engineering", "People Ops", "Engineering", "Finance", "People Ops", "Legal"
        );

        assertEquals(List.of("Engineering", "People Ops", "Finance", "Legal"), result.insertionOrder());
        assertEquals(result.insertionOrder(), result.dedupedOrder());
        assertEquals(2, result.duplicatesRemoved());
        assertTrue(result.firstOccurrencePreserved());
        assertEquals(4, result.uniqueCount());
    }
}
