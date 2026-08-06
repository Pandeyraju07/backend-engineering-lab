package com.lab.fundamentals.accessmodifiers;

/**
 * Package-private (default) HRMS employee — visible only inside this package.
 */
class PackageEmployee {

    String employeeId;
    String department;
    protected double basePay;

    PackageEmployee(String employeeId, String department, double basePay) {
        this.employeeId = employeeId;
        this.department = department;
        this.basePay = basePay;
    }

    String summary() {
        return employeeId + "@" + department;
    }

    @Override
    public String toString() {
        return "PackageEmployee{id='%s', dept='%s', basePay=%.2f}"
                .formatted(employeeId, department, basePay);
    }
}
