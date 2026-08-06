package com.lab.fundamentals.strings;

/**
 * HRMS name/email formatting — uses String, StringBuilder, and StringBuffer in one flow.
 */
public class StringsDemo {

    public static void main(String[] args) {
        NameFormatResult result = formatEmployeeIdentity(
                new EmployeeName("  raju  ", " kumar "),
                "1001",
                "Engineering", "People Ops"
        );
        System.out.println(result);
    }

    static NameFormatResult formatEmployeeIdentity(EmployeeName name, String rawId, String... departments) {
        String normalizedFirst = StringImmutableDemo.normalizeName(name.firstName());
        String normalizedLast = StringImmutableDemo.normalizeName(name.lastName());
        String email = StringImmutableDemo.buildEmail(normalizedFirst, normalizedLast);
        String displayName = StringBuilderDemo.buildDisplayName(normalizedFirst, normalizedLast);
        String departmentLine = StringBuilderDemo.joinDepartments(departments);
        String badgeId = StringBufferDemo.formatBadge(rawId);

        return new NameFormatResult(displayName, email, badgeId, departmentLine);
    }

    record NameFormatResult(String displayName, String email, String badgeId, String departments) {
        @Override
        public String toString() {
            return "NameFormat{display='%s', email='%s', badge='%s', departments='%s'}"
                    .formatted(displayName, email, badgeId, departments);
        }
    }
}
