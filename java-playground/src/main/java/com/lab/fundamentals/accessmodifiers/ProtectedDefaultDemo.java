package com.lab.fundamentals.accessmodifiers;

/**
 * protected / default visibility — subclass in the same package reads both.
 */
public class ProtectedDefaultDemo {

    public static void main(String[] args) {
        SubEmployee employee = createSubEmployee("EMP-3002", "Engineering", 70_000, "Engineer");
        System.out.println("Protected/default: " + describe(employee));
    }

    static SubEmployee createSubEmployee(String id, String department, double basePay, String title) {
        return new SubEmployee(id, department, basePay, title);
    }

    static PackageEmployee createPackageEmployee(String id, String department, double basePay) {
        return new PackageEmployee(id, department, basePay);
    }

    static String describe(SubEmployee employee) {
        return employee.summary()
                + "|title=" + employee.title()
                + "|dept=" + employee.packageDepartment()
                + "|basePay=" + employee.protectedBasePay();
    }

    static double grantRaise(SubEmployee employee, double percent) {
        return employee.applyRaise(percent);
    }
}
