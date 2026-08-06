package com.lab.fundamentals.functionalinterface;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FunctionalInterfaceDemoTest {

    @Test
    void predicatesFilterActiveAndHighEarners() {
        List<Employee> roster = PredicateDemo.sampleRoster();

        assertEquals(3, PredicateDemo.filter(roster, PredicateDemo.isActive()).size());
        assertEquals(3, PredicateDemo.filter(
                roster, PredicateDemo.isHighEarner(PredicateDemo.HIGH_EARNER_THRESHOLD)).size());
        assertEquals(2, PredicateDemo.filter(
                roster, PredicateDemo.isActiveHighEarner(PredicateDemo.HIGH_EARNER_THRESHOLD)).size());
        assertTrue(PredicateDemo.isActive().test(roster.get(0)));
        assertFalse(PredicateDemo.isActive().test(roster.get(2)));
    }

    @Test
    void functionMapsEmployeeToEmail() {
        Employee asha = new Employee("E001", "Asha", "Engineering", "asha@hrms.lab", 95_000, true);

        assertEquals("asha@hrms.lab", FunctionDemo.toEmail().apply(asha));
        assertEquals("asha@hrms.lab", FunctionDemo.mapEmails(List.of(asha)).get(0));
        assertEquals("neha.sharma@hrms.lab",
                FunctionDemo.corporateEmailFromName().apply("Neha Sharma"));
        assertTrue(FunctionDemo.toDirectoryLine().apply(asha).contains("asha@hrms.lab"));
    }

    @Test
    void consumerLogsAndSupplierMintsIds() {
        ConsumerSupplierDemo.resetIdSequence(50);
        List<String> audit = new ArrayList<>();
        Employee asha = new Employee("E001", "Asha", "Engineering", "asha@hrms.lab", 95_000, true);

        ConsumerSupplierDemo.logEmployee(audit).accept(asha);
        assertEquals(1, audit.size());
        assertTrue(audit.get(0).contains("E001"));

        assertEquals("E50", ConsumerSupplierDemo.newId().get());
        Employee hire = ConsumerSupplierDemo.newHire("Vikram", "Finance", 77_000).get();
        assertEquals("E51", hire.id());
        assertEquals("vikram@hrms.lab", hire.email());
        assertTrue(hire.active());
    }

    @Test
    void functionalFlowIntegratesValidatorsMappersAndFactories() {
        FunctionalInterfaceDemo.FunctionalFlowResult result =
                FunctionalInterfaceDemo.runFunctionalFlow(PredicateDemo.sampleRoster());

        assertEquals(2, result.eligibleCount());
        assertEquals(List.of("asha@hrms.lab", "kiran@hrms.lab"), result.emails());
        assertEquals(2, result.directoryLines().size());
        assertEquals(2, result.auditLog().size());
        assertEquals("E200", result.newEmployeeId());
        assertEquals("neha@hrms.lab", result.newHireEmail());
    }
}
