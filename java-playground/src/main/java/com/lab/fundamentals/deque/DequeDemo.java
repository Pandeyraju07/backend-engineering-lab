package com.lab.fundamentals.deque;

import java.util.Deque;
import java.util.List;

/**
 * HRMS admin console — ArrayDeque undo stack plus recent-notification queue in one flow.
 */
public class DequeDemo {

    public static void main(String[] args) {
        DequeFlowResult result = runAdminConsole(
                List.of("UPDATE_SALARY:EMP-1", "APPROVE_LEAVE:LR-9", "RESET_PASSWORD:EMP-3"),
                List.of("Payslip ready EMP-1", "Leave approved EMP-2", "Badge printed EMP-3")
        );
        System.out.println(result);
    }

    static DequeFlowResult runAdminConsole(List<String> actions, List<String> notifications) {
        Deque<String> undo = ArrayDequeStackDemo.newUndoStack();
        for (String action : actions) {
            ArrayDequeStackDemo.pushAction(undo, action);
        }
        String undone = ArrayDequeStackDemo.popUndo(undo);
        String nextUndo = ArrayDequeStackDemo.peekUndo(undo);

        Deque<String> recent = ArrayDequeQueueDemo.newRecentQueue();
        for (String message : notifications) {
            ArrayDequeQueueDemo.offerRecent(recent, message);
        }
        String firstRecent = ArrayDequeQueueDemo.pollRecent(recent);
        List<String> remainingRecent = ArrayDequeQueueDemo.drainRecent(recent);

        return new DequeFlowResult(
                undone,
                nextUndo,
                ArrayDequeStackDemo.depth(undo),
                firstRecent,
                remainingRecent
        );
    }

    record DequeFlowResult(
            String undoneAction,
            String nextUndoPeek,
            int undoDepthAfterPop,
            String firstRecent,
            List<String> remainingRecent
    ) {
        @Override
        public String toString() {
            return "DequeFlow{undone=%s, nextUndo=%s, undoDepth=%d, firstRecent=%s, remainingRecent=%s}"
                    .formatted(undoneAction, nextUndoPeek, undoDepthAfterPop, firstRecent, remainingRecent);
        }
    }
}
