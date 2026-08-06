package com.lab.fundamentals.hashtable;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;

/**
 * Hashtable synchronized nature — basic ops and legacy Enumeration over dept store.
 * (Single-thread API usage; Map itself is synchronized.)
 */
public class HashtableSyncDemo {

    public static void main(String[] args) {
        Hashtable<String, Integer> table = HashtableLegacyDemo.seedHeadcount();
        System.out.println("keys=" + enumerateKeys(table));
        System.out.println("total=" + totalHeadcount(table));
    }

    static List<String> enumerateKeys(Hashtable<String, Integer> table) {
        List<String> keys = new ArrayList<>();
        Enumeration<String> en = table.keys();
        while (en.hasMoreElements()) {
            keys.add(en.nextElement());
        }
        Collections.sort(keys);
        return keys;
    }

    static int totalHeadcount(Hashtable<String, Integer> table) {
        int total = 0;
        Enumeration<Integer> values = table.elements();
        while (values.hasMoreElements()) {
            total += values.nextElement();
        }
        return total;
    }

    static synchronized void incrementUnderLock(
            Hashtable<String, Integer> table, String dept, int delta) {
        Integer current = table.get(dept);
        if (current == null) {
            table.put(dept, delta);
        } else {
            table.put(dept, current + delta);
        }
    }

    static boolean rejectsNullKey(Hashtable<String, Integer> table) {
        try {
            table.put(null, 1);
            return false;
        } catch (NullPointerException ex) {
            return true;
        }
    }
}
