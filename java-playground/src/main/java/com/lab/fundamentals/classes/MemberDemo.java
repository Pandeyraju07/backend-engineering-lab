package com.lab.fundamentals.classes;

/**
 * Instance vs static members — track active headcount across HRMS employee instances.
 */
public class MemberDemo {

    public static void main(String[] args) {
        ActiveRoster.reset();
        Employee first = ClassStructureDemo.hire("EMP-1", "Ananya Sharma", "HR", 70_000);
        Employee second = ClassStructureDemo.hire("EMP-2", "Vikram Rao", "Finance", 72_000);
        second.deactivate();

        ActiveRoster.register(first);
        ActiveRoster.register(second);

        System.out.println("Members: activeCount=" + ActiveRoster.countActive());
        System.out.println("Members: totalRegistered=" + ActiveRoster.totalRegistered());
    }

    static int countActive(Employee... employees) {
        int active = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.active()) {
                active++;
            }
        }
        return active;
    }

    /** Small helper showing a shared static counter plus per-employee instance state. */
    static final class ActiveRoster {
        private static int totalRegistered;
        private static int activeCount;

        private ActiveRoster() {
        }

        static void reset() {
            totalRegistered = 0;
            activeCount = 0;
        }

        static void register(Employee employee) {
            if (employee == null) {
                return;
            }
            totalRegistered++;
            if (employee.active()) {
                activeCount++;
            }
        }

        static int countActive() {
            return activeCount;
        }

        static int totalRegistered() {
            return totalRegistered;
        }
    }
}
