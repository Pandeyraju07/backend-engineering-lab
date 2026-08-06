package com.lab.fundamentals.hashset;

import java.util.HashSet;
import java.util.Set;

/** HashSet uniqueness — employee skill tags with no duplicates. */
public class HashSetUniqueDemo {

    public static void main(String[] args) {
        Set<String> skills = addSkills("Java", "SQL", "Java", "HRIS", "SQL");
        System.out.println("Unique skills: " + skills);
        System.out.println("Size: " + size(skills));
    }

    static Set<String> addSkills(String... skills) {
        Set<String> unique = new HashSet<>();
        if (skills == null) {
            return unique;
        }
        for (String skill : skills) {
            if (skill != null && !skill.isBlank()) {
                unique.add(skill.trim());
            }
        }
        return unique;
    }

    static int size(Set<String> skills) {
        return skills == null ? 0 : skills.size();
    }

    static Set<SkillTag> asSkillTags(String... skills) {
        Set<SkillTag> tags = new HashSet<>();
        for (String skill : addSkills(skills)) {
            tags.add(new SkillTag(skill));
        }
        return tags;
    }
}
