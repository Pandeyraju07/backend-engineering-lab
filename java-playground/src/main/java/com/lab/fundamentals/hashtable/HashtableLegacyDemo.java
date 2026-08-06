package com.lab.fundamentals.hashtable;

import java.util.Hashtable;

/** Legacy Hashtable put/get — department code → headcount (no null keys/values). */
public class HashtableLegacyDemo {

    public static void main(String[] args) {
        Hashtable<String, Integer> heads = seedHeadcount();
        System.out.println("HR=" + lookup(heads, "HR") + ", size=" + heads.size());
    }

    static Hashtable<String, Integer> seedHeadcount() {
        Hashtable<String, Integer> table = new Hashtable<>();
        table.put("HR", 12);
        table.put("ENG", 40);
        table.put("FIN", 8);
        return table;
    }

    static void putHeadcount(Hashtable<String, Integer> table, String dept, int count) {
        table.put(dept, count);
    }

    static Integer lookup(Hashtable<String, Integer> table, String dept) {
        return table.get(dept);
    }

    static boolean containsDept(Hashtable<String, Integer> table, String dept) {
        return table.containsKey(dept);
    }

    static int removeDept(Hashtable<String, Integer> table, String dept) {
        table.remove(dept);
        return table.size();
    }
}
