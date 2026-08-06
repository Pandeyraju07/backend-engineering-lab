package com.lab.fundamentals.operators;

/** Bitwise operators — permission flag masks on HRMS role bits. */
public class BitwiseDemo {

    static final int FLAG_VIEW_PAYROLL = 1;      // 0001
    static final int FLAG_APPROVE_LEAVE = 1 << 1; // 0010
    static final int FLAG_APPROVE_BONUS = 1 << 2; // 0100
    static final int FLAG_ADMIN = 1 << 3;         // 1000

    public static void main(String[] args) {
        int flags = FLAG_VIEW_PAYROLL;
        flags = grantFlag(flags, FLAG_APPROVE_BONUS);

        System.out.println("Bitwise: has view=" + hasFlag(flags, FLAG_VIEW_PAYROLL));
        System.out.println("Bitwise: has bonus approve=" + hasFlag(flags, FLAG_APPROVE_BONUS));
        System.out.println("Bitwise: has admin=" + hasFlag(flags, FLAG_ADMIN));
    }

    static boolean hasFlag(int flags, int mask) {
        return (flags & mask) == mask;
    }

    static int grantFlag(int flags, int mask) {
        return flags | mask;
    }
}
