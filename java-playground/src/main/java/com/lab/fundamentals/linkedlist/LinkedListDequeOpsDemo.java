package com.lab.fundamentals.linkedlist;

import java.util.LinkedList;
import java.util.List;

/** LinkedList deque ops — escalate urgent approvals to the front of the chain. */
public class LinkedListDequeOpsDemo {

    public static void main(String[] args) {
        LinkedList<ApprovalStep> chain = new LinkedList<>();
        addLast(chain, new ApprovalStep("S1", "Manager", "Asha", 1));
        addLast(chain, new ApprovalStep("S2", "HR", "Ravi", 2));
        addFirst(chain, new ApprovalStep("S0", "Director", "Kiran", 0));
        System.out.println("Order: " + stepIds(chain));
        System.out.println("Removed HR: " + removeByRole(chain, "HR"));
        System.out.println("After remove: " + stepIds(chain));
    }

    static void addFirst(LinkedList<ApprovalStep> chain, ApprovalStep step) {
        chain.addFirst(step);
    }

    static void addLast(LinkedList<ApprovalStep> chain, ApprovalStep step) {
        chain.addLast(step);
    }

    static boolean removeByRole(LinkedList<ApprovalStep> chain, String role) {
        for (ApprovalStep step : chain) {
            if (step.role().equals(role)) {
                return chain.remove(step);
            }
        }
        return false;
    }

    static ApprovalStep removeFirst(LinkedList<ApprovalStep> chain) {
        return chain.isEmpty() ? null : chain.removeFirst();
    }

    static List<String> stepIds(LinkedList<ApprovalStep> chain) {
        List<String> ids = new LinkedList<>();
        for (ApprovalStep step : chain) {
            ids.add(step.stepId());
        }
        return ids;
    }
}
