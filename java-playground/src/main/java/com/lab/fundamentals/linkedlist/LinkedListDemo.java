package com.lab.fundamentals.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * HRMS approval chain — uses LinkedList queue and deque ops in one leave workflow.
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        ApprovalChainResult result = runApprovalChain(
                new ApprovalStep("S1", "Manager", "Asha", 1),
                new ApprovalStep("S2", "HR", "Ravi", 2),
                new ApprovalStep("S3", "Finance", "Meera", 3)
        );
        System.out.println(result);
    }

    static ApprovalChainResult runApprovalChain(ApprovalStep... steps) {
        LinkedList<ApprovalStep> workingChain = new LinkedList<>();
        for (ApprovalStep step : steps) {
            LinkedListDequeOpsDemo.addLast(workingChain, step);
        }

        LinkedListDequeOpsDemo.addFirst(
                workingChain,
                new ApprovalStep("S0", "Director", "Kiran", 0)
        );
        boolean skippedHr = LinkedListDequeOpsDemo.removeByRole(workingChain, "HR");
        List<String> orderedIds = LinkedListDequeOpsDemo.stepIds(workingChain);

        Queue<ApprovalStep> processQueue = LinkedListQueueDemo.buildApprovalQueue(
                workingChain.toArray(ApprovalStep[]::new)
        );
        List<String> completed = LinkedListQueueDemo.processApprovals(processQueue);

        return new ApprovalChainResult(
                orderedIds,
                skippedHr,
                completed,
                LinkedListQueueDemo.pendingCount(processQueue)
        );
    }

    record ApprovalChainResult(
            List<String> orderedStepIds,
            boolean skippedHrReview,
            List<String> completedStepIds,
            int remaining
    ) {
        @Override
        public String toString() {
            return "ApprovalChain{order=%s, skippedHr=%s, completed=%s, remaining=%d}"
                    .formatted(orderedStepIds, skippedHrReview, completedStepIds, remaining);
        }
    }
}
