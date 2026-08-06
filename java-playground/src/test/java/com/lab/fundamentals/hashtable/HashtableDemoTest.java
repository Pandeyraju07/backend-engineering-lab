package com.lab.fundamentals.hashtable;

import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashtableDemoTest {

    @Test
    void legacyPutGetAndRemove() {
        Hashtable<String, Integer> table = HashtableLegacyDemo.seedHeadcount();

        assertEquals(12, HashtableLegacyDemo.lookup(table, "HR"));
        assertTrue(HashtableLegacyDemo.containsDept(table, "ENG"));
        HashtableLegacyDemo.putHeadcount(table, "OPS", 15);
        assertEquals(15, table.get("OPS"));
        assertEquals(3, HashtableLegacyDemo.removeDept(table, "FIN"));
        assertFalse(HashtableLegacyDemo.containsDept(table, "FIN"));
    }

    @Test
    void syncStyleOpsEnumerateAndRejectNull() {
        Hashtable<String, Integer> table = HashtableLegacyDemo.seedHeadcount();

        assertEquals(List.of("ENG", "FIN", "HR"), HashtableSyncDemo.enumerateKeys(table));
        assertEquals(60, HashtableSyncDemo.totalHeadcount(table));

        HashtableSyncDemo.incrementUnderLock(table, "HR", 3);
        assertEquals(15, table.get("HR"));
        assertTrue(HashtableSyncDemo.rejectsNullKey(table));
    }

    @Test
    void headcountStoreIntegratesLegacyAndSyncDemos() {
        HashtableDemo.HashtableStoreResult result = HashtableDemo.runHeadcountStore();

        assertEquals(12, result.hrHeadcount());
        assertTrue(result.hadFinanceBeforeRemove());
        assertTrue(result.rejectsNullKey());
        assertEquals(3, result.sizeAfterRemove());
        assertEquals(List.of("ENG", "HR", "OPS"), result.sortedKeys());
        assertEquals(69, result.totalHeadcount()); // HR 12 + ENG 42 + OPS 15
        assertEquals(42, result.engAfterIncrement());
    }
}
