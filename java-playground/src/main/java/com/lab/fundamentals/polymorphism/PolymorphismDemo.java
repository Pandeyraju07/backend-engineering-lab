package com.lab.fundamentals.polymorphism;

/**
 * HRMS polymorphic payroll processor — runtime dispatch and upcasting in one flow.
 */
public class PolymorphismDemo {

    public static void main(String[] args) {
        PolyPayrollResult result = processPayroll(RuntimePolyDemo.samplePayroll());
        System.out.println(result);
    }

    static PolyPayrollResult processPayroll(Employee[] employees) {
        double total = RuntimePolyDemo.totalPay(employees);
        int permanentCount = RuntimePolyDemo.permanentCount(employees);

        Employee first = employees[0];
        String firstDescribe = UpcastingDemo.describe(first);

        PermanentEmployee samplePermanent = new PermanentEmployee(
                "EMP-501", "Kavita Nair", "HR", 80_000, 9_000);
        Employee upcastRef = UpcastingDemo.upcastPermanent(samplePermanent);
        String upcastDescribe = UpcastingDemo.describe(upcastRef);

        return new PolyPayrollResult(
                employees.length,
                permanentCount,
                total,
                firstDescribe,
                upcastDescribe,
                upcastRef.calculatePay()
        );
    }

    record PolyPayrollResult(
            int employeeCount,
            int permanentCount,
            double totalPay,
            String firstEmployeeDescribe,
            String upcastDescribe,
            double upcastPay
    ) {
        @Override
        public String toString() {
            return "PolyPayroll{count=%d, permanent=%d, total=%.2f, first=%s, upcastPay=%.2f}"
                    .formatted(employeeCount, permanentCount, totalPay, firstEmployeeDescribe, upcastPay);
        }
    }
}
