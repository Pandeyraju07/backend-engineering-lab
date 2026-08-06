package com.lab.fundamentals.concurrenthashmap;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HRMS concurrent attendance — ConcurrentHashMap put/get and compute/merge in one flow.
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentAttendanceResult result = runAttendanceRollup();
        System.out.println(result);
    }

    static ConcurrentAttendanceResult runAttendanceRollup() {
        ConcurrentHashMap<String, Integer> attendance = ConcurrentPutDemo.seedAttendance();

        int e001 = ConcurrentPutDemo.getCount(attendance, "E001");
        ConcurrentPutDemo.putCount(attendance, "E004", 19);

        int afterMerge = ConcurrentComputeDemo.markPresent(attendance, "E001");
        ConcurrentComputeDemo.ensureBaseline(attendance, "E050", 0);
        int adjusted = ConcurrentComputeDemo.adjustWithCompute(attendance, "E003", 2);

        ConcurrentHashMap<String, Integer> parallel = ConcurrentPutDemo.parallelSeed(5, 10);
        int parallelSize = parallel.size();
        List<String> keys = ConcurrentPutDemo.keysSnapshot(attendance);
        int total = ConcurrentComputeDemo.totalDays(attendance);

        return new ConcurrentAttendanceResult(
                e001,
                afterMerge,
                adjusted,
                keys,
                total,
                parallelSize,
                attendance.size()
        );
    }

    record ConcurrentAttendanceResult(
            int initialE001,
            int e001AfterPresent,
            int e003AfterAdjust,
            List<String> sortedKeys,
            int totalPresentDays,
            int parallelSeedSize,
            int mapSize
    ) {
        @Override
        public String toString() {
            return ("ConcurrentAttendanceResult{e001=%d→%d, e003=%d, keys=%s, "
                    + "total=%d, parallel=%d, size=%d}")
                    .formatted(initialE001, e001AfterPresent, e003AfterAdjust, sortedKeys,
                            totalPresentDays, parallelSeedSize, mapSize);
        }
    }
}
