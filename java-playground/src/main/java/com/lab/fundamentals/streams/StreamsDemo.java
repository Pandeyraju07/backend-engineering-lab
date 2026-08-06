package com.lab.fundamentals.streams;

import java.util.List;
import java.util.Map;

/**
 * HRMS payroll stream pipeline — filter/map, collectors, and reduce in one flow.
 */
public class StreamsDemo {

    public static void main(String[] args) {
        StreamPayrollResult result = runPayrollPipeline(FilterMapDemo.sampleRoster());
        System.out.println(result);
    }

    static StreamPayrollResult runPayrollPipeline(List<Employee> roster) {
        List<String> activeNames = FilterMapDemo.activeNames(roster);
        List<String> engineeringNames = FilterMapDemo.namesInDepartment(roster, "Engineering");

        Map<String, List<Employee>> byDept = CollectorsDemo.groupByDepartment(roster);
        Map<String, Long> activeCounts = CollectorsDemo.countByDepartment(roster);
        String joinedNames = CollectorsDemo.joinActiveNames(roster);

        double totalPayroll = ReduceDemo.totalSalary(roster);
        double activePayroll = ReduceDemo.totalActiveSalary(roster);
        double topSalary = ReduceDemo.maxSalary(roster).orElse(0);
        long activeHeadcount = ReduceDemo.activeCount(roster);

        return new StreamPayrollResult(
                activeNames,
                engineeringNames,
                byDept.size(),
                activeCounts.getOrDefault("Engineering", 0L),
                joinedNames,
                totalPayroll,
                activePayroll,
                topSalary,
                activeHeadcount
        );
    }

    record StreamPayrollResult(
            List<String> activeNames,
            List<String> engineeringNames,
            int departmentCount,
            long activeEngineeringCount,
            String joinedActiveNames,
            double totalPayroll,
            double activePayroll,
            double topSalary,
            long activeHeadcount
    ) {
        @Override
        public String toString() {
            return ("StreamPayroll{activeNames=%s, eng=%s, depts=%d, engActive=%d, joined='%s', "
                    + "total=%.2f, activePay=%.2f, top=%.2f, headcount=%d}")
                    .formatted(activeNames, engineeringNames, departmentCount, activeEngineeringCount,
                            joinedActiveNames, totalPayroll, activePayroll, topSalary, activeHeadcount);
        }
    }
}
