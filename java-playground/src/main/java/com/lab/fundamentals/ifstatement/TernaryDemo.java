package com.lab.fundamentals.ifstatement;

/** Ternary operator — leave urgency and paid-leave payroll status. */
public class TernaryDemo {

    private static final int HIGH_URGENCY_DAYS = 5;

    public static void main(String[] args) {
        System.out.println("Urgency (2 days): " + urgencyLabel(2));
        System.out.println("Urgency (7 days): " + urgencyLabel(7));
        System.out.println("Pay status approved: " + payStatus(true));
        System.out.println("Pay status rejected: " + payStatus(false));
    }

    static String urgencyLabel(int days) {
        return days >= HIGH_URGENCY_DAYS ? "HIGH" : "NORMAL";
    }

    static String payStatus(boolean approved) {
        return approved ? "PAID_LEAVE" : "UNPAID_HOLD";
    }
}
