package com.lab.fundamentals.arraylist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListDemoTest {

    @Test
    void crudBuildsRosterAndRemovesById() {
        List<EmployeeRecord> roster = ArrayListCrudDemo.buildRoster(
                new EmployeeRecord("EMP-1", "Asha", "Engineering", 70_000),
                new EmployeeRecord("EMP-2", "Ravi", "People Ops", 65_000)
        );

        assertEquals(2, roster.size());
        assertEquals("Asha", ArrayListCrudDemo.getByIndex(roster, 0).name());
        assertTrue(ArrayListCrudDemo.removeById(roster, "EMP-2"));
        assertEquals(1, roster.size());
        assertFalse(ArrayListCrudDemo.removeById(roster, "EMP-MISSING"));
    }

    @Test
    void iterationCollectsNamesAcrossStyles() {
        List<EmployeeRecord> roster = ArrayListCrudDemo.buildRoster(
                new EmployeeRecord("EMP-1", "Asha", "Engineering", 70_000),
                new EmployeeRecord("EMP-2", "Ravi", "People Ops", 65_000)
        );

        assertEquals(List.of("Asha", "Ravi"), ArrayListIterationDemo.names(roster));
        assertEquals(List.of("Asha", "Ravi"), ArrayListIterationDemo.namesWithFor(roster));
        assertEquals(List.of("Asha", "Ravi"), ArrayListIterationDemo.namesWithIterator(roster));
        assertEquals(135_000, ArrayListIterationDemo.totalSalary(roster));
    }

    @Test
    void capacityCreatesSizedBufferAndTracksSize() {
        ArrayList<EmployeeRecord> buffer = ArrayListCapacityDemo.sizedList(10);
        assertEquals(0, ArrayListCapacityDemo.sizeOf(buffer));

        ArrayListCapacityDemo.ensureCapacityForIntake(buffer, 20);
        ArrayListCapacityDemo.fillSample(buffer, 3);

        assertEquals(3, ArrayListCapacityDemo.sizeOf(buffer));
        assertEquals("EMP-1", buffer.get(0).employeeId());
    }

    @Test
    void rosterFlowIntegratesCrudIterationAndCapacity() {
        ArrayListDemo.RosterResult result = ArrayListDemo.runRosterFlow(
                new EmployeeRecord("EMP-1", "Asha", "Engineering", 70_000),
                new EmployeeRecord("EMP-2", "Ravi", "People Ops", 65_000),
                new EmployeeRecord("EMP-3", "Meera", "Finance", 72_000)
        );

        assertEquals(2, result.activeCount());
        assertTrue(result.removedTransfer());
        assertEquals(List.of("Asha", "Meera"), result.names());
        assertEquals(142_000, result.totalSalary());
    }
}
