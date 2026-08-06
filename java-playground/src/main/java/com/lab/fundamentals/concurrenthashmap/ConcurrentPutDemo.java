package com.lab.fundamentals.concurrenthashmap;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/** ConcurrentHashMap put/get — employee attendance day flags. */
public class ConcurrentPutDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> attendance = seedAttendance();
        System.out.println("E001=" + getCount(attendance, "E001") + ", size=" + attendance.size());
    }

    static ConcurrentHashMap<String, Integer> seedAttendance() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("E001", 18);
        map.put("E002", 20);
        map.put("E003", 15);
        return map;
    }

    static void putCount(ConcurrentHashMap<String, Integer> map, String employeeId, int days) {
        map.put(employeeId, days);
    }

    static Integer getCount(ConcurrentHashMap<String, Integer> map, String employeeId) {
        return map.get(employeeId);
    }

    /** Optional parallel put — deterministic keys, single-thread-safe API usage. */
    static ConcurrentHashMap<String, Integer> parallelSeed(int employeeCount, int presentDays) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        IntStream.rangeClosed(1, employeeCount)
                .parallel()
                .forEach(i -> map.put("E" + String.format("%03d", i), presentDays));
        return map;
    }

    static List<String> keysSnapshot(ConcurrentHashMap<String, Integer> map) {
        return map.keySet().stream().sorted().toList();
    }
}
