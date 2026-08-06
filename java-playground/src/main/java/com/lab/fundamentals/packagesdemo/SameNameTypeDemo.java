package com.lab.fundamentals.packagesdemo;

/**
 * Same-name types — use a fully qualified name when simple names collide or need clarity.
 * Here {@link java.util.Date} is referenced by FQCN while our HRMS hire date stays a plain String.
 */
public class SameNameTypeDemo {

    public static void main(String[] args) {
        System.out.println(hireStamp("EMP-402", "2026-04-01"));
    }

    /**
     * Builds a hire stamp using {@code java.util.Date} via fully qualified name
     * (no import), plus the employee id as a simple String.
     */
    static String hireStamp(String employeeId, String isoHireDate) {
        java.util.Date recordedAt = new java.util.Date(0L); // epoch marker for demos
        return "HireStamp{id=%s, hireDate=%s, recordedAtEpochMs=%d}"
                .formatted(employeeId, isoHireDate, recordedAt.getTime());
    }

    static boolean usesFullyQualifiedDate(String stamp) {
        return stamp != null && stamp.contains("recordedAtEpochMs=0");
    }
}
