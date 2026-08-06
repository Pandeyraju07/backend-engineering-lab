package com.lab.fundamentals.hashmap;

import java.util.Map;

/**
 * HRMS salary lookup — HashMap CRUD, compute/merge, and iteration in one flow.
 */
public class HashMapDemo {

    public static void main(String[] args) {
        SalaryMapResult result = runSalaryLookup();
        System.out.println(result);
    }

    static SalaryMapResult runSalaryLookup() {
        Map<String, Double> salaries = HashMapCrudDemo.seedSalaries();

        HashMapCrudDemo.putSalary(salaries, "E004", 90_000);
        double e001 = HashMapCrudDemo.lookupSalary(salaries, "E001");
        boolean hasE002 = HashMapCrudDemo.containsEmployee(salaries, "E002");

        HashMapComputeDemo.ensureDefault(salaries, "E200");
        double afterRaise = HashMapComputeDemo.applyRaise(salaries, "E001", 5_000);

        int sizeAfterRemove = HashMapCrudDemo.removeEmployee(salaries, "E003");
        double total = HashMapIterateDemo.sumSalaries(salaries);
        int entryCount = HashMapIterateDemo.formatEntries(salaries).size();

        return new SalaryMapResult(
                e001,
                hasE002,
                afterRaise,
                HashMapComputeDemo.DEFAULT_SALARY,
                sizeAfterRemove,
                total,
                entryCount
        );
    }

    record SalaryMapResult(
            double lookedUpSalary,
            boolean containsE002,
            double raisedE001,
            double defaultForNewHire,
            int sizeAfterRemove,
            double totalSalaries,
            int formattedEntryCount
    ) {
        @Override
        public String toString() {
            return ("SalaryMapResult{lookup=%.2f, hasE002=%b, raisedE001=%.2f, default=%.2f, "
                    + "size=%d, total=%.2f, entries=%d}")
                    .formatted(lookedUpSalary, containsE002, raisedE001, defaultForNewHire,
                            sizeAfterRemove, totalSalaries, formattedEntryCount);
        }
    }
}
