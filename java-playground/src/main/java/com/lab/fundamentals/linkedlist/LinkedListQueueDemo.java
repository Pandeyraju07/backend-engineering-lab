package com.lab.fundamentals.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** LinkedList as Queue — offer/poll an HR leave/payroll approval chain. */
public class LinkedListQueueDemo {

    public static void main(String[] args) {
        Queue<ApprovalStep> chain = buildApprovalQueue(
                new ApprovalStep("S1", "Manager", "Asha", 1),
                new ApprovalStep("S2", "HR", "Ravi", 2),
                new ApprovalStep("S3", "Finance", "Meera", 3)
        );
        System.out.println("Pending: " + chain.size());
        System.out.println("Processed: " + processApprovals(chain));
        System.out.println("Remaining: " + chain.size());
    }

    static Queue<ApprovalStep> buildApprovalQueue(ApprovalStep... steps) {
        Queue<ApprovalStep> queue = new LinkedList<>();
        for (ApprovalStep step : steps) {
            offerStep(queue, step);
        }
        return queue;
    }

    static boolean offerStep(Queue<ApprovalStep> queue, ApprovalStep step) {
        return queue.offer(step);
    }

    static ApprovalStep pollStep(Queue<ApprovalStep> queue) {
        return queue.poll();
    }

    /** Drains the queue in FIFO order and returns completed step ids. */
    static List<String> processApprovals(Queue<ApprovalStep> queue) {
        List<String> completed = new ArrayList<>();
        ApprovalStep next;
        while ((next = pollStep(queue)) != null) {
            completed.add(next.stepId());
        }
        return completed;
    }

    static int pendingCount(Queue<ApprovalStep> queue) {
        return queue.size();
    }
}
