package com.lab.fundamentals.arrays;

import java.util.Arrays;

/** Array copy — snapshot salaries before revision so payroll can audit changes. */
public class ArrayCopyDemo {

    public static void main(String[] args) {
        double[] currentSalaries = {60_000, 65_000, 70_000, 75_000};
        double[] snapshot = snapshotSalaries(currentSalaries);

        currentSalaries[1] = 68_000;
        System.out.println("Copy: original snapshot=" + Arrays.toString(snapshot));
        System.out.println("Copy: after revision=" + Arrays.toString(currentSalaries));
        System.out.println("Copy: changed indexes=" + Arrays.toString(changedIndexes(snapshot, currentSalaries)));
    }

    static double[] snapshotSalaries(double[] salaries) {
        return Arrays.copyOf(salaries, salaries.length);
    }

    static int[] changedIndexes(double[] before, double[] after) {
        if (before.length != after.length) {
            throw new IllegalArgumentException("Salary arrays must be the same length");
        }
        int changeCount = 0;
        for (int i = 0; i < before.length; i++) {
            if (Double.compare(before[i], after[i]) != 0) {
                changeCount++;
            }
        }

        int[] indexes = new int[changeCount];
        int pos = 0;
        for (int i = 0; i < before.length; i++) {
            if (Double.compare(before[i], after[i]) != 0) {
                indexes[pos++] = i;
            }
        }
        return indexes;
    }

    static boolean hasSameSalaries(double[] left, double[] right) {
        return Arrays.equals(left, right);
    }
}
