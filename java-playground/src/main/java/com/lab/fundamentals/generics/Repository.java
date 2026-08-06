package com.lab.fundamentals.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Type-safe in-memory store used across HRMS generics demos.
 *
 * @param <T> entity type held by this repository
 */
class Repository<T> {

    private final List<T> items = new ArrayList<>();

    void save(T item) {
        items.add(item);
    }

    Optional<T> find(Predicate<T> matcher) {
        for (T item : items) {
            if (matcher.test(item)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    List<T> findAll() {
        return List.copyOf(items);
    }

    int size() {
        return items.size();
    }
}
