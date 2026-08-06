package com.lab.fundamentals.finalkeyword;

/**
 * Final methods — base tax rate is locked; subclasses customize only non-final hooks.
 */
public class FinalMethodDemo {

    public static void main(String[] args) {
        DepartmentPolicy policy = new DepartmentPolicy();
        System.out.printf("tax=%.2f bonus=%.2f%n",
                lockedTaxRate(policy), adjustableBonusRate(policy));
    }

    static double lockedTaxRate(BasePolicy policy) {
        return policy.finalTaxRate();
    }

    static double adjustableBonusRate(BasePolicy policy) {
        return policy.bonusRate();
    }

    static boolean taxRateIsFinalConstant() {
        BasePolicy base = new BasePolicy();
        BasePolicy dept = new DepartmentPolicy();
        return base.finalTaxRate() == dept.finalTaxRate();
    }

    static class BasePolicy {

        /** Locked company tax — subclasses must not override this method. */
        final double finalTaxRate() {
            return 0.18;
        }

        double bonusRate() {
            return 0.05;
        }
    }

    static class DepartmentPolicy extends BasePolicy {

        @Override
        double bonusRate() {
            return 0.08;
        }

        // Cannot override finalTaxRate() — compile error if uncommented:
        // @Override double finalTaxRate() { return 0.10; }
    }
}
