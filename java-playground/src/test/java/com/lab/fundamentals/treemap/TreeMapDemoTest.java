package com.lab.fundamentals.treemap;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NavigableMap;

import static org.junit.jupiter.api.Assertions.*;

class TreeMapDemoTest {

    @Test
    void sortKeepsEmployeeIdsInNaturalOrder() {
        NavigableMap<String, Double> salaries = TreeMapSortDemo.seedSortedSalaries();

        assertEquals(List.of("E010", "E015", "E020", "E030"),
                TreeMapSortDemo.sortedEmployeeIds(salaries));
        assertEquals("E010", TreeMapSortDemo.firstEmployee(salaries));
        assertEquals("E030", TreeMapSortDemo.lastEmployee(salaries));
    }

    @Test
    void rangeViewsSliceSalaryBands() {
        NavigableMap<Double, String> bySalary = TreeMapRangeDemo.seedSalaryIndex();

        // mid [75000, 90000): 78000, 85000
        assertEquals(2, TreeMapRangeDemo.bandSize(TreeMapRangeDemo.midBand(bySalary, 75_000, 90_000)));
        // below 80000: 70000, 78000
        assertEquals(2, TreeMapRangeDemo.bandSize(TreeMapRangeDemo.belowBand(bySalary, 80_000)));
        // above 80000 inclusive: 85000, 95000
        assertEquals(2, TreeMapRangeDemo.bandSize(TreeMapRangeDemo.aboveBand(bySalary, 80_000)));
    }

    @Test
    void salaryBandsIntegrateSortAndRange() {
        TreeMapDemo.SalaryBandResult result = TreeMapDemo.runSalaryBands();

        assertEquals(List.of("E010", "E015", "E020", "E030"), result.sortedEmployeeIds());
        assertEquals("E010", result.firstEmployeeId());
        assertEquals("E030", result.lastEmployeeId());
        assertEquals(2, result.midBandCount());
        assertEquals(2, result.belowBandCount());
        assertEquals(2, result.aboveBandCount());
    }
}
