package com.lab.fundamentals.constructors;

/**
 * HRMS hiring desk — default, parameterized, and chained constructors in one flow.
 */
public class ConstructorsDemo {

    public static void main(String[] args) {
        ConstructionResult result = hireTeam("EMP-2100", "Anita Desai", 95_000, "Vikram Shah");
        System.out.println(result);
    }

    /**
     * Builds a placeholder worker, a full hire, and an intern via the three constructor demos.
     */
    static ConstructionResult hireTeam(String hireId, String hireName, double hireSalary, String internName) {
        Worker placeholder = DefaultConstructorDemo.createDefaultWorker();
        Worker hire = ParameterizedConstructorDemo.create(hireId, hireName, hireSalary);
        Worker intern = ConstructorChainingDemo.createIntern(internName);

        return new ConstructionResult(
                placeholder,
                hire,
                intern,
                DefaultConstructorDemo.isPlaceholder(placeholder),
                ConstructorChainingDemo.isIntern(intern)
        );
    }

    record ConstructionResult(
            Worker placeholder,
            Worker hire,
            Worker intern,
            boolean placeholderDetected,
            boolean internDetected
    ) {
        @Override
        public String toString() {
            return "ConstructionResult{placeholder=%s, hire=%s, intern=%s, placeholderOk=%b, internOk=%b}"
                    .formatted(placeholder, hire, intern, placeholderDetected, internDetected);
        }
    }
}
