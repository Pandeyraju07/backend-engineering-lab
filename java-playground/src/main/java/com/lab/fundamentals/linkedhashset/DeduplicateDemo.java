package com.lab.fundamentals.linkedhashset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** LinkedHashSet dedupe — drop later duplicates while preserving first occurrence. */
public class DeduplicateDemo {

    public static void main(String[] args) {
        List<String> raw = List.of("Engineering", "Finance", "Engineering", "Legal", "Finance");
        System.out.println("Deduped: " + dedupePreservingOrder(raw));
        System.out.println("Duplicates removed: " + duplicateCount(raw));
    }

    static List<String> dedupePreservingOrder(Collection<String> values) {
        if (values == null) {
            return List.of();
        }
        Set<String> ordered = new LinkedHashSet<>();
        for (String value : values) {
            if (value != null && !value.isBlank()) {
                ordered.add(value.trim());
            }
        }
        return new ArrayList<>(ordered);
    }

    static int duplicateCount(Collection<String> values) {
        if (values == null) {
            return 0;
        }
        int nonBlank = 0;
        for (String value : values) {
            if (value != null && !value.isBlank()) {
                nonBlank++;
            }
        }
        return nonBlank - dedupePreservingOrder(values).size();
    }

    static boolean firstOccurrenceKept(List<String> raw, List<String> deduped) {
        if (raw == null || deduped == null) {
            return false;
        }
        List<String> expected = dedupePreservingOrder(raw);
        return expected.equals(deduped);
    }
}
