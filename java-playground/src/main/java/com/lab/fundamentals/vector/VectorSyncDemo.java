package com.lab.fundamentals.vector;

import java.util.Vector;

/** Vector as a legacy synchronized list — add/get payroll batch items. */
public class VectorSyncDemo {

    public static void main(String[] args) {
        Vector<PayrollBatchItem> batch = buildBatch(
                new PayrollBatchItem("EMP-1", "Asha", 70_000, "BNK-100"),
                new PayrollBatchItem("EMP-2", "Ravi", 65_000, "BNK-200")
        );
        System.out.println("Batch size: " + batch.size());
        System.out.println("First: " + getItem(batch, 0));
        System.out.println("Total: " + totalNetPay(batch));
    }

    static Vector<PayrollBatchItem> buildBatch(PayrollBatchItem... items) {
        Vector<PayrollBatchItem> batch = new Vector<>();
        for (PayrollBatchItem item : items) {
            addItem(batch, item);
        }
        return batch;
    }

    static boolean addItem(Vector<PayrollBatchItem> batch, PayrollBatchItem item) {
        return batch.add(item);
    }

    static PayrollBatchItem getItem(Vector<PayrollBatchItem> batch, int index) {
        return batch.get(index);
    }

    static double totalNetPay(Vector<PayrollBatchItem> batch) {
        double total = 0;
        for (int i = 0; i < batch.size(); i++) {
            total += getItem(batch, i).netPay();
        }
        return total;
    }
}
