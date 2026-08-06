package com.lab.fundamentals.statickeyword;

/**
 * Static fields and methods — one shared counter for HRMS employee ids.
 */
public class StaticFieldDemo {

    public static void main(String[] args) {
        EmployeeIdGenerator.resetForTests();
        System.out.println(nextId() + " count=" + currentCount());
    }

    static String nextId() {
        return EmployeeIdGenerator.nextId("EMP");
    }

    static int currentCount() {
        return EmployeeIdGenerator.currentCount();
    }

    static void reset() {
        EmployeeIdGenerator.resetForTests();
    }
}
