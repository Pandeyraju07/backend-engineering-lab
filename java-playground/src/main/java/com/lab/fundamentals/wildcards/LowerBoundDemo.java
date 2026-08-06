package com.lab.fundamentals.wildcards;

import java.util.ArrayList;
import java.util.List;

/** Lower-bounded wildcard — {@code List<? super Integer>} accept headcount / grade numbers. */
public class LowerBoundDemo {

    public static void main(String[] args) {
        List<Number> grades = new ArrayList<>();
        addNumbers(grades, 1, 2, 3);
        System.out.println(grades);
    }

    static void addNumbers(List<? super Integer> target, Integer... values) {
        for (Integer value : values) {
            target.add(value);
        }
    }

    static int countEntries(List<? super Integer> target) {
        return target.size();
    }
}
