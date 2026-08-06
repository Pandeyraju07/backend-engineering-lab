package com.lab.fundamentals.polymorphism;

/**
 * Runtime polymorphism — Employee[] holds mixed types; calculatePay() dispatches by type.
 */
public class RuntimePolyDemo {

    public static void main(String[] args) {
        Employee[] payroll = samplePayroll();
        System.out.printf("RuntimePoly: count=%d, totalPay=%.2f%n",
                payroll.length, totalPay(payroll));
    }

    static Employee[] samplePayroll() {
        return new Employee[]{
                new PermanentEmployee("EMP-401", "Raju Kumar", "Engineering", 90_000, 10_000),
                new ContractEmployee("EMP-402", "Meera Shah", "Design", 750, 160),
                new PermanentEmployee("EMP-403", "Arjun Das", "QA", 70_000, 7_000)
        };
    }

    static double totalPay(Employee[] employees) {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.calculatePay();
        }
        return total;
    }

    static int permanentCount(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if ("PERMANENT".equals(employee.employmentType())) {
                count++;
            }
        }
        return count;
    }
}
