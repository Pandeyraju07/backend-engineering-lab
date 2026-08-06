package com.lab.fundamentals.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Queue offer/poll — LinkedList and ArrayDeque as FIFO onboarding queues. */
public class QueueOfferPollDemo {

    public static void main(String[] args) {
        Queue<OnboardingTicket> linked = asLinkedQueue(
                new OnboardingTicket("T-1", "Asha", "Engineering"),
                new OnboardingTicket("T-2", "Ravi", "People Ops")
        );
        System.out.println("LinkedList first poll: " + pollNext(linked));
        System.out.println("ArrayDeque order: " + drainIds(asArrayDequeQueue(
                new OnboardingTicket("T-3", "Meera", "Finance"),
                new OnboardingTicket("T-4", "Kiran", "Engineering")
        )));
    }

    static Queue<OnboardingTicket> asLinkedQueue(OnboardingTicket... tickets) {
        Queue<OnboardingTicket> queue = new LinkedList<>();
        for (OnboardingTicket ticket : tickets) {
            offer(queue, ticket);
        }
        return queue;
    }

    static Queue<OnboardingTicket> asArrayDequeQueue(OnboardingTicket... tickets) {
        Queue<OnboardingTicket> queue = new ArrayDeque<>();
        for (OnboardingTicket ticket : tickets) {
            offer(queue, ticket);
        }
        return queue;
    }

    static boolean offer(Queue<OnboardingTicket> queue, OnboardingTicket ticket) {
        return queue.offer(ticket);
    }

    static OnboardingTicket pollNext(Queue<OnboardingTicket> queue) {
        return queue.poll();
    }

    static List<String> drainIds(Queue<OnboardingTicket> queue) {
        List<String> ids = new LinkedList<>();
        OnboardingTicket next;
        while ((next = pollNext(queue)) != null) {
            ids.add(next.ticketId());
        }
        return ids;
    }

    static int size(Queue<OnboardingTicket> queue) {
        return queue.size();
    }
}
