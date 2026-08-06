package com.lab.fundamentals.polymorphism;

/**
 * Upcasting — subclass instances treated as Employee; virtual calls still hit overrides.
 */
public class UpcastingDemo {

    public static void main(String[] args) {
        PermanentEmployee permanent = new PermanentEmployee(
                "EMP-501", "Kavita Nair", "HR", 80_000, 9_000);
        Employee upcast = permanent;
        System.out.println(describe(upcast));
    }

    /** Accepts any Employee reference (upcast) and describes pay + type. */
    static String describe(Employee employee) {
        return "%s|%s|%.2f".formatted(
                employee.employeeId(),
                employee.employmentType(),
                employee.calculatePay()
        );
    }

    static Employee upcastPermanent(PermanentEmployee permanent) {
        return permanent;
    }

    static Employee upcastContract(ContractEmployee contract) {
        return contract;
    }
}
