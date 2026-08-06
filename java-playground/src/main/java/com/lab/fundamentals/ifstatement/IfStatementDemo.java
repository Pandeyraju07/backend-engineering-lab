package com.lab.fundamentals.ifstatement;

/**
 * HRMS leave approval — uses if/else, nested if, and ternary in one decision flow.
 */
public class IfStatementDemo {

    public static void main(String[] args) {
        LeaveDecision decision = decideLeave(
                new LeaveRequest("EMP-301", 6, "Family emergency", 8, true));
        System.out.println(decision);
    }

    static LeaveDecision decideLeave(LeaveRequest request) {
        boolean balanceOk = IfElseDemo.approveIfBalance(request);
        String status = NestedIfDemo.resolveLeaveStatus(request);
        String urgency = TernaryDemo.urgencyLabel(request.days());
        String payStatus = TernaryDemo.payStatus("APPROVED".equals(status));

        return new LeaveDecision(
                request.employeeId(),
                status,
                urgency,
                payStatus,
                balanceOk
        );
    }

    record LeaveDecision(
            String employeeId,
            String status,
            String urgency,
            String payStatus,
            boolean balanceOk
    ) {
        @Override
        public String toString() {
            return "LeaveDecision{employeeId='%s', status=%s, urgency=%s, payStatus=%s, balanceOk=%b}"
                    .formatted(employeeId, status, urgency, payStatus, balanceOk);
        }
    }
}
