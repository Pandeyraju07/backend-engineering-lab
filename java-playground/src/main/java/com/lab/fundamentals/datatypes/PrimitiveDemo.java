package com.lab.fundamentals.datatypes;

/** Primitive types — create and read HRMS profile fields (byte through boolean). */
public class PrimitiveDemo {

    private static final float BONUS_ELIGIBILITY_THRESHOLD = 5.0f;
    private static final double MIN_SALARY_FOR_BONUS = 50_000;

    public static void main(String[] args) {
        EmployeeProfile profile = createSampleProfile();
        System.out.printf(
                "Primitives: name=%s, tier=%d, leave=%d, age=%d, empNo=%d, bonus=%.1f%%, salary=%.2f, grade=%c, active=%b%n",
                profile.name(), profile.tier(), profile.leaveBalance(), profile.age(),
                profile.employeeNumber(), profile.bonusPercent(), profile.salary(),
                profile.grade(), profile.active()
        );
        System.out.println("Eligible for bonus: " + isEligibleForBonus(profile));
    }

    static EmployeeProfile createSampleProfile() {
        byte tier = 2;
        short leaveBalance = 18;
        int age = 32;
        long employeeNumber = 1_000_245L;
        float bonusPercent = 8.5f;
        double salary = 85_000.50;
        char grade = 'A';
        boolean active = true;
        String name = "Raju Kumar";
        return new EmployeeProfile(tier, leaveBalance, age, employeeNumber, bonusPercent, salary, grade, active, name);
    }

    static boolean isEligibleForBonus(EmployeeProfile profile) {
        return profile.active()
                && profile.bonusPercent() >= BONUS_ELIGIBILITY_THRESHOLD
                && profile.salary() >= MIN_SALARY_FOR_BONUS
                && profile.grade() != 'D';
    }
}
