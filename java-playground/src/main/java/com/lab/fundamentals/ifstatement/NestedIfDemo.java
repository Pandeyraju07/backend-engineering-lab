package com.lab.fundamentals.ifstatement;

/**
 * Nested if — leave workflow status from balance and manager approval.
 * Returns APPROVED, REJECTED, or PENDING.
 */
public class NestedIfDemo {

    public static void main(String[] args) {
        LeaveRequest approved = new LeaveRequest("EMP-201", 2, "Personal", 10, true);
        LeaveRequest pending = new LeaveRequest("EMP-202", 2, "Personal", 10, false);
        LeaveRequest rejected = new LeaveRequest("EMP-203", 12, "Travel", 5, true);

        System.out.println("EMP-201: " + resolveLeaveStatus(approved));
        System.out.println("EMP-202: " + resolveLeaveStatus(pending));
        System.out.println("EMP-203: " + resolveLeaveStatus(rejected));
    }

    static String resolveLeaveStatus(LeaveRequest request) {
        if (request.days() > 0) {
            if (request.days() <= request.remainingBalance()) {
                if (request.managerApproved()) {
                    return "APPROVED";
                } else {
                    return "PENDING";
                }
            } else {
                return "REJECTED";
            }
        } else {
            return "REJECTED";
        }
    }
}
