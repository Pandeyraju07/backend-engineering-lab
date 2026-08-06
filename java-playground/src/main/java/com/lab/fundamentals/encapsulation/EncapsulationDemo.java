package com.lab.fundamentals.encapsulation;

/**
 * HRMS salary account — getters/setters and validation in one encapsulated flow.
 */
public class EncapsulationDemo {

    public static void main(String[] args) {
        EncapsulatedEmployeeResult result = onboardSalaryAccount(
                "ACC-2001", "Priya Nair", 75_000, 8_000);
        System.out.println(result);
    }

    static EncapsulatedEmployeeResult onboardSalaryAccount(
            String accountId,
            String employeeName,
            double openingSalary,
            double raiseAmount
    ) {
        BankSalaryAccount account = GetterSetterDemo.openAccount(accountId, employeeName, openingSalary);
        double salaryAfterRaise = GetterSetterDemo.applyRaise(account, raiseAmount);

        boolean negativeRejected = ValidationDemo.rejectsNegativeSalary();
        boolean blankRejected = ValidationDemo.rejectsBlankName();
        boolean invalidRaiseBlocked = !ValidationDemo.trySetSalary(account, -500);

        return new EncapsulatedEmployeeResult(
                account.getAccountId(),
                account.getEmployeeName(),
                salaryAfterRaise,
                account.isActive(),
                GetterSetterDemo.displayNameAndSalary(account),
                negativeRejected && blankRejected && invalidRaiseBlocked
        );
    }

    record EncapsulatedEmployeeResult(
            String accountId,
            String employeeName,
            double salary,
            boolean active,
            String display,
            boolean validationEnforced
    ) {
        @Override
        public String toString() {
            return "EncapsulatedEmployeeResult{id=%s, name=%s, salary=%.2f, active=%b, display=%s, validated=%b}"
                    .formatted(accountId, employeeName, salary, active, display, validationEnforced);
        }
    }
}
