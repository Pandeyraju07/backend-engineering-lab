package com.lab.fundamentals.methods;

/** Instance methods — operate on object state (HRMS employee lifecycle). */
public class InstanceMethodDemo {

    public static void main(String[] args) {
        Employee employee = new Employee("EMP-101", "Raju Kumar", "Engineering", 75_000);

        employee.activate();
        employee.promote(5_000);
        employee.transferTo("Backend Engineering");

        System.out.println("Instance methods: " + employee);
    }
}
