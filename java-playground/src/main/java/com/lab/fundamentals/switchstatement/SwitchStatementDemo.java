package com.lab.fundamentals.switchstatement;

/**
 * HRMS appraisal bonus — uses classic switch, switch expression, and arrow switch in one flow.
 */
public class SwitchStatementDemo {

    public static void main(String[] args) {
        BonusDecision decision = decideBonus(new PerformanceGrade("EMP-401", 'A'), 90_000);
        System.out.println(decision);
    }

    static BonusDecision decideBonus(PerformanceGrade performance, double salary) {
        char grade = performance.grade();
        double classicPercent = ClassicSwitchDemo.bonusPercentClassic(grade);
        double expressionPercent = SwitchExpressionDemo.bonusPercentExpression(grade);
        String band = SwitchArrowDemo.gradeBand(grade);

        // Prefer expression percent; classic path is kept for parity checks in demos/tests.
        double bonusPercent = expressionPercent;
        double bonusAmount = salary * bonusPercent;

        return new BonusDecision(
                performance.employeeId(),
                grade,
                band,
                bonusPercent,
                bonusAmount,
                classicPercent
        );
    }

    record BonusDecision(
            String employeeId,
            char grade,
            String band,
            double bonusPercent,
            double bonusAmount,
            double classicPercent
    ) {
        @Override
        public String toString() {
            return "BonusDecision{employeeId='%s', grade=%c, band=%s, bonusPercent=%.0f%%, bonusAmount=%.2f}"
                    .formatted(employeeId, grade, band, bonusPercent * 100, bonusAmount);
        }
    }
}
