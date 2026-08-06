package com.lab.fundamentals.treemap;

import java.util.List;
import java.util.NavigableMap;

/**
 * HRMS salary bands — TreeMap sorted keys and range views in one flow.
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        SalaryBandResult result = runSalaryBands();
        System.out.println(result);
    }

    static SalaryBandResult runSalaryBands() {
        NavigableMap<String, Double> byId = TreeMapSortDemo.seedSortedSalaries();
        List<String> sortedIds = TreeMapSortDemo.sortedEmployeeIds(byId);
        String first = TreeMapSortDemo.firstEmployee(byId);
        String last = TreeMapSortDemo.lastEmployee(byId);

        NavigableMap<Double, String> bySalary = TreeMapRangeDemo.seedSalaryIndex();
        int midCount = TreeMapRangeDemo.bandSize(TreeMapRangeDemo.midBand(bySalary, 75_000, 90_000));
        int belowCount = TreeMapRangeDemo.bandSize(TreeMapRangeDemo.belowBand(bySalary, 80_000));
        int aboveCount = TreeMapRangeDemo.bandSize(TreeMapRangeDemo.aboveBand(bySalary, 80_000));

        return new SalaryBandResult(sortedIds, first, last, midCount, belowCount, aboveCount);
    }

    record SalaryBandResult(
            List<String> sortedEmployeeIds,
            String firstEmployeeId,
            String lastEmployeeId,
            int midBandCount,
            int belowBandCount,
            int aboveBandCount
    ) {
        @Override
        public String toString() {
            return ("SalaryBandResult{sorted=%s, first=%s, last=%s, "
                    + "mid=%d, below=%d, above=%d}")
                    .formatted(sortedEmployeeIds, firstEmployeeId, lastEmployeeId,
                            midBandCount, belowBandCount, aboveBandCount);
        }
    }
}
