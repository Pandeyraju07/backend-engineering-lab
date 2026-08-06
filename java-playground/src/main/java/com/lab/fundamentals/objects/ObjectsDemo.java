package com.lab.fundamentals.objects;

import java.util.Set;

/**
 * HRMS object identity flow — creation, == vs equals, and Set uniqueness by employeeId.
 */
public class ObjectsDemo {

    public static void main(String[] args) {
        ObjectIdentityResult result = analyzeIdentity(
                "EMP-701", "Priya Nair",
                "EMP-701", "P. Nair",
                "EMP-702", "Vikram Rao"
        );
        System.out.println(result);
    }

    static ObjectIdentityResult analyzeIdentity(
            String idA, String nameA,
            String idB, String nameB,
            String idC, String nameC
    ) {
        StaffMember first = ObjectCreationDemo.create(idA, nameA);
        StaffMember alias = first;
        StaffMember sameId = ObjectCreationDemo.create(idB, nameB);
        StaffMember other = ObjectCreationDemo.create(idC, nameC);

        boolean sameRef = ObjectIdentityDemo.sameReference(first, alias);
        boolean equalIds = ObjectIdentityDemo.equalById(first, sameId);
        boolean differentIds = ObjectIdentityDemo.equalById(first, other);
        Set<StaffMember> unique = EqualsHashCodeDemo.distinctById(first, sameId, other);

        return new ObjectIdentityResult(sameRef, equalIds, !differentIds, unique.size());
    }

    record ObjectIdentityResult(
            boolean sameReference,
            boolean equalById,
            boolean differentById,
            int distinctCount
    ) {
        @Override
        public String toString() {
            return "ObjectIdentity{sameReference=%b, equalById=%b, differentById=%b, distinctCount=%d}"
                    .formatted(sameReference, equalById, differentById, distinctCount);
        }
    }
}
