package com.lab.fundamentals.loops;

/** do-while loop — validate bank account; at least one verification attempt is always required. */
public class DoWhileLoopDemo {

    private static final int MAX_VALIDATION_ATTEMPTS = 5;

    public static void main(String[] args) {
        String[] invalidAccounts = {"INVALID", "BAD-001", "ACCT-OK-7788"};

        for (String account : invalidAccounts) {
            boolean valid = validateBankAccount(account);
            System.out.println("Do-while: account " + account + " valid = " + valid);
        }
    }

    static boolean validateBankAccount(String accountNumber) {
        int attempt = 0;
        boolean isValid;

        do {
            attempt++;
            isValid = verifyWithBankGateway(accountNumber, attempt);
        } while (!isValid && attempt < MAX_VALIDATION_ATTEMPTS);

        return isValid;
    }

    private static boolean verifyWithBankGateway(String accountNumber, int attempt) {
        return accountNumber.startsWith("ACCT-") && attempt >= 1;
    }
}
