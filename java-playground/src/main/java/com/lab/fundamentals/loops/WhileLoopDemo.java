package com.lab.fundamentals.loops;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/** while loop — drain payment retry queue until empty (HRMS disbursement retries). */
public class WhileLoopDemo {

    private static final int MAX_RETRY_ATTEMPTS = 3;

    public static void main(String[] args) {
        Queue<String> failedPayments = new ArrayDeque<>();
        failedPayments.add("PAY-101");
        failedPayments.add("PAY-102");
        failedPayments.add("PAY-103");

        int recovered = retryFailedPayments(failedPayments);
        System.out.println("While loop: recovered " + recovered + " payments, pending: " + failedPayments.size());
    }

    static int retryFailedPayments(Queue<String> failedPayments) {
        Map<String, Integer> attempts = new HashMap<>();
        int recovered = 0;

        while (!failedPayments.isEmpty()) {
            String paymentId = failedPayments.poll();
            int tried = attempts.merge(paymentId, 1, Integer::sum);

            if (retryPayment(paymentId, tried)) {
                recovered++;
            } else if (tried < MAX_RETRY_ATTEMPTS) {
                failedPayments.offer(paymentId);
            }
        }
        return recovered;
    }

    private static boolean retryPayment(String paymentId, int attempt) {
        return (Math.abs(paymentId.hashCode()) + attempt) % 2 == 0;
    }
}
