package com.lab.fundamentals.typecasting;

/**
 * HRMS payroll number conversion — widening, narrowing, and object casts in one flow.
 */
public class TypeCastingDemo {

    private static final String CURRENCY = "INR";

    public static void main(String[] args) {
        CastingResult result = convertPayrollNumbers(1001, 82_450, 12.5);
        System.out.println(result);
    }

    /**
     * Converts an employee salary through widening → cents storage → narrowing → Number casts.
     *
     * @param employeeId integer HR id
     * @param salaryRupees whole-rupee salary entered as int
     * @param bonusPercent raw bonus percent (may be out of range)
     */
    static CastingResult convertPayrollNumbers(int employeeId, int salaryRupees, double bonusPercent) {
        double widenedSalary = WideningDemo.widenSalary(salaryRupees);
        PayrollAmount payrollAmount = PayrollAmount.ofAmount(widenedSalary, CURRENCY);

        long combinedKey = WideningDemo.combineIdAndAmount(employeeId, payrollAmount.cents());
        int wholeRupees = NarrowingDemo.toWholeRupees(payrollAmount.amount());
        byte clampedBonus = NarrowingDemo.clampBonusPercent(bonusPercent);

        Number idAsNumber = Integer.valueOf(employeeId);
        Integer idAsInteger = ObjectCastDemo.asInteger(idAsNumber);
        long safeCents = ObjectCastDemo.safeLongValue(Long.valueOf(payrollAmount.cents()));

        return new CastingResult(
                payrollAmount,
                widenedSalary,
                combinedKey,
                wholeRupees,
                clampedBonus,
                idAsInteger,
                safeCents
        );
    }

    record CastingResult(
            PayrollAmount payrollAmount,
            double widenedSalary,
            long combinedKey,
            int wholeRupees,
            byte bonusPercent,
            Integer employeeIdAsInteger,
            long safeCents
    ) {
        @Override
        public String toString() {
            return "CastingResult{amount=%.2f %s, widened=%.2f, key=%d, whole=%d, bonus=%d%%, id=%s, cents=%d}"
                    .formatted(
                            payrollAmount.amount(),
                            payrollAmount.currency(),
                            widenedSalary,
                            combinedKey,
                            wholeRupees,
                            bonusPercent,
                            employeeIdAsInteger,
                            safeCents
                    );
        }
    }
}
