package com.lab.fundamentals.treeset;

/** Package-local employee id used in sorted TreeSet demos. */
record EmployeeId(String value) implements Comparable<EmployeeId> {

    @Override
    public int compareTo(EmployeeId other) {
        return this.value.compareTo(other.value);
    }
}
