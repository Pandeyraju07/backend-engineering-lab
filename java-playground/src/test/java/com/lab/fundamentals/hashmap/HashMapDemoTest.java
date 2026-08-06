package com.lab.fundamentals.hashmap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HashMapDemoTest {

    @Test
    void crudPutsGetsAndRemovesSalary() {
        Map<String, Double> salaries = HashMapCrudDemo.seedSalaries();

        assertEquals(75_000.0, HashMapCrudDemo.lookupSalary(salaries, "E001"));
        assertTrue(HashMapCrudDemo.containsEmployee(salaries, "E002"));

        HashMapCrudDemo.putSalary(salaries, "E004", 91_000);
        assertEquals(91_000.0, salaries.get("E004"));
        assertEquals(3, HashMapCrudDemo.removeEmployee(salaries, "E003"));
        assertFalse(HashMapCrudDemo.containsEmployee(salaries, "E003"));
    }

    @Test
    void computeIfAbsentAndMergeAccumulate() {
        Map<String, Double> salaries = new HashMap<>();

        assertEquals(HashMapComputeDemo.DEFAULT_SALARY,
                HashMapComputeDemo.ensureDefault(salaries, "E100"));
        assertEquals(55_000.0, HashMapComputeDemo.applyRaise(salaries, "E100", 5_000));

        Map<String, Integer> attendance = new HashMap<>();
        assertEquals(1, HashMapComputeDemo.bumpAttendance(attendance, "E100"));
        assertEquals(2, HashMapComputeDemo.bumpAttendance(attendance, "E100"));
    }

    @Test
    void iterateExposesKeysValuesAndForEach() {
        Map<String, Double> salaries = HashMapCrudDemo.seedSalaries();

        assertTrue(HashMapIterateDemo.employeeIds(salaries).contains("E001"));
        assertEquals(3, HashMapIterateDemo.salaryValues(salaries).size());
        assertEquals(225_000.0, HashMapIterateDemo.sumSalaries(salaries));
        assertEquals(3, HashMapIterateDemo.formatEntries(salaries).size());
    }

    @Test
    void salaryLookupIntegratesCrudComputeAndIterate() {
        HashMapDemo.SalaryMapResult result = HashMapDemo.runSalaryLookup();

        assertEquals(75_000.0, result.lookedUpSalary());
        assertTrue(result.containsE002());
        assertEquals(80_000.0, result.raisedE001());
        assertEquals(HashMapComputeDemo.DEFAULT_SALARY, result.defaultForNewHire());
        assertEquals(4, result.sizeAfterRemove());
        assertEquals(4, result.formattedEntryCount());
        assertTrue(result.totalSalaries() > 0);
    }
}
