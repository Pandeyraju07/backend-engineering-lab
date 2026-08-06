package com.lab.fundamentals.typecasting;

/** Narrowing conversions — double → int/byte with explicit casts and clamping. */
public class NarrowingDemo {

    public static void main(String[] args) {
        int rupees = toWholeRupees(82_450.75);
        byte bonus = clampBonusPercent(112.5);
        System.out.printf("Narrowing: wholeRupees=%d, bonusPercent=%d%n", rupees, bonus);
    }

    /** Truncates fractional rupees toward zero via explicit double → int cast. */
    static int toWholeRupees(double amount) {
        return (int) amount;
    }

    /** Narrows a bonus percent to byte, clamped into the HR policy range 0–100. */
    static byte clampBonusPercent(double percent) {
        double clamped = Math.max(0, Math.min(100, percent));
        return (byte) clamped;
    }
}
