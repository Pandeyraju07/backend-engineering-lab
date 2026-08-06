package com.lab.fundamentals.inheritance;

/**
 * super() constructor chaining and super.method() from PermanentEmployee.describe().
 */
public class SuperKeywordDemo {

    public static void main(String[] args) {
        PermanentEmployee emp = new PermanentEmployee(
                "EMP-102", "Anita Sharma", "HR", 75_000, 8_000, 0.10);
        System.out.println(describe(emp));
    }

    /**
     * describe() on PermanentEmployee calls super.describe() then appends permanent details.
     */
    static String describe(PermanentEmployee employee) {
        return employee.describe();
    }

    /** True when description includes both base Employee text and permanent suffix. */
    static boolean usesSuperDescribe(PermanentEmployee employee) {
        String text = describe(employee);
        return text.startsWith("Employee{") && text.contains("[permanent");
    }
}
