package com.lab.fundamentals.deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/** ArrayDeque as queue — offer/poll recent HR notifications in FIFO order. */
public class ArrayDequeQueueDemo {

    public static void main(String[] args) {
        Deque<String> recent = newRecentQueue();
        offerRecent(recent, "Payslip ready EMP-1");
        offerRecent(recent, "Leave approved EMP-2");
        System.out.println("First: " + pollRecent(recent));
        System.out.println("Remaining: " + drainRecent(recent));
    }

    static Deque<String> newRecentQueue() {
        return new ArrayDeque<>();
    }

    static boolean offerRecent(Deque<String> recent, String message) {
        return recent.offer(message);
    }

    static String pollRecent(Deque<String> recent) {
        return recent.poll();
    }

    static String peekRecent(Deque<String> recent) {
        return recent.peek();
    }

    static List<String> drainRecent(Deque<String> recent) {
        List<String> messages = new ArrayList<>();
        String next;
        while ((next = pollRecent(recent)) != null) {
            messages.add(next);
        }
        return messages;
    }

    static int size(Deque<String> recent) {
        return recent.size();
    }
}
