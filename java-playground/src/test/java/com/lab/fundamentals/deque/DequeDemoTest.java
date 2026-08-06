package com.lab.fundamentals.deque;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DequeDemoTest {

    @Test
    void stackModePushPopIsLifoForUndo() {
        Deque<String> undo = ArrayDequeStackDemo.newUndoStack();
        ArrayDequeStackDemo.pushAction(undo, "UPDATE_SALARY:EMP-1");
        ArrayDequeStackDemo.pushAction(undo, "APPROVE_LEAVE:LR-9");

        assertEquals("APPROVE_LEAVE:LR-9", ArrayDequeStackDemo.popUndo(undo));
        assertEquals("UPDATE_SALARY:EMP-1", ArrayDequeStackDemo.peekUndo(undo));
        assertEquals(1, ArrayDequeStackDemo.depth(undo));
    }

    @Test
    void queueModeOfferPollIsFifoForRecent() {
        Deque<String> recent = ArrayDequeQueueDemo.newRecentQueue();
        ArrayDequeQueueDemo.offerRecent(recent, "Payslip ready EMP-1");
        ArrayDequeQueueDemo.offerRecent(recent, "Leave approved EMP-2");

        assertEquals("Payslip ready EMP-1", ArrayDequeQueueDemo.peekRecent(recent));
        assertEquals("Payslip ready EMP-1", ArrayDequeQueueDemo.pollRecent(recent));
        assertEquals(List.of("Leave approved EMP-2"), ArrayDequeQueueDemo.drainRecent(recent));
    }

    @Test
    void adminConsoleIntegratesUndoStackAndRecentQueue() {
        DequeDemo.DequeFlowResult result = DequeDemo.runAdminConsole(
                List.of("UPDATE_SALARY:EMP-1", "APPROVE_LEAVE:LR-9", "RESET_PASSWORD:EMP-3"),
                List.of("Payslip ready EMP-1", "Leave approved EMP-2", "Badge printed EMP-3")
        );

        assertEquals("RESET_PASSWORD:EMP-3", result.undoneAction());
        assertEquals("APPROVE_LEAVE:LR-9", result.nextUndoPeek());
        assertEquals(2, result.undoDepthAfterPop());
        assertEquals("Payslip ready EMP-1", result.firstRecent());
        assertEquals(List.of("Leave approved EMP-2", "Badge printed EMP-3"), result.remainingRecent());
    }
}
