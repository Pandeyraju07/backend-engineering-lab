package com.lab.fundamentals.statickeyword;

/**
 * Static initializer block — loads the company name once when the class loads.
 */
public class StaticBlockDemo {

    private static final String COMPANY;

    static {
        COMPANY = "Acme HRMS Labs";
    }

    public static void main(String[] args) {
        System.out.println(companyName());
    }

    static String companyName() {
        return COMPANY;
    }

    static String brandedId(String employeeId) {
        return companyName() + "/" + employeeId;
    }
}
