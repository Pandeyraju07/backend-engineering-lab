package com.lab.fundamentals.vector;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/** Vector legacy APIs — elements() Enumeration and capacity tracking. */
public class VectorLegacyDemo {

    public static void main(String[] args) {
        Vector<PayrollBatchItem> batch = VectorSyncDemo.buildBatch(
                new PayrollBatchItem("EMP-1", "Asha", 70_000, "BNK-100"),
                new PayrollBatchItem("EMP-2", "Ravi", 65_000, "BNK-200")
        );
        System.out.println("Bank refs: " + bankRefsViaEnumeration(batch));
        System.out.println("Capacity: " + capacityOf(batch));
    }

    /** Walks Vector via legacy Enumeration from elements(). */
    static List<String> bankRefsViaEnumeration(Vector<PayrollBatchItem> batch) {
        List<String> refs = new ArrayList<>();
        Enumeration<PayrollBatchItem> enumeration = batch.elements();
        while (enumeration.hasMoreElements()) {
            refs.add(enumeration.nextElement().bankRef());
        }
        return refs;
    }

    static int capacityOf(Vector<PayrollBatchItem> batch) {
        return batch.capacity();
    }

    static Vector<PayrollBatchItem> withInitialCapacity(int capacity) {
        return new Vector<>(Math.max(capacity, 0));
    }

    static List<String> employeeIds(Vector<PayrollBatchItem> batch) {
        List<String> ids = new ArrayList<>();
        Enumeration<PayrollBatchItem> enumeration = batch.elements();
        while (enumeration.hasMoreElements()) {
            ids.add(enumeration.nextElement().employeeId());
        }
        return ids;
    }
}
