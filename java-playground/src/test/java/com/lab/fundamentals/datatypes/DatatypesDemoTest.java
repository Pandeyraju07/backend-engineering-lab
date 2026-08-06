package com.lab.fundamentals.datatypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatatypesDemoTest {

    @Test
    void primitiveDemoCreatesEligibleProfile() {
        EmployeeProfile profile = PrimitiveDemo.createSampleProfile();

        assertEquals("Raju Kumar", profile.name());
        assertEquals(2, profile.tier());
        assertTrue(profile.active());
        assertTrue(PrimitiveDemo.isEligibleForBonus(profile));
    }

    @Test
    void referenceTypeFormatsNameAndCountsSkills() {
        assertEquals("Raju Kumar", ReferenceTypeDemo.formatName("  raju   kumar  "));
        assertEquals(3, ReferenceTypeDemo.skillCount(new int[]{4, 5, 0, 3}));
        assertEquals(0, ReferenceTypeDemo.skillCount(null));
    }

    @Test
    void wrapperParsesSalaryAndNormalizesGrade() {
        assertEquals(92_000.75, WrapperDemo.parseSalary("92000.75"));
        assertNull(WrapperDemo.parseSalary(null));
        assertNull(WrapperDemo.parseSalary("not-a-number"));
        assertEquals('B', WrapperDemo.toGrade('b'));
        assertEquals('C', WrapperDemo.toGrade(null));
    }

    @Test
    void profileSummaryUsesAllDatatypeDemos() {
        DatatypesDemo.DatatypeProfileResult result = DatatypesDemo.buildProfileSummary(
                (byte) 3,
                (short) 10,
                30,
                1_000_900L,
                6.0f,
                "60000",
                'A',
                true,
                "  priya nair  ",
                new int[]{5, 4, 3}
        );

        assertEquals("Priya Nair", result.profile().name());
        assertEquals(60_000, result.profile().salary());
        assertEquals(3, result.skillCount());
        assertTrue(result.bonusEligible());
    }
}
