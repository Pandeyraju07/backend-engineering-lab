package com.lab.fundamentals.switchstatement;

/** Arrow switch — map appraisal grade to HRMS performance band label. */
public class SwitchArrowDemo {

    public static void main(String[] args) {
        System.out.println("Band A: " + gradeBand('A'));
        System.out.println("Band C: " + gradeBand('C'));
        System.out.println("Band F: " + gradeBand('F'));
    }

    static String gradeBand(char grade) {
        return switch (Character.toUpperCase(grade)) {
            case 'A' -> "EXCELLENT";
            case 'B' -> "GOOD";
            case 'C' -> "AVERAGE";
            case 'D', 'F' -> "NEEDS_IMPROVEMENT";
            default -> "UNKNOWN";
        };
    }
}
