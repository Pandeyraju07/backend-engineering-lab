package com.lab.fundamentals.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;

/** Consumer + Supplier — audit-log employees and mint new HRMS ids. */
public class ConsumerSupplierDemo {

    private static final AtomicInteger NEXT_ID = new AtomicInteger(100);

    public static void main(String[] args) {
        List<String> audit = new ArrayList<>();
        Employee asha = new Employee("E001", "Asha", "Engineering", "asha@hrms.lab", 95_000, true);
        logEmployee(audit).accept(asha);
        System.out.println("Audit: " + audit);
        System.out.println("New id: " + newId().get());
    }

    static Consumer<Employee> logEmployee(List<String> auditLog) {
        return employee -> {
            if (auditLog == null || employee == null) {
                return;
            }
            auditLog.add("LOG %s | %s | %.2f".formatted(
                    employee.id(), employee.name(), employee.salary()));
        };
    }

    static void acceptAll(List<Employee> roster, Consumer<Employee> consumer) {
        if (roster == null || consumer == null) {
            return;
        }
        for (Employee employee : roster) {
            consumer.accept(employee);
        }
    }

    static Supplier<String> newId() {
        return () -> "E" + NEXT_ID.getAndIncrement();
    }

    static Supplier<Employee> newHire(String name, String department, double salary) {
        return () -> {
            String id = newId().get();
            String email = FunctionDemo.corporateEmailFromName().apply(name);
            return new Employee(id, name, department, email, salary, true);
        };
    }

    /** Test helper — reset id sequence for deterministic assertions. */
    static void resetIdSequence(int start) {
        NEXT_ID.set(start);
    }
}
