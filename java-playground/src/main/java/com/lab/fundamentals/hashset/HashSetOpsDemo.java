package com.lab.fundamentals.hashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/** HashSet operations — contains, remove, and retainAll for skill filtering. */
public class HashSetOpsDemo {

    public static void main(String[] args) {
        Set<String> skills = HashSetUniqueDemo.addSkills("Java", "SQL", "HRIS", "Payroll");
        System.out.println("Has Java? " + contains(skills, "Java"));
        System.out.println("Removed Payroll? " + remove(skills, "Payroll"));
        System.out.println("Intersection with required: " + retainRequired(skills, Set.of("Java", "SQL", "AWS")));
    }

    static boolean contains(Set<String> skills, String skill) {
        return skills != null && skill != null && skills.contains(skill);
    }

    static boolean remove(Set<String> skills, String skill) {
        return skills != null && skill != null && skills.remove(skill);
    }

    static Set<String> retainRequired(Set<String> skills, Collection<String> required) {
        Set<String> retained = skills == null ? new HashSet<>() : new HashSet<>(skills);
        if (required == null) {
            retained.clear();
            return retained;
        }
        retained.retainAll(required);
        return retained;
    }

    static boolean retainAllInPlace(Set<String> skills, Collection<String> required) {
        if (skills == null) {
            return false;
        }
        if (required == null) {
            skills.clear();
            return true;
        }
        return skills.retainAll(required);
    }
}
