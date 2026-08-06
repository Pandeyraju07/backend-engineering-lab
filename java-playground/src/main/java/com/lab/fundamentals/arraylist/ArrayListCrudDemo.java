package com.lab.fundamentals.arraylist;

import java.util.ArrayList;
import java.util.List;

/** ArrayList CRUD — build and edit an HRMS department roster. */
public class ArrayListCrudDemo {

    public static void main(String[] args) {
        List<EmployeeRecord> roster = buildRoster(
                new EmployeeRecord("EMP-1", "Asha", "Engineering", 70_000),
                new EmployeeRecord("EMP-2", "Ravi", "People Ops", 65_000),
                new EmployeeRecord("EMP-3", "Meera", "Finance", 72_000)
        );
        System.out.println("Roster size: " + roster.size());
        System.out.println("First: " + getByIndex(roster, 0));
        System.out.println("Removed: " + removeById(roster, "EMP-2"));
        System.out.println("After remove size: " + roster.size());
    }

    static List<EmployeeRecord> buildRoster(EmployeeRecord... employees) {
        List<EmployeeRecord> roster = new ArrayList<>();
        for (EmployeeRecord employee : employees) {
            addEmployee(roster, employee);
        }
        return roster;
    }

    static boolean addEmployee(List<EmployeeRecord> roster, EmployeeRecord employee) {
        return roster.add(employee);
    }

    static EmployeeRecord getByIndex(List<EmployeeRecord> roster, int index) {
        return roster.get(index);
    }

    static boolean removeById(List<EmployeeRecord> roster, String employeeId) {
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).employeeId().equals(employeeId)) {
                roster.remove(i);
                return true;
            }
        }
        return false;
    }

    static boolean removeAt(List<EmployeeRecord> roster, int index) {
        if (index < 0 || index >= roster.size()) {
            return false;
        }
        roster.remove(index);
        return true;
    }
}
