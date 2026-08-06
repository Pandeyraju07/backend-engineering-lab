package com.lab.fundamentals.io;

/**
 * HRMS CLI-style onboarding — formatted output, pipe parsing, and Scanner CSV in one flow.
 * Sample strings only; never blocks on real System.in.
 */
public class IoDemo {

    public static void main(String[] args) {
        OnboardingResult result = runOnboardingFromSamples(
                "Raju Kumar|Backend Engineering|82000",
                "Priya Sharma,People Ops,75000"
        );
        System.out.println(result);
        System.out.println(result.formattedLine());
    }

    /**
     * Integrates pipe-delimited console parse + CSV Scanner read, then formats a report line.
     *
     * @param pipeLine sample {@code name|dept|salary}
     * @param csvLine  sample {@code name,dept,salary}
     */
    static OnboardingResult runOnboardingFromSamples(String pipeLine, String csvLine) {
        OnboardingForm fromPipe = ConsoleReadDemo.parseOnboardingLine(pipeLine);
        OnboardingForm fromCsv = ScannerInputDemo.readForm(csvLine);

        String employeeId = "EMP-" + Math.abs(fromPipe.name().hashCode() % 10_000);
        String formattedLine = FormattedOutputDemo.formatEmployeeLine(
                employeeId, fromPipe.name(), fromPipe.salary());

        return new OnboardingResult(fromPipe, fromCsv, formattedLine, 2);
    }

    record OnboardingResult(
            OnboardingForm primaryForm,
            OnboardingForm secondaryForm,
            String formattedLine,
            int formsProcessed
    ) {
        @Override
        public String toString() {
            return "OnboardingResult{primary=%s, secondary=%s, forms=%d}"
                    .formatted(primaryForm, secondaryForm, formsProcessed);
        }
    }
}
