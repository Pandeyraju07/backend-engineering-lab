package com.lab.fundamentals.treeset;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class TreeSetDemoTest {

    @Test
    void naturalOrderSortsUniqueEmployeeIds() {
        List<String> sorted = NaturalOrderDemo.sortedEmployeeIds("EMP-3", "EMP-1", "EMP-2", "EMP-1");
        TreeSet<String> set = NaturalOrderDemo.asNaturalSet("EMP-3", "EMP-1", "EMP-2");

        assertEquals(List.of("EMP-1", "EMP-2", "EMP-3"), sorted);
        assertEquals("EMP-1", NaturalOrderDemo.first(set));
        assertEquals("EMP-3", NaturalOrderDemo.last(set));
        assertEquals("EMP-1", NaturalOrderDemo.asEmployeeIds("EMP-2", "EMP-1").get(0).value());
    }

    @Test
    void customComparatorSupportsReverseAndLengthOrder() {
        assertEquals(
                List.of("EMP-3", "EMP-2", "EMP-1"),
                CustomComparatorDemo.reverseSortedIds("EMP-1", "EMP-3", "EMP-2")
        );
        assertEquals(
                List.of("E-2", "E-10", "EMP-1", "STAFF-9"),
                CustomComparatorDemo.lengthSortedIds("E-10", "EMP-1", "E-2", "STAFF-9")
        );
        assertEquals("EMP-3", CustomComparatorDemo.reverseSet("EMP-1", "EMP-3").first());
        assertEquals("E-2", CustomComparatorDemo.lengthSet("EMP-1", "E-2").first());
    }

    @Test
    void sortedIdIndexIntegratesNaturalAndCustomOrders() {
        TreeSetDemo.SortedIdResult result = TreeSetDemo.runSortedIdIndex(
                "EMP-3", "E-2", "EMP-1", "EMP-3", "STAFF-9", "EMP-2"
        );

        assertEquals("E-2", result.firstId());
        assertEquals("STAFF-9", result.lastId());
        assertEquals(List.of("E-2", "EMP-1", "EMP-2", "EMP-3", "STAFF-9"), result.naturalOrder());
        assertEquals(List.of("STAFF-9", "EMP-3", "EMP-2", "EMP-1", "E-2"), result.reverseOrder());
        assertEquals(List.of("E-2", "EMP-1", "EMP-2", "EMP-3", "STAFF-9"), result.lengthOrder());
        assertEquals(5, result.uniqueCount());
    }
}
