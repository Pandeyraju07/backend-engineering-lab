package com.lab.fundamentals.loops;

import java.util.ArrayDeque;
import java.util.Queue;

/** for loop — paginated batch processing (common in HRMS / payment APIs). */
public class ForLoopDemo {

    private static final int BATCH_SIZE = 25;

    public static void main(String[] args) {
        PayrollRecord[] employees = buildSamplePayroll(100);
        int processed = processPayrollInBatches(employees, BATCH_SIZE);
        System.out.println("For loop: processed " + processed + " payroll records in batches of " + BATCH_SIZE);
    }

    static int processPayrollInBatches(PayrollRecord[] employees, int batchSize) {
        int total = employees.length;
        int processed = 0;
        int batchCount = (total + batchSize - 1) / batchSize;

        for (int batch = 0; batch < batchCount; batch++) {
            int start = batch * batchSize;
            int end = Math.min(start + batchSize, total);

            for (int i = start; i < end; i++) {
                processed += disburse(employees[i]) ? 1 : 0;
            }
        }
        return processed;
    }

    private static boolean disburse(PayrollRecord record) {
        return record.netSalary() > 0;
    }

    static PayrollRecord[] buildSamplePayroll(int count) {
        PayrollRecord[] records = new PayrollRecord[count];
        for (int i = 0; i < count; i++) {
            records[i] = new PayrollRecord(
                    "EMP-" + (i + 1),
                    "Employee-" + (i + 1),
                    80_000 + (i * 100),
                    new double[]{5_000, 1_200, 800}
            );
        }
        return records;
    }
}
