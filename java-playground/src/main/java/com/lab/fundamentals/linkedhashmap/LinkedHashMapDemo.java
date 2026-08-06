package com.lab.fundamentals.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * HRMS recent employee views — insertion order + access-order LRU cache in one flow.
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        RecentViewsResult result = runRecentViews(3);
        System.out.println(result);
    }

    static RecentViewsResult runRecentViews(int cacheSize) {
        LinkedHashMap<String, String> insertion = InsertionOrderMapDemo.seedOnboardingOrder();
        List<String> onboardOrder = InsertionOrderMapDemo.insertionOrderIds(insertion);
        boolean getKeepsOrder = InsertionOrderMapDemo.preservesInsertionAfterGet(insertion, "E010");

        LinkedHashMap<String, String> cache = AccessOrderDemo.newAccessOrderMap(cacheSize);
        AccessOrderDemo.touch(cache, "E001", "Asha");
        AccessOrderDemo.touch(cache, "E002", "Bala");
        AccessOrderDemo.touch(cache, "E003", "Chitra");
        AccessOrderDemo.touch(cache, "E001", "Asha");
        AccessOrderDemo.touch(cache, "E004", "Deepa");

        List<String> accessOrder = AccessOrderDemo.iterationOrder(cache);
        String mostRecent = AccessOrderDemo.peekMostRecent(cache);

        return new RecentViewsResult(
                onboardOrder,
                getKeepsOrder,
                accessOrder,
                mostRecent,
                cache.size(),
                cacheSize
        );
    }

    record RecentViewsResult(
            List<String> onboardingOrder,
            boolean insertionOrderStableOnGet,
            List<String> accessOrderAfterLru,
            String mostRecentView,
            int cacheSize,
            int maxCacheEntries
    ) {
        @Override
        public String toString() {
            return ("RecentViewsResult{onboard=%s, stableGet=%b, accessOrder=%s, "
                    + "mostRecent=%s, size=%d/%d}")
                    .formatted(onboardingOrder, insertionOrderStableOnGet, accessOrderAfterLru,
                            mostRecentView, cacheSize, maxCacheEntries);
        }
    }
}
