package com.lab.fundamentals.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * PriorityQueue custom Comparator — employeeId ascending, then priority for HR desk sorting.
 */
public class PriorityCustomDemo {

    /** Prefer earlier employee ids; break ties with urgency (lower priority first). */
    static final Comparator<LeaveRequest> BY_EMPLOYEE_THEN_URGENCY =
            Comparator.comparing(LeaveRequest::employeeId)
                    .thenComparingInt(LeaveRequest::priority)
                    .thenComparing(LeaveRequest::id);

    public static void main(String[] args) {
        PriorityQueue<LeaveRequest> queue = buildCustomQueue(
                new LeaveRequest(1, "LR-B", "EMP-2", "Medical"),
                new LeaveRequest(2, "LR-A", "EMP-1", "Casual"),
                new LeaveRequest(1, "LR-C", "EMP-1", "Personal")
        );
        System.out.println("Custom drain: " + drainIds(queue));
    }

    static PriorityQueue<LeaveRequest> buildCustomQueue(LeaveRequest... requests) {
        PriorityQueue<LeaveRequest> queue = new PriorityQueue<>(BY_EMPLOYEE_THEN_URGENCY);
        for (LeaveRequest request : requests) {
            queue.offer(request);
        }
        return queue;
    }

    static List<String> drainIds(PriorityQueue<LeaveRequest> queue) {
        List<String> ids = new ArrayList<>();
        LeaveRequest next;
        while ((next = queue.poll()) != null) {
            ids.add(next.id());
        }
        return ids;
    }

    static LeaveRequest pollNext(PriorityQueue<LeaveRequest> queue) {
        return queue.poll();
    }
}
