package com.lab.fundamentals.loops;

/** Employee payroll snapshot for batch disbursement. */
record PayrollRecord(String employeeId, String name, double grossSalary, double[] deductions) {

    double netSalary() {
        double totalDeductions = 0;
        for (double deduction : deductions) {
            totalDeductions += deduction;
        }
        return grossSalary - totalDeductions;
    }
}
