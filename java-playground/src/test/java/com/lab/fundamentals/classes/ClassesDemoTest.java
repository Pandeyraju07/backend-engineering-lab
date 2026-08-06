package com.lab.fundamentals.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassesDemoTest {

    @Test
    void classStructureCreatesAndMutatesEmployee() {
        Employee employee = ClassStructureDemo.createSample();

        assertEquals("EMP-301", employee.employeeId());
        assertEquals("Engineering", employee.department());
        assertFalse(employee.active());

        Employee hired = ClassStructureDemo.hire("EMP-302", "Raju Kumar", "HR", 70_000);
        hired.applyRaise(0.10);
        hired.transferTo("People Ops");

        assertTrue(hired.active());
        assertEquals(77_000, hired.salary());
        assertEquals("People Ops", hired.department());
    }

    @Test
    void memberDemoCountsActiveEmployeesAndRoster() {
        MemberDemo.ActiveRoster.reset();
        Employee active = ClassStructureDemo.hire("EMP-1", "A", "HR", 60_000);
        Employee inactive = new Employee("EMP-2", "B", "IT", 60_000);

        assertEquals(1, MemberDemo.countActive(active, inactive));

        MemberDemo.ActiveRoster.register(active);
        MemberDemo.ActiveRoster.register(inactive);
        assertEquals(1, MemberDemo.ActiveRoster.countActive());
        assertEquals(2, MemberDemo.ActiveRoster.totalRegistered());
    }

    @Test
    void onboardAndTrackUsesClassStructureAndMembers() {
        ClassesDemo.ClassDemoResult result = ClassesDemo.onboardAndTrack(
                "EMP-410", "Priya Nair", "Engineering", 80_000, 0.05);

        assertEquals("EMP-410", result.hired().employeeId());
        assertTrue(result.hired().active());
        assertEquals(84_000, result.hired().salary());
        assertEquals("Engineering Ops", result.hired().department());
        assertEquals(1, result.activeAmongPair());
        assertEquals(1, result.rosterActiveCount());
        assertEquals(2, result.rosterTotal());
    }
}
