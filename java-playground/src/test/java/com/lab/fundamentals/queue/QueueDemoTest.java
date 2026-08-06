package com.lab.fundamentals.queue;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueDemoTest {

    @Test
    void offerPollIsFifoForLinkedListAndArrayDeque() {
        Queue<OnboardingTicket> linked = QueueOfferPollDemo.asLinkedQueue(
                new OnboardingTicket("T-1", "Asha", "Engineering"),
                new OnboardingTicket("T-2", "Ravi", "People Ops")
        );
        Queue<OnboardingTicket> deque = QueueOfferPollDemo.asArrayDequeQueue(
                new OnboardingTicket("T-1", "Asha", "Engineering"),
                new OnboardingTicket("T-2", "Ravi", "People Ops")
        );

        assertEquals("T-1", QueueOfferPollDemo.pollNext(linked).ticketId());
        assertEquals(List.of("T-1", "T-2"), QueueOfferPollDemo.drainIds(deque));
        assertEquals(1, QueueOfferPollDemo.size(linked));
    }

    @Test
    void peekDoesNotRemoveFrontTicket() {
        Queue<OnboardingTicket> queue = QueueOfferPollDemo.asArrayDequeQueue(
                new OnboardingTicket("T-10", "Neha", "Legal"),
                new OnboardingTicket("T-11", "Arun", "Engineering")
        );

        assertEquals("T-10", QueuePeekDemo.peekTicketId(queue));
        assertTrue(QueuePeekDemo.hasPending(queue));
        assertEquals(2, QueueOfferPollDemo.size(queue));
        assertEquals("T-10", QueueOfferPollDemo.pollNext(queue).ticketId());
    }

    @Test
    void onboardingDeskIntegratesOfferPollAndPeek() {
        QueueDemo.QueueFlowResult result = QueueDemo.runOnboardingDesk(
                new OnboardingTicket("T-1", "Asha", "Engineering"),
                new OnboardingTicket("T-2", "Ravi", "People Ops"),
                new OnboardingTicket("T-3", "Meera", "Finance")
        );

        assertEquals("T-1", result.peekedNextId());
        assertTrue(result.hadPendingBeforePoll());
        assertEquals(List.of("T-1", "T-2", "T-3"), result.processedOrder());
        assertEquals(0, result.remaining());
    }
}
