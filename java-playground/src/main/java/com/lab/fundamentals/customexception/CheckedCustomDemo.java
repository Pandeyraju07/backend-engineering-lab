package com.lab.fundamentals.customexception;

/**
 * Checked custom exception — validate EMP-#### style employee ids.
 */
public class CheckedCustomDemo {

    public static void main(String[] args) {
        try {
            System.out.println(validateEmployeeId("EMP-1001"));
            validateEmployeeId("bad");
        } catch (InvalidEmployeeException ex) {
            System.out.println("invalid: " + ex.getMessage());
        }
    }

    /**
     * Accepts non-blank ids matching {@code EMP-} followed by digits.
     * Throws checked {@link InvalidEmployeeException} otherwise.
     */
    static String validateEmployeeId(String employeeId) throws InvalidEmployeeException {
        if (employeeId == null || employeeId.isBlank()) {
            throw new InvalidEmployeeException("employee id is required");
        }
        String trimmed = employeeId.trim();
        if (!trimmed.matches("EMP-\\d+")) {
            throw new InvalidEmployeeException("employee id must match EMP-####: " + trimmed);
        }
        return trimmed;
    }
}
