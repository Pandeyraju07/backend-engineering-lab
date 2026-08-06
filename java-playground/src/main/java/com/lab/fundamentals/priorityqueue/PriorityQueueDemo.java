package com.lab.fundamentals.priorityqueue;

import java.util.List;
import java.util.PriorityQueue;

/**
 * HRMS urgent leave desk — natural PriorityQueue order plus custom Comparator in one flow.
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityLeaveResult result = runUrgentLeaveDesk(
                new LeaveRequest(3, "LR-3", "EMP-3", "Casual"),
                new LeaveRequest(1, "LR-1", "EMP-2", "Medical"),
                new LeaveRequest(2, "LR-2", "EMP-1", "Personal"),
                new LeaveRequest(1, "LR-4", "EMP-1", "Bereavement")
        );
        System.out.println(result);
    }

    static PriorityLeaveResult runUrgentLeaveDesk(LeaveRequest... requests) {
        PriorityQueue<LeaveRequest> natural = PriorityNaturalDemo.buildNaturalQueue(requests);
        LeaveRequest mostUrgent = PriorityNaturalDemo.peekNext(natural);
        String firstUrgentId = mostUrgent == null ? null : mostUrgent.id();
        List<String> naturalOrder = PriorityNaturalDemo.drainIds(natural);

        PriorityQueue<LeaveRequest> custom = PriorityCustomDemo.buildCustomQueue(requests);
        List<String> customOrder = PriorityCustomDemo.drainIds(custom);

        return new PriorityLeaveResult(
                firstUrgentId,
                naturalOrder,
                customOrder,
                natural.size()
        );
    }

    record PriorityLeaveResult(
            String firstUrgentId,
            List<String> naturalProcessingOrder,
            List<String> customProcessingOrder,
            int remaining
    ) {
        @Override
        public String toString() {
            return "PriorityLeave{firstUrgent=%s, natural=%s, custom=%s, remaining=%d}"
                    .formatted(firstUrgentId, naturalProcessingOrder, customProcessingOrder, remaining);
        }
    }
}
