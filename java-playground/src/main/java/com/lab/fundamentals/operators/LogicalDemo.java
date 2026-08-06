package com.lab.fundamentals.operators;

/** Logical operators — combine eligibility flags for bonus approval. */
public class LogicalDemo {

    public static void main(String[] args) {
        boolean approved = canApproveBonus(true, true, true);
        boolean rejected = canApproveBonus(true, false, true);
        System.out.println("Logical: approved=" + approved + ", rejected=" + rejected);
    }

    static boolean canApproveBonus(boolean senior, boolean highEarner, boolean noPendingLeave) {
        return (senior || highEarner) && noPendingLeave;
    }
}
