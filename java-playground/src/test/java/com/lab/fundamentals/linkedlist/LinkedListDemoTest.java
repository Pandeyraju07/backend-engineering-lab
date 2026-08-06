package com.lab.fundamentals.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListDemoTest {

    @Test
    void queueOffersAndPollsApprovalChainFifo() {
        Queue<ApprovalStep> queue = LinkedListQueueDemo.buildApprovalQueue(
                new ApprovalStep("S1", "Manager", "Asha", 1),
                new ApprovalStep("S2", "HR", "Ravi", 2)
        );

        assertEquals(2, LinkedListQueueDemo.pendingCount(queue));
        assertEquals("S1", LinkedListQueueDemo.pollStep(queue).stepId());
        assertEquals(List.of("S2"), LinkedListQueueDemo.processApprovals(queue));
        assertEquals(0, LinkedListQueueDemo.pendingCount(queue));
    }

    @Test
    void dequeOpsAddFirstLastAndRemove() {
        LinkedList<ApprovalStep> chain = new LinkedList<>();
        LinkedListDequeOpsDemo.addLast(chain, new ApprovalStep("S1", "Manager", "Asha", 1));
        LinkedListDequeOpsDemo.addLast(chain, new ApprovalStep("S2", "HR", "Ravi", 2));
        LinkedListDequeOpsDemo.addFirst(chain, new ApprovalStep("S0", "Director", "Kiran", 0));

        assertEquals(List.of("S0", "S1", "S2"), LinkedListDequeOpsDemo.stepIds(chain));
        assertTrue(LinkedListDequeOpsDemo.removeByRole(chain, "HR"));
        assertEquals(List.of("S0", "S1"), LinkedListDequeOpsDemo.stepIds(chain));
        assertEquals("S0", LinkedListDequeOpsDemo.removeFirst(chain).stepId());
    }

    @Test
    void approvalChainIntegratesQueueAndDequeOps() {
        LinkedListDemo.ApprovalChainResult result = LinkedListDemo.runApprovalChain(
                new ApprovalStep("S1", "Manager", "Asha", 1),
                new ApprovalStep("S2", "HR", "Ravi", 2),
                new ApprovalStep("S3", "Finance", "Meera", 3)
        );

        assertEquals(List.of("S0", "S1", "S3"), result.orderedStepIds());
        assertTrue(result.skippedHrReview());
        assertEquals(List.of("S0", "S1", "S3"), result.completedStepIds());
        assertEquals(0, result.remaining());
    }
}
