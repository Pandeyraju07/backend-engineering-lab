package com.lab.fundamentals.arraylist;

import java.util.ArrayList;
import java.util.List;

/** ArrayList capacity — pre-size a roster buffer before bulk onboarding. */
public class ArrayListCapacityDemo {

    public static void main(String[] args) {
        ArrayList<EmployeeRecord> buffer = sizedList(8);
        System.out.println("Initial size: " + buffer.size());
        ensureCapacityForIntake(buffer, 20);
        fillSample(buffer, 5);
        System.out.println("After fill size: " + buffer.size());
    }

    /** Creates an ArrayList with an initial capacity hint (size remains 0 until adds). */
    static ArrayList<EmployeeRecord> sizedList(int initialCapacity) {
        return new ArrayList<>(Math.max(initialCapacity, 0));
    }

    static void ensureCapacityForIntake(ArrayList<EmployeeRecord> roster, int expectedHeadcount) {
        roster.ensureCapacity(expectedHeadcount);
    }

    static int sizeOf(List<EmployeeRecord> roster) {
        return roster.size();
    }

    static void fillSample(List<EmployeeRecord> roster, int count) {
        for (int i = 0; i < count; i++) {
            roster.add(new EmployeeRecord(
                    "EMP-" + (i + 1),
                    "Employee-" + (i + 1),
                    "General",
                    60_000 + (i * 1_000)
            ));
        }
    }
}
