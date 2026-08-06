package com.lab.fundamentals.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** ArrayList iteration — indexed for, Iterator, and forEach over roster names. */
public class ArrayListIterationDemo {

    public static void main(String[] args) {
        List<EmployeeRecord> roster = ArrayListCrudDemo.buildRoster(
                new EmployeeRecord("EMP-1", "Asha", "Engineering", 70_000),
                new EmployeeRecord("EMP-2", "Ravi", "People Ops", 65_000)
        );
        System.out.println("Names (for): " + namesWithFor(roster));
        System.out.println("Names (iterator): " + namesWithIterator(roster));
        System.out.println("Names (forEach): " + names(roster));
    }

    /** Collects display names via List.forEach (consumer iteration). */
    static List<String> names(List<EmployeeRecord> roster) {
        List<String> result = new ArrayList<>();
        roster.forEach(employee -> result.add(employee.name()));
        return result;
    }

    static List<String> namesWithFor(List<EmployeeRecord> roster) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < roster.size(); i++) {
            result.add(roster.get(i).name());
        }
        return result;
    }

    static List<String> namesWithIterator(List<EmployeeRecord> roster) {
        List<String> result = new ArrayList<>();
        Iterator<EmployeeRecord> iterator = roster.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next().name());
        }
        return result;
    }

    static double totalSalary(List<EmployeeRecord> roster) {
        double total = 0;
        for (EmployeeRecord employee : roster) {
            total += employee.salary();
        }
        return total;
    }
}
