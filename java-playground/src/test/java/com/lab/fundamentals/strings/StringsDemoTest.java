package com.lab.fundamentals.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsDemoTest {

    @Test
    void immutableBuildsEmailAndNormalizesName() {
        assertEquals("raju.kumar@company.com", StringImmutableDemo.buildEmail("Raju", "Kumar"));
        assertEquals("Raju Kumar", StringImmutableDemo.normalizeName("  raju   kumar  "));
        assertTrue(StringImmutableDemo.sameEmail(
                StringImmutableDemo.buildEmail("Raju", "Kumar"),
                "raju.kumar@company.com"));
    }

    @Test
    void stringBuilderBuildsDisplayNameAndJoinsDepartments() {
        assertEquals("Raju Kumar", StringBuilderDemo.buildDisplayName("Raju", "Kumar"));
        assertEquals("Engineering | HR", StringBuilderDemo.joinDepartments("Engineering", "HR"));
        assertEquals("", StringBuilderDemo.buildDisplayName());
    }

    @Test
    void stringBufferPrefixesEmployeeId() {
        StringBuffer buffer = new StringBuffer("Badge:");
        StringBufferDemo.appendIdPrefix(buffer, "1001");
        assertEquals("Badge:EMP-1001", buffer.toString());
        assertEquals("EMP-1001", StringBufferDemo.formatBadge("1001"));
        assertEquals("EMP-1001", StringBufferDemo.formatBadge("EMP-1001"));
    }

    @Test
    void nameFormatUsesAllStringDemos() {
        StringsDemo.NameFormatResult result = StringsDemo.formatEmployeeIdentity(
                new EmployeeName("  ananya ", " sharma "),
                "2044",
                "Engineering", "HR"
        );

        assertEquals("Ananya Sharma", result.displayName());
        assertEquals("ananya.sharma@company.com", result.email());
        assertEquals("EMP-2044", result.badgeId());
        assertEquals("Engineering | HR", result.departments());
    }
}
