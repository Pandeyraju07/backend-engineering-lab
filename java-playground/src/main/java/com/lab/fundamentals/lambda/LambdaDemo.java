package com.lab.fundamentals.lambda;

import java.util.List;

/**
 * HRMS active-employee filter — lambda syntax and capture in one flow.
 */
public class LambdaDemo {

    public static void main(String[] args) {
        LambdaFilterResult result = filterActiveEmployees();
        System.out.println(result);
    }

    static LambdaFilterResult filterActiveEmployees() {
        List<Employee> roster = LambdaSyntaxDemo.sampleRoster();

        List<Employee> active = LambdaSyntaxDemo.filter(roster, employee -> employee.active());
        List<Employee> highEarners = LambdaCaptureDemo.activeAboveThreshold(roster, 60_000);
        List<String> activeNames = LambdaSyntaxDemo.namesOf(active);

        double activePayroll = active.stream().mapToDouble(Employee::salary).sum();

        return new LambdaFilterResult(
                roster.size(),
                active.size(),
                highEarners.size(),
                activeNames,
                activePayroll
        );
    }

    record LambdaFilterResult(
            int totalCount,
            int activeCount,
            int activeAboveThresholdCount,
            List<String> activeNames,
            double activePayroll
    ) {
        @Override
        public String toString() {
            return "LambdaFilterResult{total=%d, active=%d, aboveThreshold=%d, names=%s, payroll=%.2f}"
                    .formatted(totalCount, activeCount, activeAboveThresholdCount, activeNames, activePayroll);
        }
    }
}
