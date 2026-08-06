package com.lab.fundamentals.ifstatement;

/** Leave request used across if-statement demos (HRMS leave module). */
record LeaveRequest(
        String employeeId,
        int days,
        String reason,
        int remainingBalance,
        boolean managerApproved
) {
}
