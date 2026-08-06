package com.lab.fundamentals.trycatch;

/**
 * HRMS safe payroll parse — try/catch/finally, multi-catch, and try-with-resources in one flow.
 */
public class TryCatchDemo {

    public static void main(String[] args) {
        ParseResult result = parsePayrollSafely(new PayrollLine("EMP-9001|85000.50"));
        System.out.println(result);
    }

    /**
     * Reads the first line from {@code payroll.rawLine()}, splits {@code id|salary},
     * multi-catch-safe headcount token from id suffix length, and try/finally salary parse.
     */
    static ParseResult parsePayrollSafely(PayrollLine payroll) {
        String raw = payroll == null ? null : payroll.rawLine();
        String firstLine = TryWithResourcesDemo.readFirstLine(raw == null ? "" : raw);

        String employeeId = "";
        String salaryToken = "0";
        if (firstLine != null && !firstLine.isBlank()) {
            String[] parts = firstLine.split("\\|", 2);
            employeeId = parts[0].trim();
            if (parts.length > 1) {
                salaryToken = parts[1].trim();
            }
        }

        TryCatchFinallyDemo.SalaryParseOutcome salaryOutcome =
                TryCatchFinallyDemo.parseSalary(salaryToken);

        // Multi-catch demo: parse a digit token; invalid/null → -1
        String digitToken = employeeId.replaceAll("\\D", "");
        int parsedCode = MultiCatchDemo.safeParseInt(digitToken.isEmpty() ? null : digitToken);

        boolean ok = salaryOutcome.success() && salaryOutcome.finallyRan() && !employeeId.isBlank();
        return new ParseResult(
                employeeId,
                salaryOutcome.salary(),
                salaryOutcome.finallyRan(),
                parsedCode,
                ok
        );
    }

    record ParseResult(
            String employeeId,
            double salary,
            boolean finallyRan,
            int parsedCode,
            boolean success
    ) {
        @Override
        public String toString() {
            return "ParseResult{id=%s, salary=%.2f, finallyRan=%b, code=%d, success=%b}"
                    .formatted(employeeId, salary, finallyRan, parsedCode, success);
        }
    }
}
