package com.lab.fundamentals.objects;

/**
 * Object identity — `==` (same reference) vs `equals` (same employeeId) in HRMS directories.
 */
public class ObjectIdentityDemo {

    public static void main(String[] args) {
        StaffMember left = ObjectCreationDemo.create("EMP-501", "Raju Kumar");
        StaffMember sameRef = left;
        StaffMember equalCopy = ObjectCreationDemo.create("EMP-501", "R. Kumar");
        StaffMember other = ObjectCreationDemo.create("EMP-502", "Ananya Sharma");

        System.out.println("Identity: sameReference=" + sameReference(left, sameRef));
        System.out.println("Identity: equalById=" + equalById(left, equalCopy));
        System.out.println("Identity: differentId=" + equalById(left, other));
    }

    static boolean sameReference(StaffMember left, StaffMember right) {
        return left == right;
    }

    static boolean equalById(StaffMember left, StaffMember right) {
        return left != null && left.equals(right);
    }
}
