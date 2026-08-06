package com.lab.fundamentals.operators;

/**
 * HRMS salary eligibility — uses arithmetic, relational, logical, and bitwise operators together.
 */
public class OperatorsDemo {

    private static final double HIGH_EARNER_THRESHOLD = 100_000;
    private static final double HOURLY_RATE = 500;
    private static final int OVERTIME_HOURS = 10;

    public static void main(String[] args) {
        PayrollInput input = new PayrollInput(
                120_000,
                0.18,
                7,
                false,
                BitwiseDemo.FLAG_VIEW_PAYROLL
        );
        OperatorPayrollResult result = evaluatePayroll(input, OVERTIME_HOURS);
        System.out.println(result);
    }

    static OperatorPayrollResult evaluatePayroll(PayrollInput input, int overtimeHours) {
        double netPay = ArithmeticDemo.calculateNet(input.grossSalary(), input.taxRate());
        double overtime = ArithmeticDemo.overtimePay(HOURLY_RATE, overtimeHours);

        boolean senior = RelationalDemo.isSenior(input.yearsOfService());
        boolean highEarner = RelationalDemo.isHighEarner(input.grossSalary(), HIGH_EARNER_THRESHOLD);

        int flags = BitwiseDemo.grantFlag(input.flags(), BitwiseDemo.FLAG_APPROVE_BONUS);
        boolean canGrantBonus = BitwiseDemo.hasFlag(flags, BitwiseDemo.FLAG_APPROVE_BONUS);
        boolean noPendingLeave = !input.hasPendingLeave();
        boolean bonusApproved = canGrantBonus
                && LogicalDemo.canApproveBonus(senior, highEarner, noPendingLeave);

        return new OperatorPayrollResult(netPay, overtime, senior, highEarner, flags, bonusApproved);
    }

    record OperatorPayrollResult(
            double netPay,
            double overtimePay,
            boolean senior,
            boolean highEarner,
            int flags,
            boolean bonusApproved
    ) {
        @Override
        public String toString() {
            return "OperatorPayroll{net=%.2f, overtime=%.2f, senior=%b, highEarner=%b, flags=%d, bonusApproved=%b}"
                    .formatted(netPay, overtimePay, senior, highEarner, flags, bonusApproved);
        }
    }
}
