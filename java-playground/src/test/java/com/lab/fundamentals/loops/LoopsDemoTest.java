package com.lab.fundamentals.loops;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class LoopsDemoTest {

    @Test
    void forLoopProcessesAllEmployeesInBatches() {
        PayrollRecord[] employees = ForLoopDemo.buildSamplePayroll(100);
        assertEquals(100, ForLoopDemo.processPayrollInBatches(employees, 25));
    }

    @Test
    void whileLoopDrainsRetryQueue() {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("PAY-OK-1");
        queue.add("PAY-OK-2");

        int recovered = WhileLoopDemo.retryFailedPayments(queue);
        assertTrue(recovered >= 0);
        assertTrue(queue.isEmpty());
    }

    @Test
    void doWhileValidatesValidAccount() {
        assertTrue(DoWhileLoopDemo.validateBankAccount("ACCT-OK-7788"));
    }

    @Test
    void enhancedForSumsDeductions() {
        double[] deductions = {1000, 500, 250};
        assertEquals(1750, EnhancedForLoopDemo.sumDeductions(deductions));
    }

    @Test
    void payrollRunCompletesWithAllLoopTypes() {
        PayrollRecord[] employees = ForLoopDemo.buildSamplePayroll(10);
        LoopsDemo.PayrollRunResult result = LoopsDemo.runMonthlyPayroll(employees);

        assertEquals(10, result.successCount() + result.failedCount());
        assertTrue(result.totalDisbursed() > 0);
    }
}
