package com.lab.fundamentals.objects;

import java.util.Objects;

/**
 * Staff member whose identity is the employeeId — equals/hashCode/toString follow that key.
 */
class StaffMember {

    private final String employeeId;
    private final String name;

    StaffMember(String employeeId, String name) {
        if (employeeId == null || employeeId.isBlank()) {
            throw new IllegalArgumentException("employeeId is required");
        }
        this.employeeId = employeeId;
        this.name = name == null ? "" : name;
    }

    String employeeId() {
        return employeeId;
    }

    String name() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StaffMember that)) {
            return false;
        }
        return employeeId.equals(that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @Override
    public String toString() {
        return "StaffMember{id='%s', name='%s'}".formatted(employeeId, name);
    }
}
