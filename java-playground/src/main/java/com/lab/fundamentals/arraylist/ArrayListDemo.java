package com.lab.fundamentals.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * HRMS department roster — uses ArrayList CRUD, iteration, and capacity in one flow.
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        RosterResult result = runRosterFlow(
                new EmployeeRecord("EMP-1", "Asha", "Engineering", 70_000),
                new EmployeeRecord("EMP-2", "Ravi", "People Ops", 65_000),
                new EmployeeRecord("EMP-3", "Meera", "Finance", 72_000),
                new EmployeeRecord("EMP-4", "Kiran", "Engineering", 68_000)
        );
        System.out.println(result);
    }

    static RosterResult runRosterFlow(EmployeeRecord... incoming) {
        ArrayList<EmployeeRecord> roster = ArrayListCapacityDemo.sizedList(incoming.length);
        ArrayListCapacityDemo.ensureCapacityForIntake(roster, incoming.length);

        for (EmployeeRecord employee : incoming) {
            ArrayListCrudDemo.addEmployee(roster, employee);
        }

        boolean removed = ArrayListCrudDemo.removeById(roster, "EMP-2");
        List<String> activeNames = ArrayListIterationDemo.names(roster);
        double payrollTotal = ArrayListIterationDemo.totalSalary(roster);

        return new RosterResult(
                ArrayListCapacityDemo.sizeOf(roster),
                removed,
                activeNames,
                payrollTotal
        );
    }

    record RosterResult(
            int activeCount,
            boolean removedTransfer,
            List<String> names,
            double totalSalary
    ) {
        @Override
        public String toString() {
            return "Roster{active=%d, removedTransfer=%s, names=%s, totalSalary=%.2f}"
                    .formatted(activeCount, removedTransfer, names, totalSalary);
        }
    }
}
