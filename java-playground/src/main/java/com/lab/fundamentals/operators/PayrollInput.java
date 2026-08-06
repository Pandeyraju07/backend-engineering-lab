package com.lab.fundamentals.operators;

/** Inputs for HRMS payroll eligibility and net-pay calculations. */
record PayrollInput(
        double grossSalary,
        double taxRate,
        int yearsOfService,
        boolean hasPendingLeave,
        int flags
) {
}
