package com.lab.fundamentals.arrays;

import java.util.Arrays;

/**
 * Single and multi-dimensional arrays.
 */
public class ArraysDemo {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Length: " + numbers.length);
        System.out.println("First: " + numbers[0]);
        System.out.println("Last: " + numbers[numbers.length - 1]);

        numbers[2] = 99;
        System.out.println("After update: " + Arrays.toString(numbers));

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("Matrix [1][2]: " + matrix[1][2]);

        int[] copy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(copy);
        System.out.println("Sorted copy: " + Arrays.toString(copy));
    }
}
