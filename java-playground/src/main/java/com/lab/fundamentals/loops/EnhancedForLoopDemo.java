package com.lab.fundamentals.loops;

/** enhanced for loop — aggregate salary components without index overhead. */
public class EnhancedForLoopDemo {

    public static void main(String[] args) {
        PayrollRecord record = new PayrollRecord(
                "EMP-500",
                "Raju Kumar",
                95_000,
                new double[]{8_000, 2_500, 1_500, 750, 250}
        );

        double totalDeductions = sumDeductions(record.deductions());
        double netPay = record.grossSalary() - totalDeductions;

        System.out.printf("Enhanced for: %s gross=%.2f deductions=%.2f net=%.2f%n",
                record.name(), record.grossSalary(), totalDeductions, netPay);
    }

    static double sumDeductions(double[] deductions) {
        double total = 0;
        for (double deduction : deductions) {
            if (deduction > 0) {
                total += deduction;
            }
        }
        return total;
    }

    static double maxDeduction(double[] deductions) {
        if (deductions.length == 0) {
            return 0;
        }
        double max = deductions[0];
        for (int i = 1; i < deductions.length; i++) {
            if (deductions[i] > max) {
                max = deductions[i];
            }
        }
        return max;
    }
}
