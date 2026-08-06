package com.lab.fundamentals.generics;

import java.util.List;

/**
 * HRMS typed employee repository — generic class, methods, and bounds in one flow.
 */
public class GenericsDemo {

    public static void main(String[] args) {
        GenericRepoResult result = runEmployeeRepo();
        System.out.println(result);
    }

    static GenericRepoResult runEmployeeRepo() {
        Repository<Employee> repo = GenericClassDemo.employeeRepository(
                new Employee("E001", "Asha", 70_000),
                new Employee("E002", "Ravi", 65_000),
                new Employee("E003", "Meera", 72_000)
        );

        Employee lookedUp = GenericClassDemo.findById(repo, "E001").orElseThrow();
        Employee named = GenericMethodDemo.identity(lookedUp);
        String department = GenericMethodDemo.firstNonNull(null, "Engineering");

        List<Double> salaries = repo.findAll().stream().map(Employee::salary).toList();
        double payrollTotal = BoundedTypeDemo.sum(salaries);
        double highest = BoundedTypeDemo.maxSalary(salaries);

        return new GenericRepoResult(
                repo.size(),
                named.name(),
                department,
                payrollTotal,
                highest
        );
    }

    record GenericRepoResult(
            int storedCount,
            String foundName,
            String department,
            double payrollTotal,
            double maxSalary
    ) {
        @Override
        public String toString() {
            return "GenericRepoResult{stored=%d, found=%s, dept=%s, total=%.2f, max=%.2f}"
                    .formatted(storedCount, foundName, department, payrollTotal, maxSalary);
        }
    }
}
