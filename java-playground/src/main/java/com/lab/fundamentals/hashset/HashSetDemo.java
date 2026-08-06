package com.lab.fundamentals.hashset;

import java.util.List;
import java.util.Set;

/**
 * HRMS skill tagging — unique HashSet skills plus contains/remove/retainAll in one flow.
 */
public class HashSetDemo {

    public static void main(String[] args) {
        SkillSetResult result = runSkillTagging(
                List.of("Java", "SQL", "Java", "HRIS", "Payroll", "SQL"),
                Set.of("Java", "SQL", "AWS"),
                "Payroll"
        );
        System.out.println(result);
    }

    static SkillSetResult runSkillTagging(
            List<String> rawSkills,
            Set<String> requiredSkills,
            String skillToRemove
    ) {
        String[] skillArray = rawSkills == null ? new String[0] : rawSkills.toArray(String[]::new);
        Set<String> unique = HashSetUniqueDemo.addSkills(skillArray);
        int uniqueCount = HashSetUniqueDemo.size(unique);

        boolean hadPayroll = HashSetOpsDemo.contains(unique, skillToRemove);
        boolean removed = HashSetOpsDemo.remove(unique, skillToRemove);
        Set<String> matchingRequired = HashSetOpsDemo.retainRequired(unique, requiredSkills);

        return new SkillSetResult(
                uniqueCount,
                hadPayroll,
                removed,
                matchingRequired,
                HashSetUniqueDemo.size(matchingRequired)
        );
    }

    record SkillSetResult(
            int uniqueSkillCount,
            boolean containedRemovedSkill,
            boolean removedSkill,
            Set<String> matchingRequiredSkills,
            int matchingCount
    ) {
        @Override
        public String toString() {
            return "SkillSet{unique=%d, containedRemoved=%b, removed=%b, matching=%s, matchingCount=%d}"
                    .formatted(uniqueSkillCount, containedRemovedSkill, removedSkill,
                            matchingRequiredSkills, matchingCount);
        }
    }
}
