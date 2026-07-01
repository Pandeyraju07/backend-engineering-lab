package com.lab.fundamentals.loops;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * HRMS payroll run — uses all four loop types in one optimized disbursement flow.
 */
public class LoopsDemo {

    private static final int BATCH_SIZE = 50;
    private static final int MAX_BANK_RETRIES = 4;

    public static void main(String[] args) {
        PayrollRunResult result = runMonthlyPayroll(ForLoopDemo.buildSamplePayroll(120));
        System.out.println(result);
    }

    static PayrollRunResult runMonthlyPayroll(PayrollRecord[] employees) {
        double totalDisbursed = 0;
        int successCount = 0;
        int failedCount = 0;

        Queue<PayrollRecord> retryQueue = new ArrayDeque<>();
        int batchCount = (employees.length + BATCH_SIZE - 1) / BATCH_SIZE;

        for (int batch = 0; batch < batchCount; batch++) {
            int start = batch * BATCH_SIZE;
            int end = Math.min(start + BATCH_SIZE, employees.length);

            for (int i = start; i < end; i++) {
                PayrollRecord employee = employees[i];
                double netPay = employee.netSalary();

                if (netPay <= 0) {
                    failedCount++;
                    continue;
                }

                if (validateAndTransfer(employee)) {
                    totalDisbursed += netPay;
                    successCount++;
                } else {
                    retryQueue.offer(employee);
                }
            }
        }

        while (!retryQueue.isEmpty()) {
            PayrollRecord employee = retryQueue.poll();
            if (validateAndTransfer(employee)) {
                totalDisbursed += employee.netSalary();
                successCount++;
            } else {
                failedCount++;
            }
        }

        return new PayrollRunResult(successCount, failedCount, totalDisbursed);
    }

    private static boolean validateAndTransfer(PayrollRecord employee) {
        int attempt = 0;
        boolean transferred;

        do {
            attempt++;
            transferred = executeBankTransfer(employee, attempt);
        } while (!transferred && attempt < MAX_BANK_RETRIES);

        return transferred;
    }

    private static boolean executeBankTransfer(PayrollRecord employee, int attempt) {
        int accountScore = Math.abs(employee.employeeId().hashCode() + attempt) % 5;
        return accountScore != 0;
    }

    record PayrollRunResult(int successCount, int failedCount, double totalDisbursed) {
        @Override
        public String toString() {
            return "PayrollRun{success=%d, failed=%d, totalDisbursed=%.2f}"
                    .formatted(successCount, failedCount, totalDisbursed);
        }
    }
}
