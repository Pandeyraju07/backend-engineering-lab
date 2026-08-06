package com.lab.fundamentals.accessmodifiers;

/**
 * HRMS access-control lesson — public/private and protected/default in one flow.
 */
public class AccessModifiersDemo {

    public static void main(String[] args) {
        AccessResult result = reviewAccess("EMP-3100", "Raju Kumar", 82_000,
                "EMP-3101", "Engineering", 70_000, "Engineer", 0.10);
        System.out.println(result);
    }

    static AccessResult reviewAccess(
            String publicId,
            String publicName,
            double publicSalary,
            String subId,
            String department,
            double basePay,
            String title,
            double raisePercent
    ) {
        PublicEmployee publicEmployee =
                PublicPrivateDemo.createPublicEmployee(publicId, publicName, publicSalary);
        double raisedPublicSalary = PublicPrivateDemo.raiseSalary(publicEmployee, 5_000);

        SubEmployee subEmployee =
                ProtectedDefaultDemo.createSubEmployee(subId, department, basePay, title);
        double raisedBasePay = ProtectedDefaultDemo.grantRaise(subEmployee, raisePercent);

        PackageEmployee packageEmployee =
                ProtectedDefaultDemo.createPackageEmployee(subId + "-PKG", department, basePay);

        return new AccessResult(
                PublicPrivateDemo.describe(publicEmployee),
                raisedPublicSalary,
                ProtectedDefaultDemo.describe(subEmployee),
                raisedBasePay,
                packageEmployee.summary()
        );
    }

    record AccessResult(
            String publicEmployeeView,
            double publicSalaryAfterRaise,
            String subEmployeeView,
            double subBasePayAfterRaise,
            String packageEmployeeSummary
    ) {
        @Override
        public String toString() {
            return "AccessResult{public=%s, publicSalary=%.2f, sub=%s, subBasePay=%.2f, package=%s}"
                    .formatted(
                            publicEmployeeView,
                            publicSalaryAfterRaise,
                            subEmployeeView,
                            subBasePayAfterRaise,
                            packageEmployeeSummary
                    );
        }
    }
}
