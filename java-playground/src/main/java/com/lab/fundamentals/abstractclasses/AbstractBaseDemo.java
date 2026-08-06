package com.lab.fundamentals.abstractclasses;

/**
 * Abstract base usage — hold permanent and contractor staff behind {@link AbstractEmployee} references.
 */
public class AbstractBaseDemo {

    public static void main(String[] args) {
        AbstractEmployee[] staff = sampleStaff();
        System.out.printf("AbstractBase: count=%d, totalGross=%.2f%n",
                staff.length, totalPayroll(staff));
        for (AbstractEmployee employee : staff) {
            System.out.println(employee.displayName() + " → " + employee.monthlyPay());
        }
    }

    /** Sample mixed workforce referenced only as {@link AbstractEmployee}. */
    static AbstractEmployee[] sampleStaff() {
        AbstractEmployee permanent = new PermanentStaff(
                "EMP-101", "Asha Verma", "Engineering", 90_000, 10_000);
        AbstractEmployee contractor = new ContractorStaff(
                "CTR-202", "Rohit Sen", "Engineering", 800, 160);
        AbstractEmployee senior = new PermanentStaff(
                "EMP-103", "Neha Kapoor", "HR", 120_000, 15_000);
        return new AbstractEmployee[]{permanent, contractor, senior};
    }

    /** Sums {@link AbstractEmployee#monthlyPay()} polymorphically over varargs. */
    static double totalPayroll(AbstractEmployee... staff) {
        if (staff == null) {
            throw new IllegalArgumentException("staff is required");
        }
        double total = 0;
        for (AbstractEmployee employee : staff) {
            if (employee == null) {
                throw new IllegalArgumentException("staff entries must be non-null");
            }
            total += employee.monthlyPay();
        }
        return total;
    }

    static int countByType(Class<? extends AbstractEmployee> type, AbstractEmployee... staff) {
        int count = 0;
        for (AbstractEmployee employee : staff) {
            if (type.isInstance(employee)) {
                count++;
            }
        }
        return count;
    }
}
