package com.lab.fundamentals.finalkeyword;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinalKeywordDemoTest {

    @Test
    void finalVariableNormalizeIdTrimsAndUppercases() {
        assertEquals("EMP-501", FinalVariableDemo.normalizeId("  emp-501  "));
        assertEquals("EMP-501:Priya Nair", FinalVariableDemo.badgeLabel("emp-501", "Priya Nair"));
        assertThrows(IllegalArgumentException.class, () -> FinalVariableDemo.normalizeId(" "));
    }

    @Test
    void finalMethodLocksTaxButAllowsBonusOverride() {
        FinalMethodDemo.BasePolicy base = new FinalMethodDemo.BasePolicy();
        FinalMethodDemo.DepartmentPolicy dept = new FinalMethodDemo.DepartmentPolicy();

        assertEquals(0.18, FinalMethodDemo.lockedTaxRate(base));
        assertEquals(0.18, FinalMethodDemo.lockedTaxRate(dept));
        assertEquals(0.05, FinalMethodDemo.adjustableBonusRate(base));
        assertEquals(0.08, FinalMethodDemo.adjustableBonusRate(dept));
        assertTrue(FinalMethodDemo.taxRateIsFinalConstant());
    }

    @Test
    void finalClassEmployeeIdNormalizesAndRejectsBlank() {
        FinalClassDemo.EmployeeId id = FinalClassDemo.wrap(" emp-777 ");

        assertEquals("EMP-777", id.value());
        assertEquals("ID[EMP-777]", FinalClassDemo.display(id));
        assertTrue(FinalClassDemo.acceptsNormalized("EMP-1"));
        assertFalse(FinalClassDemo.acceptsNormalized("  "));
        assertThrows(IllegalArgumentException.class, () -> FinalClassDemo.wrap(null));
    }

    @Test
    void runFinalFlowIntegratesVariableMethodAndClass() {
        FinalKeywordDemo.FinalFlowResult result =
                FinalKeywordDemo.runFinalFlow("  emp-501  ", "Priya Nair");

        assertEquals("EMP-501", result.normalizedId());
        assertEquals("EMP-501:Priya Nair", result.badgeLabel());
        assertEquals(0.18, result.taxRate());
        assertEquals(0.08, result.bonusRate());
        assertTrue(result.taxRateLockedAcrossPolicies());
        assertEquals("EMP-501", result.finalClassId());
        assertEquals("ID[EMP-501]", result.idDisplay());
    }
}
