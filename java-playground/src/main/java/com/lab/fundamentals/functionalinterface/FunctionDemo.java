package com.lab.fundamentals.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/** Function — map Employee to corporate email and related HRMS strings. */
public class FunctionDemo {

    public static void main(String[] args) {
        Employee asha = new Employee("E001", "Asha", "Engineering", "asha@hrms.lab", 95_000, true);
        System.out.println("Email: " + toEmail().apply(asha));
        System.out.println("Directory line: " + toDirectoryLine().apply(asha));
    }

    static Function<Employee, String> toEmail() {
        return employee -> employee == null ? "" : employee.email();
    }

    static Function<Employee, String> toDirectoryLine() {
        return employee -> {
            if (employee == null) {
                return "";
            }
            return employee.name() + " <" + employee.email() + "> — " + employee.department();
        };
    }

    static Function<String, String> corporateEmailFromName() {
        return name -> {
            if (name == null || name.isBlank()) {
                return "unknown@hrms.lab";
            }
            return name.trim().toLowerCase().replace(' ', '.') + "@hrms.lab";
        };
    }

    static List<String> mapEmails(List<Employee> roster) {
        return map(roster, toEmail());
    }

    static <T, R> List<R> map(List<T> source, Function<T, R> mapper) {
        List<R> mapped = new ArrayList<>();
        if (source == null || mapper == null) {
            return mapped;
        }
        for (T item : source) {
            mapped.add(mapper.apply(item));
        }
        return mapped;
    }
}
