package com.lab.fundamentals.hashtable;

import java.util.Hashtable;
import java.util.List;

/**
 * HRMS department headcount store — legacy Hashtable put/get and sync-style ops.
 */
public class HashtableDemo {

    public static void main(String[] args) {
        HashtableStoreResult result = runHeadcountStore();
        System.out.println(result);
    }

    static HashtableStoreResult runHeadcountStore() {
        Hashtable<String, Integer> table = HashtableLegacyDemo.seedHeadcount();

        int hr = HashtableLegacyDemo.lookup(table, "HR");
        HashtableLegacyDemo.putHeadcount(table, "OPS", 15);
        HashtableSyncDemo.incrementUnderLock(table, "ENG", 2);
        boolean hasFin = HashtableLegacyDemo.containsDept(table, "FIN");
        boolean nullRejected = HashtableSyncDemo.rejectsNullKey(table);

        int sizeAfterRemove = HashtableLegacyDemo.removeDept(table, "FIN");
        List<String> keys = HashtableSyncDemo.enumerateKeys(table);
        int total = HashtableSyncDemo.totalHeadcount(table);

        return new HashtableStoreResult(
                hr,
                hasFin,
                nullRejected,
                sizeAfterRemove,
                keys,
                total,
                table.get("ENG")
        );
    }

    record HashtableStoreResult(
            int hrHeadcount,
            boolean hadFinanceBeforeRemove,
            boolean rejectsNullKey,
            int sizeAfterRemove,
            List<String> sortedKeys,
            int totalHeadcount,
            int engAfterIncrement
    ) {
        @Override
        public String toString() {
            return ("HashtableStoreResult{hr=%d, hadFin=%b, nullRejected=%b, size=%d, "
                    + "keys=%s, total=%d, eng=%d}")
                    .formatted(hrHeadcount, hadFinanceBeforeRemove, rejectsNullKey,
                            sizeAfterRemove, sortedKeys, totalHeadcount, engAfterIncrement);
        }
    }
}
