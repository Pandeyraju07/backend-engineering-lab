package com.lab.fundamentals.vector;

import java.util.List;
import java.util.Vector;

/**
 * HRMS payroll batch — uses synchronized Vector add/get and legacy Enumeration in one flow.
 */
public class VectorDemo {

    public static void main(String[] args) {
        VectorBatchResult result = runPayrollBatch(
                new PayrollBatchItem("EMP-1", "Asha", 70_000, "BNK-100"),
                new PayrollBatchItem("EMP-2", "Ravi", 65_000, "BNK-200"),
                new PayrollBatchItem("EMP-3", "Meera", 72_000, "BNK-300")
        );
        System.out.println(result);
    }

    static VectorBatchResult runPayrollBatch(PayrollBatchItem... items) {
        Vector<PayrollBatchItem> batch = VectorLegacyDemo.withInitialCapacity(items.length);
        for (PayrollBatchItem item : items) {
            VectorSyncDemo.addItem(batch, item);
        }

        PayrollBatchItem first = VectorSyncDemo.getItem(batch, 0);
        List<String> bankRefs = VectorLegacyDemo.bankRefsViaEnumeration(batch);
        List<String> employeeIds = VectorLegacyDemo.employeeIds(batch);
        double total = VectorSyncDemo.totalNetPay(batch);

        return new VectorBatchResult(
                batch.size(),
                first.employeeId(),
                bankRefs,
                employeeIds,
                total,
                VectorLegacyDemo.capacityOf(batch)
        );
    }

    record VectorBatchResult(
            int itemCount,
            String firstEmployeeId,
            List<String> bankRefs,
            List<String> employeeIds,
            double totalNetPay,
            int capacity
    ) {
        @Override
        public String toString() {
            return "VectorBatch{items=%d, first=%s, bankRefs=%s, ids=%s, total=%.2f, capacity=%d}"
                    .formatted(itemCount, firstEmployeeId, bankRefs, employeeIds, totalNetPay, capacity);
        }
    }
}
