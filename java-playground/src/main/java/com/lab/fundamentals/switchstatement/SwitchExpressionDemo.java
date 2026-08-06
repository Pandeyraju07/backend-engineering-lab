package com.lab.fundamentals.switchstatement;

/** Switch expression with yield — appraisal grade to annual bonus percent. */
public class SwitchExpressionDemo {

    public static void main(String[] args) {
        System.out.printf("Expression A: %.0f%%%n", bonusPercentExpression('A') * 100);
        System.out.printf("Expression C: %.0f%%%n", bonusPercentExpression('C') * 100);
        System.out.printf("Expression F: %.0f%%%n", bonusPercentExpression('F') * 100);
    }

    static double bonusPercentExpression(char grade) {
        return switch (Character.toUpperCase(grade)) {
            case 'A' -> {
                yield 0.15;
            }
            case 'B' -> {
                yield 0.10;
            }
            case 'C' -> {
                yield 0.05;
            }
            case 'D', 'F' -> {
                yield 0.0;
            }
            default -> {
                yield 0.0;
            }
        };
    }
}
