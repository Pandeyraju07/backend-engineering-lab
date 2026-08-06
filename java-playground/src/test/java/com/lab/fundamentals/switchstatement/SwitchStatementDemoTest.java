package com.lab.fundamentals.switchstatement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitchStatementDemoTest {

    @Test
    void classicSwitchMapsGradeToBonusPercent() {
        assertEquals(0.15, ClassicSwitchDemo.bonusPercentClassic('A'));
        assertEquals(0.10, ClassicSwitchDemo.bonusPercentClassic('b'));
        assertEquals(0.05, ClassicSwitchDemo.bonusPercentClassic('C'));
        assertEquals(0.0, ClassicSwitchDemo.bonusPercentClassic('D'));
        assertEquals(0.0, ClassicSwitchDemo.bonusPercentClassic('F'));
        assertEquals(0.0, ClassicSwitchDemo.bonusPercentClassic('Z'));
    }

    @Test
    void switchExpressionYieldsSamePercentsAsClassic() {
        for (char grade : new char[]{'A', 'B', 'C', 'D', 'F', 'x'}) {
            assertEquals(
                    ClassicSwitchDemo.bonusPercentClassic(grade),
                    SwitchExpressionDemo.bonusPercentExpression(grade)
            );
        }
    }

    @Test
    void arrowSwitchMapsGradeBand() {
        assertEquals("EXCELLENT", SwitchArrowDemo.gradeBand('A'));
        assertEquals("GOOD", SwitchArrowDemo.gradeBand('B'));
        assertEquals("AVERAGE", SwitchArrowDemo.gradeBand('C'));
        assertEquals("NEEDS_IMPROVEMENT", SwitchArrowDemo.gradeBand('D'));
        assertEquals("NEEDS_IMPROVEMENT", SwitchArrowDemo.gradeBand('F'));
        assertEquals("UNKNOWN", SwitchArrowDemo.gradeBand('Z'));
    }

    @Test
    void bonusDecisionUsesAllSwitchStyles() {
        SwitchStatementDemo.BonusDecision decision = SwitchStatementDemo.decideBonus(
                new PerformanceGrade("EMP-401", 'A'), 90_000);

        assertEquals("EMP-401", decision.employeeId());
        assertEquals('A', decision.grade());
        assertEquals("EXCELLENT", decision.band());
        assertEquals(0.15, decision.bonusPercent());
        assertEquals(13_500, decision.bonusAmount());
        assertEquals(decision.classicPercent(), decision.bonusPercent());

        SwitchStatementDemo.BonusDecision noBonus = SwitchStatementDemo.decideBonus(
                new PerformanceGrade("EMP-402", 'F'), 70_000);

        assertEquals("NEEDS_IMPROVEMENT", noBonus.band());
        assertEquals(0.0, noBonus.bonusAmount());
    }
}
