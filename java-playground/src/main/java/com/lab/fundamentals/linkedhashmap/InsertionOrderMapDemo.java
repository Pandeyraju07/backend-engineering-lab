package com.lab.fundamentals.linkedhashmap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** LinkedHashMap default insertion-order iteration for onboarding sequence. */
public class InsertionOrderMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<String, String> onboarded = seedOnboardingOrder();
        System.out.println(insertionOrderIds(onboarded));
    }

    static LinkedHashMap<String, String> seedOnboardingOrder() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("E010", "Dev");
        map.put("E011", "Esha");
        map.put("E012", "Farah");
        return map;
    }

    static List<String> insertionOrderIds(Map<String, String> map) {
        return new ArrayList<>(map.keySet());
    }

    static List<String> insertionOrderNames(Map<String, String> map) {
        return new ArrayList<>(map.values());
    }

    static boolean preservesInsertionAfterGet(LinkedHashMap<String, String> map, String key) {
        List<String> before = insertionOrderIds(map);
        map.get(key);
        return before.equals(insertionOrderIds(map));
    }
}
