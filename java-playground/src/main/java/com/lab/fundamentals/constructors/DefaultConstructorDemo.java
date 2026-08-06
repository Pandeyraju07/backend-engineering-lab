package com.lab.fundamentals.constructors;

/** Default / no-arg constructor path for a placeholder HRMS worker. */
public class DefaultConstructorDemo {

    public static void main(String[] args) {
        Worker worker = createDefaultWorker();
        System.out.println("Default constructor: " + worker);
    }

    /** Creates a worker via the no-arg constructor (internally chains to the full ctor). */
    static Worker createDefaultWorker() {
        return new Worker();
    }

    static boolean isPlaceholder(Worker worker) {
        return worker != null
                && "EMP-0000".equals(worker.employeeId())
                && "Unassigned".equals(worker.name());
    }
}
