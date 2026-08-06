package com.lab.fundamentals.objects;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ObjectsDemoTest {

    @Test
    void objectCreationBuildsStaffMember() {
        StaffMember member = ObjectCreationDemo.create("EMP-501", "Raju Kumar");

        assertEquals("EMP-501", member.employeeId());
        assertEquals("Raju Kumar", member.name());
        assertTrue(member.toString().contains("EMP-501"));
    }

    @Test
    void identityDistinguishesReferenceFromEquals() {
        StaffMember left = ObjectCreationDemo.create("EMP-501", "Raju Kumar");
        StaffMember alias = left;
        StaffMember copy = ObjectCreationDemo.create("EMP-501", "R. Kumar");

        assertTrue(ObjectIdentityDemo.sameReference(left, alias));
        assertFalse(ObjectIdentityDemo.sameReference(left, copy));
        assertTrue(ObjectIdentityDemo.equalById(left, copy));
    }

    @Test
    void equalsHashCodeKeepsDistinctByEmployeeId() {
        Set<StaffMember> unique = EqualsHashCodeDemo.distinctById(
                ObjectCreationDemo.create("EMP-501", "Raju Kumar"),
                ObjectCreationDemo.create("EMP-501", "R. Kumar"),
                ObjectCreationDemo.create("EMP-502", "Ananya Sharma")
        );

        assertEquals(2, unique.size());
    }

    @Test
    void analyzeIdentityUsesCreationEqualsAndSetUniqueness() {
        ObjectsDemo.ObjectIdentityResult result = ObjectsDemo.analyzeIdentity(
                "EMP-701", "Priya Nair",
                "EMP-701", "P. Nair",
                "EMP-702", "Vikram Rao"
        );

        assertTrue(result.sameReference());
        assertTrue(result.equalById());
        assertTrue(result.differentById());
        assertEquals(2, result.distinctCount());
    }
}
