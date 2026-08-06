package com.lab.fundamentals.loops;

/**
 * Easy reference for for / while / do-while syntax.
 * Run this class and read the output next to each example.
 */
public class LoopSyntaxDemo {

    public static void main(String[] args) {
        forLoopExample();
        whileLoopExample();
        doWhileLoopExample();
    }

    /**
     * for (start; condition; update) { body }
     *
     * 1. start   → run once before the loop
     * 2. condition → checked before every lap; stop when false
     * 3. body    → work for this lap
     * 4. update  → run after each lap, then go back to condition
     */
    private static void forLoopExample() {
        System.out.println("--- for loop: print 1 to 5 ---");

        for (int num = 1; num <= 5; num++) {
            System.out.println(num);
        }
        // num = 1 → print 1 → num++
        // num = 2 → print 2 → num++
        // ...
        // num = 5 → print 5 → num++
        // num = 6 → condition false → stop
    }

    /**
     * while (condition) { body }
     *
     * Use when you mainly care about "keep going until this is false".
     * You must update the variable yourself inside the body, or it loops forever.
     */
    private static void whileLoopExample() {
        System.out.println("--- while loop: print 1 to 5 ---");

        int num = 1;              // 1. start
        while (num <= 5) {        // 2. check condition
            System.out.println(num); // 3. body
            num++;                // 4. update (important!)
        }
    }

    /**
     * do { body } while (condition);
     *
     * Body runs at least once, even if the condition is already false.
     */
    private static void doWhileLoopExample() {
        System.out.println("--- do-while: runs once even when condition is false ---");

        int n = 1;
        do {
            System.out.println("Hello World");
        } while (n != 1); // false immediately, but body already ran once

        System.out.println("--- do-while: print 1 to 3 ---");

        int count = 1;
        do {
            System.out.println(count);
            count++;
        } while (count <= 3);
    }
}
