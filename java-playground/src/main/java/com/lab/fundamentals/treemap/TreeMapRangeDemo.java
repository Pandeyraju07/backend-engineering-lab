package com.lab.fundamentals.treemap;

import java.util.NavigableMap;
import java.util.TreeMap;

/** TreeMap range views — salary bands via subMap / headMap / tailMap. */
public class TreeMapRangeDemo {

    public static void main(String[] args) {
        NavigableMap<Double, String> bySalary = seedSalaryIndex();
        System.out.println("mid: " + midBand(bySalary, 75_000, 90_000));
        System.out.println("head: " + belowBand(bySalary, 80_000));
        System.out.println("tail: " + aboveBand(bySalary, 80_000));
    }

    static NavigableMap<Double, String> seedSalaryIndex() {
        NavigableMap<Double, String> bySalary = new TreeMap<>();
        bySalary.put(70_000.0, "E010");
        bySalary.put(78_000.0, "E015");
        bySalary.put(85_000.0, "E020");
        bySalary.put(95_000.0, "E030");
        return bySalary;
    }

    /** Inclusive lower, exclusive upper — mid salary band. */
    static NavigableMap<Double, String> midBand(
            NavigableMap<Double, String> bySalary, double fromInclusive, double toExclusive) {
        return bySalary.subMap(fromInclusive, true, toExclusive, false);
    }

    /** Strictly below ceiling. */
    static NavigableMap<Double, String> belowBand(
            NavigableMap<Double, String> bySalary, double toExclusive) {
        return bySalary.headMap(toExclusive, false);
    }

    /** Inclusive floor and above. */
    static NavigableMap<Double, String> aboveBand(
            NavigableMap<Double, String> bySalary, double fromInclusive) {
        return bySalary.tailMap(fromInclusive, true);
    }

    static int bandSize(NavigableMap<Double, String> band) {
        return band.size();
    }
}
