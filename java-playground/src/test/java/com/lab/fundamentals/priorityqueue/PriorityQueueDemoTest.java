package com.lab.fundamentals.priorityqueue;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueDemoTest {

    @Test
    void naturalOrderServesLowestPriorityNumberFirst() {
        PriorityQueue<LeaveRequest> queue = PriorityNaturalDemo.buildNaturalQueue(
                new LeaveRequest(3, "LR-3", "EMP-3", "Casual"),
                new LeaveRequest(1, "LR-1", "EMP-1", "Medical"),
                new LeaveRequest(2, "LR-2", "EMP-2", "Personal")
        );

        assertEquals("LR-1", PriorityNaturalDemo.peekNext(queue).id());
        assertEquals(List.of("LR-1", "LR-2", "LR-3"), PriorityNaturalDemo.drainIds(queue));
    }

    @Test
    void customComparatorOrdersByEmployeeThenUrgency() {
        PriorityQueue<LeaveRequest> queue = PriorityCustomDemo.buildCustomQueue(
                new LeaveRequest(1, "LR-B", "EMP-2", "Medical"),
                new LeaveRequest(2, "LR-A", "EMP-1", "Casual"),
                new LeaveRequest(1, "LR-C", "EMP-1", "Personal")
        );

        assertEquals(List.of("LR-C", "LR-A", "LR-B"), PriorityCustomDemo.drainIds(queue));
    }

    @Test
    void urgentLeaveDeskIntegratesNaturalAndCustomOrders() {
        PriorityQueueDemo.PriorityLeaveResult result = PriorityQueueDemo.runUrgentLeaveDesk(
                new LeaveRequest(3, "LR-3", "EMP-3", "Casual"),
                new LeaveRequest(1, "LR-1", "EMP-2", "Medical"),
                new LeaveRequest(2, "LR-2", "EMP-1", "Personal"),
                new LeaveRequest(1, "LR-4", "EMP-1", "Bereavement")
        );

        assertEquals("LR-1", result.firstUrgentId());
        assertEquals(List.of("LR-1", "LR-4", "LR-2", "LR-3"), result.naturalProcessingOrder());
        assertEquals(List.of("LR-4", "LR-2", "LR-1", "LR-3"), result.customProcessingOrder());
        assertEquals(0, result.remaining());
    }
}
