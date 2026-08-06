package com.lab.fundamentals.ifstatement;

/** Simple if/else — approve leave when requested days fit remaining balance. */
public class IfElseDemo {

    public static void main(String[] args) {
        LeaveRequest ok = new LeaveRequest("EMP-101", 3, "Medical", 5, false);
        LeaveRequest over = new LeaveRequest("EMP-102", 8, "Travel", 5, false);

        System.out.println("Balance OK for EMP-101: " + approveIfBalance(ok));
        System.out.println("Balance OK for EMP-102: " + approveIfBalance(over));
    }

    static boolean approveIfBalance(LeaveRequest request) {
        if (request.days() > 0 && request.days() <= request.remainingBalance()) {
            return true;
        } else {
            return false;
        }
    }
}
