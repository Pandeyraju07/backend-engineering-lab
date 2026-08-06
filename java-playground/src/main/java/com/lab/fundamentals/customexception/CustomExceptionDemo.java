package com.lab.fundamentals.customexception;

/**
 * HRMS custom exceptions — checked employee id + unchecked net-pay guards in one flow.
 */
public class CustomExceptionDemo {

    public static void main(String[] args) {
        CustomExceptionFlowResult result = runCustomExceptionFlow("EMP-2201", 68_000);
        System.out.println(result);
    }

    static CustomExceptionFlowResult runCustomExceptionFlow(String employeeId, double netPay) {
        String validatedId = "";
        boolean idValid;
        try {
            validatedId = CheckedCustomDemo.validateEmployeeId(employeeId);
            idValid = true;
        } catch (InvalidEmployeeException ex) {
            idValid = false;
        }

        boolean badIdRejected;
        try {
            CheckedCustomDemo.validateEmployeeId("NOT-AN-ID");
            badIdRejected = false;
        } catch (InvalidEmployeeException ex) {
            badIdRejected = true;
        }

        boolean netPayOk;
        double acceptedNet = 0;
        try {
            acceptedNet = UncheckedCustomDemo.requireNetPay(netPay);
            netPayOk = true;
        } catch (PayrollRuntimeException ex) {
            netPayOk = false;
        }

        boolean negativeNetRejected;
        try {
            UncheckedCustomDemo.requireNetPay(-1);
            negativeNetRejected = false;
        } catch (PayrollRuntimeException ex) {
            negativeNetRejected = true;
        }

        boolean flowOk = idValid && netPayOk && badIdRejected && negativeNetRejected;
        String summary = flowOk
                ? "OK|%s|%.2f".formatted(validatedId, acceptedNet)
                : "FAIL|idValid=%b|netPayOk=%b".formatted(idValid, netPayOk);

        return new CustomExceptionFlowResult(
                validatedId,
                acceptedNet,
                idValid,
                netPayOk,
                badIdRejected,
                negativeNetRejected,
                flowOk,
                summary
        );
    }

    record CustomExceptionFlowResult(
            String employeeId,
            double netPay,
            boolean idValid,
            boolean netPayOk,
            boolean badIdRejected,
            boolean negativeNetRejected,
            boolean flowOk,
            String summary
    ) {
        @Override
        public String toString() {
            return "CustomExceptionFlowResult{id=%s, net=%.2f, flowOk=%b, summary=%s}"
                    .formatted(employeeId, netPay, flowOk, summary);
        }
    }
}
