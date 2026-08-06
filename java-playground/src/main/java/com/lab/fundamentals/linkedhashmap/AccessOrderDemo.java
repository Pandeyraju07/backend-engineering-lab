package com.lab.fundamentals.linkedhashmap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** LinkedHashMap accessOrder=true — LRU-ish recent employee profile views. */
public class AccessOrderDemo {

    public static final int DEFAULT_CAPACITY = 16;
    public static final float LOAD_FACTOR = 0.75f;

    public static void main(String[] args) {
        LinkedHashMap<String, String> views = newAccessOrderMap(3);
        touch(views, "E001", "Asha");
        touch(views, "E002", "Bala");
        touch(views, "E003", "Chitra");
        touch(views, "E001", "Asha");
        System.out.println(iterationOrder(views));
    }

    static LinkedHashMap<String, String> newAccessOrderMap(int maxEntries) {
        return new LinkedHashMap<>(DEFAULT_CAPACITY, LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > maxEntries;
            }
        };
    }

    static void touch(LinkedHashMap<String, String> views, String employeeId, String name) {
        views.put(employeeId, name);
    }

    static String peekMostRecent(LinkedHashMap<String, String> views) {
        String last = null;
        for (String id : views.keySet()) {
            last = id;
        }
        return last;
    }

    static List<String> iterationOrder(LinkedHashMap<String, String> views) {
        return new ArrayList<>(views.keySet());
    }
}
