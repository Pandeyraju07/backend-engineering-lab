package com.lab.fundamentals.lambda;

import java.util.List;

/**
 * Lambda capture — effectively final salary threshold used inside a predicate.
 */
public class LambdaCaptureDemo {

    public static void main(String[] args) {
        List<Employee> above = aboveThreshold(LambdaSyntaxDemo.sampleRoster(), 60_000);
        System.out.println(above);
    }

    static List<Employee> aboveThreshold(List<Employee> employees, double threshold) {
        // threshold is effectively final and captured by the lambda
        return LambdaSyntaxDemo.filter(employees, employee -> employee.salary() >= threshold);
    }

    static List<Employee> activeAboveThreshold(List<Employee> employees, double threshold) {
        return LambdaSyntaxDemo.filter(
                employees,
                employee -> employee.active() && employee.salary() >= threshold
        );
    }
}
