package com.lab.fundamentals.classes;

/**
 * HRMS class fundamentals — create employees, mutate state, and track active headcount.
 */
public class ClassesDemo {

    public static void main(String[] args) {
        ClassDemoResult result = onboardAndTrack("EMP-410", "Priya Nair", "Engineering", 80_000, 0.08);
        System.out.println(result);
    }

    static ClassDemoResult onboardAndTrack(
            String employeeId,
            String name,
            String department,
            double salary,
            double raisePercent
    ) {
        MemberDemo.ActiveRoster.reset();

        Employee sample = ClassStructureDemo.createSample();
        Employee hired = ClassStructureDemo.hire(employeeId, name, department, salary);
        hired.applyRaise(raisePercent);
        hired.transferTo(department + " Ops");

        MemberDemo.ActiveRoster.register(sample);
        MemberDemo.ActiveRoster.register(hired);

        int activeAmong = MemberDemo.countActive(sample, hired);
        return new ClassDemoResult(
                hired,
                sample,
                activeAmong,
                MemberDemo.ActiveRoster.countActive(),
                MemberDemo.ActiveRoster.totalRegistered()
        );
    }

    record ClassDemoResult(
            Employee hired,
            Employee sample,
            int activeAmongPair,
            int rosterActiveCount,
            int rosterTotal
    ) {
        @Override
        public String toString() {
            return "ClassDemo{hired=%s, sampleActive=%b, activeAmong=%d, rosterActive=%d, rosterTotal=%d}"
                    .formatted(hired, sample.active(), activeAmongPair, rosterActiveCount, rosterTotal);
        }
    }
}
