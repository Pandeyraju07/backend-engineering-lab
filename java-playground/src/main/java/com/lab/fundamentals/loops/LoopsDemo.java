package com.lab.fundamentals.loops;

/**
 * for, while, do-while, and enhanced for loops.
 */
public class LoopsDemo {

    public static void main(String[] args) {
        System.out.println("=== for loop ===");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("=== while loop ===");
        int count = 1;
        while (count <= 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();

        System.out.println("=== do-while loop ===");
        int num = 1;
        do {
            System.out.print(num + " ");
            num++;
        } while (num <= 5);
        System.out.println();

        System.out.println("=== enhanced for loop ===");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
