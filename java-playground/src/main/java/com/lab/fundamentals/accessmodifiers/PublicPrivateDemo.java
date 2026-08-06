package com.lab.fundamentals.accessmodifiers;

/**
 * public vs private — public fields/methods vs private salary accessed only via getter.
 */
public class PublicPrivateDemo {

    public static void main(String[] args) {
        PublicEmployee employee = createPublicEmployee("EMP-3001", "Raju Kumar", 82_000);
        System.out.println("Public/private: " + describe(employee));
    }

    static PublicEmployee createPublicEmployee(String id, String name, double salary) {
        return new PublicEmployee(id, name, salary);
    }

    /** Reads public id/name and private salary through the public getter. */
    static String describe(PublicEmployee employee) {
        return employee.employeeId + "|" + employee.name + "|salary=" + employee.getSalary();
    }

    static double raiseSalary(PublicEmployee employee, double increment) {
        if (increment <= 0) {
            return employee.getSalary();
        }
        double updated = employee.getSalary() + increment;
        employee.setSalary(updated);
        return employee.getSalary();
    }
}
