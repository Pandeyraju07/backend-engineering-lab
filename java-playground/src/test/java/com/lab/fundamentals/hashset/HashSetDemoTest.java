package com.lab.fundamentals.hashset;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HashSetDemoTest {

    @Test
    void uniqueSkillsDeduplicateAndReportSize() {
        Set<String> skills = HashSetUniqueDemo.addSkills("Java", "SQL", "Java", "HRIS", "SQL");

        assertEquals(3, HashSetUniqueDemo.size(skills));
        assertTrue(skills.contains("Java"));
        assertTrue(skills.contains("SQL"));
        assertTrue(skills.contains("HRIS"));
        assertEquals(2, HashSetUniqueDemo.asSkillTags("Java", "SQL", "Java").size());
    }

    @Test
    void opsSupportContainsRemoveAndRetainAll() {
        Set<String> skills = HashSetUniqueDemo.addSkills("Java", "SQL", "HRIS", "Payroll");

        assertTrue(HashSetOpsDemo.contains(skills, "Java"));
        assertTrue(HashSetOpsDemo.remove(skills, "Payroll"));
        assertFalse(HashSetOpsDemo.contains(skills, "Payroll"));

        Set<String> retained = HashSetOpsDemo.retainRequired(skills, Set.of("Java", "SQL", "AWS"));
        assertEquals(Set.of("Java", "SQL"), retained);
        assertTrue(HashSetOpsDemo.retainAllInPlace(skills, Set.of("Java", "HRIS")));
        assertEquals(Set.of("Java", "HRIS"), skills);
    }

    @Test
    void skillTaggingIntegratesUniquenessAndSetOps() {
        HashSetDemo.SkillSetResult result = HashSetDemo.runSkillTagging(
                List.of("Java", "SQL", "Java", "HRIS", "Payroll", "SQL"),
                Set.of("Java", "SQL", "AWS"),
                "Payroll"
        );

        assertEquals(4, result.uniqueSkillCount());
        assertTrue(result.containedRemovedSkill());
        assertTrue(result.removedSkill());
        assertEquals(Set.of("Java", "SQL"), result.matchingRequiredSkills());
        assertEquals(2, result.matchingCount());
    }
}
