package com.lab.fundamentals.constructors;

/**
 * Constructor chaining via {@code this()} — intern hire fills defaults then chains to full ctor.
 */
public class ConstructorChainingDemo {

    private static final String INTERN_PREFIX = "INT-";
    private static final String INTERN_ROLE = "Intern";
    private static final double INTERN_STIPEND = 25_000;
    private static int internSequence = 5000;

    public static void main(String[] args) {
        Worker intern = createIntern("Priya Nair");
        System.out.println("Constructor chaining: " + intern);
    }

    /**
     * Creates an intern; {@link Worker} chains {@code this(...)} into the full four-arg constructor.
     */
    static Worker createIntern(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("intern name is required");
        }
        String id = INTERN_PREFIX + (++internSequence);
        return new Worker(id, name, INTERN_ROLE, INTERN_STIPEND);
    }

    static boolean isIntern(Worker worker) {
        return worker != null
                && INTERN_ROLE.equals(worker.role())
                && worker.employeeId() != null
                && worker.employeeId().startsWith(INTERN_PREFIX);
    }
}
