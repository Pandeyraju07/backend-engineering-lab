package com.lab.fundamentals.objects;

/** Object creation — `new` instances for HRMS staff records. */
public class ObjectCreationDemo {

    public static void main(String[] args) {
        StaffMember member = create("EMP-501", "Raju Kumar");
        System.out.println("Object creation: " + member);
    }

    static StaffMember create(String id, String name) {
        return new StaffMember(id, name);
    }
}
