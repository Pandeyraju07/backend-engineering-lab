package com.lab.fundamentals.datatypes;

/**
 * HRMS profile intake — combines primitives, references, and wrappers into one employee summary.
 */
public class DatatypesDemo {

    public static void main(String[] args) {
        DatatypeProfileResult result = buildProfileSummary(
                (byte) 3,
                (short) 14,
                29,
                1_000_501L,
                7.5f,
                "87500.00",
                'A',
                true,
                "  ananya sharma  ",
                new int[]{5, 4, 0, 3}
        );
        System.out.println(result);
    }

    static DatatypeProfileResult buildProfileSummary(
            byte tier,
            short leaveBalance,
            int age,
            long employeeNumber,
            float bonusPercent,
            String salaryRaw,
            Character gradeWrapper,
            boolean active,
            String rawName,
            int[] skillRatings
    ) {
        Double parsedSalary = WrapperDemo.parseSalary(salaryRaw);
        double salary = parsedSalary != null ? parsedSalary : 0.0;
        char grade = WrapperDemo.toGrade(gradeWrapper);
        String name = ReferenceTypeDemo.formatName(rawName);
        int skills = ReferenceTypeDemo.skillCount(skillRatings);

        EmployeeProfile profile = new EmployeeProfile(
                tier, leaveBalance, age, employeeNumber, bonusPercent, salary, grade, active, name
        );

        boolean bonusEligible = PrimitiveDemo.isEligibleForBonus(profile);
        return new DatatypeProfileResult(profile, skills, bonusEligible);
    }

    record DatatypeProfileResult(EmployeeProfile profile, int skillCount, boolean bonusEligible) {
        @Override
        public String toString() {
            return "DatatypeProfile{name=%s, empNo=%d, salary=%.2f, grade=%c, skills=%d, bonusEligible=%b}"
                    .formatted(
                            profile.name(),
                            profile.employeeNumber(),
                            profile.salary(),
                            profile.grade(),
                            skillCount,
                            bonusEligible
                    );
        }
    }
}
