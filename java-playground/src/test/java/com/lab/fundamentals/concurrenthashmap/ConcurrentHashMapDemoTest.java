package com.lab.fundamentals.concurrenthashmap;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrentHashMapDemoTest {

    @Test
    void putAndGetAttendanceCounts() {
        ConcurrentHashMap<String, Integer> map = ConcurrentPutDemo.seedAttendance();

        assertEquals(18, ConcurrentPutDemo.getCount(map, "E001"));
        ConcurrentPutDemo.putCount(map, "E004", 19);
        assertEquals(19, map.get("E004"));
        assertEquals(4, map.size());
    }

    @Test
    void computeAndMergeBumpAttendance() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        assertEquals(1, ConcurrentComputeDemo.markPresent(map, "E001"));
        assertEquals(2, ConcurrentComputeDemo.markPresent(map, "E001"));
        assertEquals(0, ConcurrentComputeDemo.ensureBaseline(map, "E050", 0));
        assertEquals(5, ConcurrentComputeDemo.adjustWithCompute(map, "E050", 5));
        assertEquals(7, ConcurrentComputeDemo.totalDays(map));
    }

    @Test
    void parallelSeedFillsDistinctKeys() {
        ConcurrentHashMap<String, Integer> map = ConcurrentPutDemo.parallelSeed(8, 12);

        assertEquals(8, map.size());
        assertEquals(12, map.get("E001"));
        assertEquals(12, map.get("E008"));
        assertEquals(List.of("E001", "E002", "E003", "E004", "E005", "E006", "E007", "E008"),
                ConcurrentPutDemo.keysSnapshot(map));
    }

    @Test
    void attendanceRollupIntegratesPutAndCompute() {
        ConcurrentHashMapDemo.ConcurrentAttendanceResult result =
                ConcurrentHashMapDemo.runAttendanceRollup();

        assertEquals(18, result.initialE001());
        assertEquals(19, result.e001AfterPresent());
        assertEquals(17, result.e003AfterAdjust());
        assertEquals(List.of("E001", "E002", "E003", "E004", "E050"), result.sortedKeys());
        // 19 + 20 + 17 + 19 + 0
        assertEquals(75, result.totalPresentDays());
        assertEquals(5, result.parallelSeedSize());
        assertEquals(5, result.mapSize());
    }
}
