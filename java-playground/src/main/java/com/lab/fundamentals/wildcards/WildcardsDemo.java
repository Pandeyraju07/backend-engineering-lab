package com.lab.fundamentals.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * HRMS PECS department list — producer-extends / consumer-super / unbounded in one flow.
 */
public class WildcardsDemo {

    public static void main(String[] args) {
        WildcardResult result = runPecsDeptList();
        System.out.println(result);
    }

    static WildcardResult runPecsDeptList() {
        List<Department> departments = List.of(
                new Department("ENG", "Engineering", 12),
                new Department("HR", "People Ops", 4),
                new Department("FIN", "Finance", 6)
        );

        List<Integer> headcounts = departments.stream().map(Department::headcount).toList();
        double averageHeadcount = UpperBoundDemo.average(headcounts);

        List<Number> gradeBucket = new ArrayList<>();
        LowerBoundDemo.addNumbers(gradeBucket, 1, 2, 3);
        int gradesStored = LowerBoundDemo.countEntries(gradeBucket);

        int departmentCount = UnboundedDemo.sizeOf(departments);
        List<String> printed = UnboundedDemo.printAll(departments);

        return new WildcardResult(
                departmentCount,
                averageHeadcount,
                gradesStored,
                printed.size()
        );
    }

    record WildcardResult(
            int departmentCount,
            double averageHeadcount,
            int gradesStored,
            int printedLines
    ) {
        @Override
        public String toString() {
            return "WildcardResult{depts=%d, avgHeadcount=%.2f, grades=%d, printed=%d}"
                    .formatted(departmentCount, averageHeadcount, gradesStored, printedLines);
        }
    }
}
