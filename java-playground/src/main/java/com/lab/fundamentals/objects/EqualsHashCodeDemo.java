package com.lab.fundamentals.objects;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * equals/hashCode — Set uniqueness keyed by employeeId for HRMS staff directories.
 */
public class EqualsHashCodeDemo {

    public static void main(String[] args) {
        StaffMember[] members = {
                ObjectCreationDemo.create("EMP-501", "Raju Kumar"),
                ObjectCreationDemo.create("EMP-501", "R. Kumar"),
                ObjectCreationDemo.create("EMP-502", "Ananya Sharma")
        };
        Set<StaffMember> unique = distinctById(members);
        System.out.println("Equals/hashCode: uniqueCount=" + unique.size() + ", set=" + unique);
    }

    static Set<StaffMember> distinctById(StaffMember... members) {
        Set<StaffMember> unique = new LinkedHashSet<>();
        if (members == null) {
            return unique;
        }
        for (StaffMember member : members) {
            if (member != null) {
                unique.add(member);
            }
        }
        return unique;
    }
}
