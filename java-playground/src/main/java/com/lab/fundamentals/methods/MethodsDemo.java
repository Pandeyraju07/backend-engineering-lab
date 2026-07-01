package com.lab.fundamentals.methods;

/**
 * Method declaration, overloading, and varargs.
 */
public class MethodsDemo {

    public static void main(String[] args) {
        greet("Raju");
        System.out.println("Sum(3, 5): " + add(3, 5));
        System.out.println("Sum(1,2,3,4): " + addAll(1, 2, 3, 4));
        System.out.println("Area(5): " + calculateArea(5));
        System.out.println("Area(4, 6): " + calculateArea(4, 6));
    }

    static void greet(String name) {
        System.out.println("Hello, " + name);
    }

    static int add(int a, int b) {
        return a + b;
    }

    static int addAll(int... values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    // Method overloading
    static double calculateArea(double side) {
        return side * side;
    }

    static double calculateArea(double length, double width) {
        return length * width;
    }
}
