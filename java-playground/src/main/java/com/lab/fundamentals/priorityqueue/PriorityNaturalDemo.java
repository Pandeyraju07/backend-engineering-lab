package com.lab.fundamentals.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/** PriorityQueue natural order — urgent leave (lower priority number) is served first. */
public class PriorityNaturalDemo {

    public static void main(String[] args) {
        PriorityQueue<LeaveRequest> queue = buildNaturalQueue(
                new LeaveRequest(3, "LR-3", "EMP-3", "Casual"),
                new LeaveRequest(1, "LR-1", "EMP-1", "Medical"),
                new LeaveRequest(2, "LR-2", "EMP-2", "Personal")
        );
        System.out.println("Natural drain: " + drainIds(queue));
    }

    static PriorityQueue<LeaveRequest> buildNaturalQueue(LeaveRequest... requests) {
        PriorityQueue<LeaveRequest> queue = new PriorityQueue<>();
        for (LeaveRequest request : requests) {
            queue.offer(request);
        }
        return queue;
    }

    static LeaveRequest pollNext(PriorityQueue<LeaveRequest> queue) {
        return queue.poll();
    }

    static LeaveRequest peekNext(PriorityQueue<LeaveRequest> queue) {
        return queue.peek();
    }

    static List<String> drainIds(PriorityQueue<LeaveRequest> queue) {
        List<String> ids = new ArrayList<>();
        LeaveRequest next;
        while ((next = pollNext(queue)) != null) {
            ids.add(next.id());
        }
        return ids;
    }
}
