package com.lab.fundamentals.vector;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class VectorDemoTest {

    @Test
    void syncVectorAddsAndGetsBatchItems() {
        Vector<PayrollBatchItem> batch = VectorSyncDemo.buildBatch(
                new PayrollBatchItem("EMP-1", "Asha", 70_000, "BNK-100"),
                new PayrollBatchItem("EMP-2", "Ravi", 65_000, "BNK-200")
        );

        assertEquals(2, batch.size());
        assertEquals("Asha", VectorSyncDemo.getItem(batch, 0).name());
        assertEquals(135_000, VectorSyncDemo.totalNetPay(batch));
    }

    @Test
    void legacyEnumerationAndCapacityWork() {
        Vector<PayrollBatchItem> batch = VectorLegacyDemo.withInitialCapacity(8);
        VectorSyncDemo.addItem(batch, new PayrollBatchItem("EMP-1", "Asha", 70_000, "BNK-100"));
        VectorSyncDemo.addItem(batch, new PayrollBatchItem("EMP-2", "Ravi", 65_000, "BNK-200"));

        assertEquals(List.of("BNK-100", "BNK-200"), VectorLegacyDemo.bankRefsViaEnumeration(batch));
        assertEquals(List.of("EMP-1", "EMP-2"), VectorLegacyDemo.employeeIds(batch));
        assertTrue(VectorLegacyDemo.capacityOf(batch) >= 8);
    }

    @Test
    void payrollBatchIntegratesSyncAndLegacyApis() {
        VectorDemo.VectorBatchResult result = VectorDemo.runPayrollBatch(
                new PayrollBatchItem("EMP-1", "Asha", 70_000, "BNK-100"),
                new PayrollBatchItem("EMP-2", "Ravi", 65_000, "BNK-200"),
                new PayrollBatchItem("EMP-3", "Meera", 72_000, "BNK-300")
        );

        assertEquals(3, result.itemCount());
        assertEquals("EMP-1", result.firstEmployeeId());
        assertEquals(List.of("BNK-100", "BNK-200", "BNK-300"), result.bankRefs());
        assertEquals(List.of("EMP-1", "EMP-2", "EMP-3"), result.employeeIds());
        assertEquals(207_000, result.totalNetPay());
        assertTrue(result.capacity() >= 3);
    }
}
