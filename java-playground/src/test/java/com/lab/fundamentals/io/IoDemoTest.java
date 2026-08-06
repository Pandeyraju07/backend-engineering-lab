package com.lab.fundamentals.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IoDemoTest {

    @Test
    void formattedOutputPadsEmployeeLine() {
        String line = FormattedOutputDemo.formatEmployeeLine("EMP-1001", "Raju Kumar", 82_000);

        assertTrue(line.contains("EMP-1001"));
        assertTrue(line.contains("Raju Kumar"));
        assertTrue(line.contains("82000.00"));
    }

    @Test
    void consoleReadParsesPipeDelimitedLine() {
        OnboardingForm form = ConsoleReadDemo.parseOnboardingLine("Raju Kumar|Backend Engineering|82000");

        assertEquals("Raju Kumar", form.name());
        assertEquals("Backend Engineering", form.department());
        assertEquals(82_000, form.salary());
    }

    @Test
    void scannerReadsCsvWithoutSystemIn() {
        OnboardingForm form = ScannerInputDemo.readForm("Priya Sharma,People Ops,75000");

        assertEquals("Priya Sharma", form.name());
        assertEquals("People Ops", form.department());
        assertEquals(75_000, form.salary());
    }

    @Test
    void onboardingIntegratesAllIoHelpers() {
        IoDemo.OnboardingResult result = IoDemo.runOnboardingFromSamples(
                "Raju Kumar|Backend Engineering|82000",
                "Priya Sharma,People Ops,75000"
        );

        assertEquals(2, result.formsProcessed());
        assertEquals("Raju Kumar", result.primaryForm().name());
        assertEquals("Priya Sharma", result.secondaryForm().name());
        assertTrue(result.formattedLine().contains("Raju Kumar"));
        assertTrue(result.formattedLine().contains("82000.00"));
    }
}
