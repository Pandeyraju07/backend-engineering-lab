package com.lab.fundamentals.encapsulation;

/**
 * Encapsulated HRMS salary account — private state with validated getters/setters.
 */
class BankSalaryAccount {

    private String accountId;
    private String employeeName;
    private double salary;
    private boolean active;

    BankSalaryAccount(String accountId, String employeeName, double salary) {
        setAccountId(accountId);
        setEmployeeName(employeeName);
        setSalary(salary);
        this.active = true;
    }

    String getAccountId() {
        return accountId;
    }

    void setAccountId(String accountId) {
        if (accountId == null || accountId.isBlank()) {
            throw new IllegalArgumentException("account id cannot be blank");
        }
        this.accountId = accountId.trim();
    }

    String getEmployeeName() {
        return employeeName;
    }

    void setEmployeeName(String employeeName) {
        if (employeeName == null || employeeName.isBlank()) {
            throw new IllegalArgumentException("employee name cannot be blank");
        }
        this.employeeName = employeeName.trim();
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("salary cannot be negative");
        }
        this.salary = salary;
    }

    boolean isActive() {
        return active;
    }

    void deactivate() {
        this.active = false;
    }

    @Override
    public String toString() {
        return "BankSalaryAccount{id='%s', name='%s', salary=%.2f, active=%b}"
                .formatted(accountId, employeeName, salary, active);
    }
}
