package com.lab.fundamentals.hashmap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HashMapDemoTest {

    @Test
    void hashMapStoresAndRetrievesValues() {
        Map<String, Integer> map = new HashMap<>();
        map.put("E001", 75000);
        assertEquals(75000, map.get("E001"));
        assertTrue(map.containsKey("E001"));
    }
}
