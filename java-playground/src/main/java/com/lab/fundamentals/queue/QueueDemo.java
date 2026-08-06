package com.lab.fundamentals.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * HRMS onboarding desk — offer/poll FIFO plus peek-before-process in one flow.
 */
public class QueueDemo {

    public static void main(String[] args) {
        QueueFlowResult result = runOnboardingDesk(
                new OnboardingTicket("T-1", "Asha", "Engineering"),
                new OnboardingTicket("T-2", "Ravi", "People Ops"),
                new OnboardingTicket("T-3", "Meera", "Finance")
        );
        System.out.println(result);
    }

    static QueueFlowResult runOnboardingDesk(OnboardingTicket... tickets) {
        Queue<OnboardingTicket> desk = QueueOfferPollDemo.asLinkedQueue(tickets);

        String peekedNext = QueuePeekDemo.peekTicketId(desk);
        boolean hadPending = QueuePeekDemo.hasPending(desk);

        OnboardingTicket first = QueueOfferPollDemo.pollNext(desk);
        List<String> processedOrder = new ArrayList<>();
        if (first != null) {
            processedOrder.add(first.ticketId());
        }
        processedOrder.addAll(QueueOfferPollDemo.drainIds(desk));

        return new QueueFlowResult(
                peekedNext,
                hadPending,
                processedOrder,
                QueueOfferPollDemo.size(desk)
        );
    }

    record QueueFlowResult(
            String peekedNextId,
            boolean hadPendingBeforePoll,
            List<String> processedOrder,
            int remaining
    ) {
        @Override
        public String toString() {
            return "QueueFlow{peeked=%s, hadPending=%b, processed=%s, remaining=%d}"
                    .formatted(peekedNextId, hadPendingBeforePoll, processedOrder, remaining);
        }
    }
}
