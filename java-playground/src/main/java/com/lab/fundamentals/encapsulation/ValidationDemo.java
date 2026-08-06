package com.lab.fundamentals.encapsulation;

/** Validation — reject negative salary and blank employee names. */
public class ValidationDemo {

    public static void main(String[] args) {
        boolean negativeRejected = rejectsNegativeSalary();
        boolean blankRejected = rejectsBlankName();
        System.out.println("Validation: negativeRejected=" + negativeRejected
                + ", blankNameRejected=" + blankRejected);
    }

    static boolean rejectsNegativeSalary() {
        try {
            new BankSalaryAccount("ACC-ERR", "Test User", -1);
            return false;
        } catch (IllegalArgumentException ex) {
            return true;
        }
    }

    static boolean rejectsBlankName() {
        try {
            new BankSalaryAccount("ACC-ERR", "   ", 50_000);
            return false;
        } catch (IllegalArgumentException ex) {
            return true;
        }
    }

    static void assertValidUpdate(BankSalaryAccount account, String name, double salary) {
        account.setEmployeeName(name);
        account.setSalary(salary);
    }

    static boolean trySetSalary(BankSalaryAccount account, double salary) {
        try {
            account.setSalary(salary);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    static boolean trySetEmployeeName(BankSalaryAccount account, String name) {
        try {
            account.setEmployeeName(name);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
