package com.lab.fundamentals.linkedhashmap;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedHashMapDemoTest {

    @Test
    void insertionOrderPreservesPutSequence() {
        LinkedHashMap<String, String> map = InsertionOrderMapDemo.seedOnboardingOrder();

        assertEquals(List.of("E010", "E011", "E012"), InsertionOrderMapDemo.insertionOrderIds(map));
        assertEquals(List.of("Dev", "Esha", "Farah"), InsertionOrderMapDemo.insertionOrderNames(map));
        assertTrue(InsertionOrderMapDemo.preservesInsertionAfterGet(map, "E011"));
    }

    @Test
    void accessOrderMovesTouchedKeyToEndAndEvictsEldest() {
        LinkedHashMap<String, String> cache = AccessOrderDemo.newAccessOrderMap(3);
        AccessOrderDemo.touch(cache, "E001", "Asha");
        AccessOrderDemo.touch(cache, "E002", "Bala");
        AccessOrderDemo.touch(cache, "E003", "Chitra");
        AccessOrderDemo.touch(cache, "E001", "Asha");
        AccessOrderDemo.touch(cache, "E004", "Deepa");

        // After re-touch E001 then add E004, eldest E002 is evicted.
        assertEquals(List.of("E003", "E001", "E004"), AccessOrderDemo.iterationOrder(cache));
        assertEquals("E004", AccessOrderDemo.peekMostRecent(cache));
        assertFalse(cache.containsKey("E002"));
    }

    @Test
    void recentViewsIntegratesInsertionAndAccessOrder() {
        LinkedHashMapDemo.RecentViewsResult result = LinkedHashMapDemo.runRecentViews(3);

        assertEquals(List.of("E010", "E011", "E012"), result.onboardingOrder());
        assertTrue(result.insertionOrderStableOnGet());
        assertEquals(List.of("E003", "E001", "E004"), result.accessOrderAfterLru());
        assertEquals("E004", result.mostRecentView());
        assertEquals(3, result.cacheSize());
        assertEquals(3, result.maxCacheEntries());
    }
}
