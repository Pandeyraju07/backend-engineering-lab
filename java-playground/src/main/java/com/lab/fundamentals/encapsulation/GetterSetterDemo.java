package com.lab.fundamentals.encapsulation;

/** Getters and setters — update salary safely through encapsulated accessors. */
public class GetterSetterDemo {

    public static void main(String[] args) {
        BankSalaryAccount account = openAccount("ACC-1001", "Raju Kumar", 80_000);
        double updated = applyRaise(account, 5_000);
        System.out.println("Getter/setter: " + account + ", raisedTo=" + updated);
    }

    static BankSalaryAccount openAccount(String accountId, String employeeName, double salary) {
        return new BankSalaryAccount(accountId, employeeName, salary);
    }

    static double applyRaise(BankSalaryAccount account, double increment) {
        if (increment <= 0) {
            return account.getSalary();
        }
        account.setSalary(account.getSalary() + increment);
        return account.getSalary();
    }

    static String displayNameAndSalary(BankSalaryAccount account) {
        return account.getEmployeeName() + "=" + account.getSalary();
    }
}
