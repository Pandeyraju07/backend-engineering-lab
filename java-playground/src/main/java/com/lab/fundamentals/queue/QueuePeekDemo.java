package com.lab.fundamentals.queue;

import java.util.Queue;

/** Queue peek — inspect the next onboarding ticket without removing it. */
public class QueuePeekDemo {

    public static void main(String[] args) {
        Queue<OnboardingTicket> queue = QueueOfferPollDemo.asArrayDequeQueue(
                new OnboardingTicket("T-10", "Neha", "Legal"),
                new OnboardingTicket("T-11", "Arun", "Engineering")
        );
        System.out.println("Peek: " + peekNext(queue));
        System.out.println("Still size=" + QueueOfferPollDemo.size(queue));
    }

    static OnboardingTicket peekNext(Queue<OnboardingTicket> queue) {
        return queue.peek();
    }

    static String peekTicketId(Queue<OnboardingTicket> queue) {
        OnboardingTicket next = peekNext(queue);
        return next == null ? null : next.ticketId();
    }

    static boolean hasPending(Queue<OnboardingTicket> queue) {
        return peekNext(queue) != null;
    }
}
