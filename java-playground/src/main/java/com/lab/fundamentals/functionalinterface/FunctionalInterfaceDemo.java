package com.lab.fundamentals.functionalinterface;

import java.util.ArrayList;
import java.util.List;

/**
 * HRMS eligibility + directory flow — Predicate, Function, Consumer, and Supplier together.
 */
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        FunctionalFlowResult result = runFunctionalFlow(PredicateDemo.sampleRoster());
        System.out.println(result);
    }

    static FunctionalFlowResult runFunctionalFlow(List<Employee> roster) {
        ConsumerSupplierDemo.resetIdSequence(200);

        List<Employee> eligible = PredicateDemo.filter(
                roster, PredicateDemo.isActiveHighEarner(PredicateDemo.HIGH_EARNER_THRESHOLD));

        List<String> emails = FunctionDemo.mapEmails(eligible);
        List<String> directory = FunctionDemo.map(eligible, FunctionDemo.toDirectoryLine());

        List<String> auditLog = new ArrayList<>();
        ConsumerSupplierDemo.acceptAll(eligible, ConsumerSupplierDemo.logEmployee(auditLog));

        Employee newHire = ConsumerSupplierDemo.newHire("Neha", "People Ops", 70_000).get();
        String mintedId = newHire.id();

        return new FunctionalFlowResult(
                eligible.size(),
                emails,
                directory,
                auditLog,
                mintedId,
                newHire.email()
        );
    }

    record FunctionalFlowResult(
            int eligibleCount,
            List<String> emails,
            List<String> directoryLines,
            List<String> auditLog,
            String newEmployeeId,
            String newHireEmail
    ) {
        @Override
        public String toString() {
            return ("FunctionalFlow{eligible=%d, emails=%s, directory=%s, audit=%s, "
                    + "newId=%s, newEmail=%s}")
                    .formatted(eligibleCount, emails, directoryLines, auditLog,
                            newEmployeeId, newHireEmail);
        }
    }
}
