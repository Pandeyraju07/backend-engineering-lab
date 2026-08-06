package com.lab.fundamentals.finalkeyword;

/**
 * Final class — EmployeeId cannot be subclassed; wrap and validate instead.
 */
public class FinalClassDemo {

    public static void main(String[] args) {
        System.out.println(wrap("emp-777"));
    }

    static EmployeeId wrap(String rawId) {
        return EmployeeId.of(rawId);
    }

    static String display(EmployeeId employeeId) {
        return "ID[" + employeeId.value() + "]";
    }

    static boolean acceptsNormalized(String rawId) {
        try {
            wrap(rawId);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    /** Immutable final HRMS employee id — no subclassing. */
    static final class EmployeeId {

        private final String value;

        private EmployeeId(String value) {
            this.value = value;
        }

        static EmployeeId of(String raw) {
            if (raw == null || raw.isBlank()) {
                throw new IllegalArgumentException("employee id is required");
            }
            return new EmployeeId(raw.trim().toUpperCase());
        }

        String value() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
