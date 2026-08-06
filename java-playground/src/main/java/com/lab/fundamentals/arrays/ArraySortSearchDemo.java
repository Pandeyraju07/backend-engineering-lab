package com.lab.fundamentals.arrays;

import java.util.Arrays;

/** Sort & search — rank salary bands and locate an employee pay level. */
public class ArraySortSearchDemo {

    public static void main(String[] args) {
        double[] salaries = {75_000, 60_000, 90_000, 65_000, 80_000};
        double[] ranked = rankSalariesAscending(salaries);

        System.out.println("Sort: ranked salaries=" + Arrays.toString(ranked));
        System.out.println("Search: index of 75_000=" + findSalaryIndex(ranked, 75_000));
        System.out.println("Search: top earner=" + topEarner(salaries));
    }

    static double[] rankSalariesAscending(double[] salaries) {
        double[] ranked = Arrays.copyOf(salaries, salaries.length);
        Arrays.sort(ranked);
        return ranked;
    }

    static int findSalaryIndex(double[] sortedSalaries, double target) {
        return Arrays.binarySearch(sortedSalaries, target);
    }

    static double topEarner(double[] salaries) {
        if (salaries.length == 0) {
            return 0;
        }
        double[] ranked = rankSalariesAscending(salaries);
        return ranked[ranked.length - 1];
    }

    static int countAboveThreshold(double[] salaries, double threshold) {
        int count = 0;
        for (double salary : salaries) {
            if (salary > threshold) {
                count++;
            }
        }
        return count;
    }
}
