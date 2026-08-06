package com.lab.fundamentals.ifstatement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IfStatementDemoTest {

    @Test
    void ifElseApprovesWhenBalanceCoversDays() {
        LeaveRequest ok = new LeaveRequest("EMP-1", 3, "Medical", 5, false);
        LeaveRequest over = new LeaveRequest("EMP-2", 8, "Travel", 5, false);

        assertTrue(IfElseDemo.approveIfBalance(ok));
        assertFalse(IfElseDemo.approveIfBalance(over));
    }

    @Test
    void nestedIfResolvesApprovedPendingRejected() {
        assertEquals("APPROVED", NestedIfDemo.resolveLeaveStatus(
                new LeaveRequest("EMP-3", 2, "Personal", 10, true)));
        assertEquals("PENDING", NestedIfDemo.resolveLeaveStatus(
                new LeaveRequest("EMP-4", 2, "Personal", 10, false)));
        assertEquals("REJECTED", NestedIfDemo.resolveLeaveStatus(
                new LeaveRequest("EMP-5", 12, "Travel", 5, true)));
        assertEquals("REJECTED", NestedIfDemo.resolveLeaveStatus(
                new LeaveRequest("EMP-6", 0, "None", 5, true)));
    }

    @Test
    void ternaryLabelsUrgencyAndPayStatus() {
        assertEquals("NORMAL", TernaryDemo.urgencyLabel(2));
        assertEquals("HIGH", TernaryDemo.urgencyLabel(5));
        assertEquals("PAID_LEAVE", TernaryDemo.payStatus(true));
        assertEquals("UNPAID_HOLD", TernaryDemo.payStatus(false));
    }

    @Test
    void leaveDecisionUsesAllIfStyles() {
        IfStatementDemo.LeaveDecision approved = IfStatementDemo.decideLeave(
                new LeaveRequest("EMP-7", 6, "Family emergency", 8, true));

        assertEquals("EMP-7", approved.employeeId());
        assertEquals("APPROVED", approved.status());
        assertEquals("HIGH", approved.urgency());
        assertEquals("PAID_LEAVE", approved.payStatus());
        assertTrue(approved.balanceOk());

        IfStatementDemo.LeaveDecision pending = IfStatementDemo.decideLeave(
                new LeaveRequest("EMP-8", 2, "Personal", 5, false));

        assertEquals("PENDING", pending.status());
        assertEquals("NORMAL", pending.urgency());
        assertEquals("UNPAID_HOLD", pending.payStatus());
        assertTrue(pending.balanceOk());
    }
}
