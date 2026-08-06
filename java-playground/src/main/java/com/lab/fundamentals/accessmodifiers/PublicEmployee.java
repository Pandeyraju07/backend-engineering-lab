package com.lab.fundamentals.accessmodifiers;

/**
 * Public HRMS employee type — salary is private and only exposed via a getter.
 */
public class PublicEmployee {

    public final String employeeId;
    public String name;
    private double salary;

    public PublicEmployee(String employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    /** Package-private mutator used by demos in the same package. */
    void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PublicEmployee{id='%s', name='%s', salary=%.2f}"
                .formatted(employeeId, name, salary);
    }
}
