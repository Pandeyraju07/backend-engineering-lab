package com.lab.fundamentals.classes;

/** Class structure — create an employee and call instance methods (HRMS hire flow). */
public class ClassStructureDemo {

    public static void main(String[] args) {
        Employee employee = createSample();
        employee.activate();
        employee.applyRaise(0.05);
        employee.transferTo("Backend Engineering");

        System.out.println("Class structure: " + employee);
    }

    static Employee createSample() {
        return new Employee("EMP-301", "Raju Kumar", "Engineering", 75_000);
    }

    static Employee hire(String employeeId, String name, String department, double salary) {
        Employee employee = new Employee(employeeId, name, department, salary);
        employee.activate();
        return employee;
    }
}
