package com.lab.fundamentals.priorityqueue;

/**
 * HRMS leave request. Lower {@code priority} value means more urgent (natural order).
 */
record LeaveRequest(int priority, String id, String employeeId, String reason)
        implements Comparable<LeaveRequest> {

    @Override
    public int compareTo(LeaveRequest other) {
        int byPriority = Integer.compare(this.priority, other.priority);
        if (byPriority != 0) {
            return byPriority;
        }
        return this.id.compareTo(other.id);
    }
}
