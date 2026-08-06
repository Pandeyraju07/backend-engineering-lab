package com.lab.fundamentals.generics;

import java.util.Optional;

/** Generic class — {@code Repository<Employee>} save and find. */
public class GenericClassDemo {

    public static void main(String[] args) {
        Repository<Employee> repo = employeeRepository(
                new Employee("E001", "Asha", 70_000),
                new Employee("E002", "Ravi", 65_000)
        );
        System.out.println("Size: " + repo.size());
        System.out.println("Found: " + findById(repo, "E001").orElse(null));
    }

    static Repository<Employee> employeeRepository(Employee... employees) {
        Repository<Employee> repo = new Repository<>();
        for (Employee employee : employees) {
            repo.save(employee);
        }
        return repo;
    }

    static Optional<Employee> findById(Repository<Employee> repo, String id) {
        return repo.find(employee -> employee.id().equals(id));
    }

    static Optional<Employee> findByName(Repository<Employee> repo, String name) {
        return repo.find(employee -> employee.name().equals(name));
    }
}
