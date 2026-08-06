package com.lab.fundamentals.statickeyword;

/**
 * Shared HRMS employee-id sequence — static state used across static demos.
 */
class EmployeeIdGenerator {

    private static int nextSequence = 1;

    private EmployeeIdGenerator() {
    }

    static synchronized String nextId(String prefix) {
        String id = prefix + "-" + String.format("%04d", nextSequence);
        nextSequence++;
        return id;
    }

    static synchronized int currentCount() {
        return nextSequence - 1;
    }

    static synchronized void resetForTests() {
        nextSequence = 1;
    }
}
