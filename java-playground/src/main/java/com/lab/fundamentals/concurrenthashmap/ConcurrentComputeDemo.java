package com.lab.fundamentals.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/** ConcurrentHashMap compute / merge — attendance day increments. */
public class ConcurrentComputeDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> attendance = new ConcurrentHashMap<>();
        markPresent(attendance, "E001");
        markPresent(attendance, "E001");
        ensureBaseline(attendance, "E050", 0);
        System.out.println(attendance);
    }

    static int markPresent(ConcurrentHashMap<String, Integer> attendance, String employeeId) {
        attendance.merge(employeeId, 1, Integer::sum);
        return attendance.get(employeeId);
    }

    static int ensureBaseline(
            ConcurrentHashMap<String, Integer> attendance, String employeeId, int baseline) {
        return attendance.computeIfAbsent(employeeId, id -> baseline);
    }

    static int adjustWithCompute(
            ConcurrentHashMap<String, Integer> attendance, String employeeId, int delta) {
        attendance.compute(employeeId, (id, current) -> {
            int base = current == null ? 0 : current;
            return base + delta;
        });
        return attendance.get(employeeId);
    }

    static int totalDays(ConcurrentHashMap<String, Integer> attendance) {
        return attendance.reduceValues(1, Integer::sum);
    }
}
