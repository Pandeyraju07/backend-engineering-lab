package com.lab.fundamentals.switchstatement;

/**
 * Classic switch with break and intentional fall-through.
 * D and F share the same zero-bonus path via fall-through.
 */
public class ClassicSwitchDemo {

    public static void main(String[] args) {
        System.out.printf("Classic A: %.0f%%%n", bonusPercentClassic('A') * 100);
        System.out.printf("Classic B: %.0f%%%n", bonusPercentClassic('B') * 100);
        System.out.printf("Classic D: %.0f%%%n", bonusPercentClassic('D') * 100);
    }

    static double bonusPercentClassic(char grade) {
        double percent;
        switch (Character.toUpperCase(grade)) {
            case 'A':
                percent = 0.15;
                break;
            case 'B':
                percent = 0.10;
                break;
            case 'C':
                percent = 0.05;
                break;
            case 'D':
            case 'F':
                percent = 0.0;
                break;
            default:
                percent = 0.0;
                break;
        }
        return percent;
    }
}
