package com.lab.fundamentals.methods;

/** Pass by value — Java always passes copies of values (primitives and references). */
public class PassByValueDemo {

    public static void main(String[] args) {
        int age = 28;
        updateAge(age);
        System.out.println("After updateAge (primitive): age=" + age);

        Employee employee = new Employee("EMP-301", "Bob", "Finance", 60_000);
        tryReassignEmployee(employee);
        System.out.println("After tryReassign (reference): " + employee);

        applyPromotion(employee, 4_000);
        System.out.println("After applyPromotion (mutate object): " + employee);
    }

    static void updateAge(int age) {
        age = 35;
    }

    static void tryReassignEmployee(Employee employee) {
        employee = new Employee("EMP-999", "Temp", "HR", 50_000);
    }

    static void applyPromotion(Employee employee, double increment) {
        employee.promote(increment);
    }
}
