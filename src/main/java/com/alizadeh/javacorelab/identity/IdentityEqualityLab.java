package com.alizadeh.javacorelab.identity;

public class IdentityEqualityLab {

    public static void main(String[] args) {
        identityExperiment();
        defaultEqualsExperiment();
        overriddenEqualsExperiment();
        equalsReflexiveExperiment();
        equalsSymmetricExperiment();
        equalsTransitiveExperiment();
        equalsConsistencyExperiment();
        hashCodeWithoutOverrideExperiment();
    }

    // ************************************************************************************************************* //

    private static void identityExperiment() {
        System.out.println("=== Identity Experiment ===");

        Payment payment1 = new Payment(100);
        Payment payment2 = new Payment(100);
        Payment payment3 = payment1;

        System.out.println("payment1 == payment2 -> " + (payment1 == payment2));
        System.out.println("payment1 == payment3 -> " + (payment1 == payment3));

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void defaultEqualsExperiment() {
        System.out.println("=== Default equals() Experiment ===");

        Payment payment1 = new Payment(100);
        Payment payment2 = new Payment(100);
        Payment payment3 = payment1;

        System.out.println("payment1.equals(payment2) -> "
                + payment1.equals(payment2));

        System.out.println("payment1.equals(payment3) -> "
                + payment1.equals(payment3));

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void overriddenEqualsExperiment() {
        System.out.println("=== Overridden equals() Experiment ===");

        PaymentWithEquals payment1 = new PaymentWithEquals(100);
        PaymentWithEquals payment2 = new PaymentWithEquals(100);
        PaymentWithEquals payment3 = new PaymentWithEquals(900);

        System.out.println("payment1 == payment2 -> " + (payment1 == payment2));

        System.out.println("payment1.equals(payment2) -> " + payment1.equals(payment2));

        System.out.println("payment1.equals(payment3) -> " + payment1.equals(payment3));

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void equalsReflexiveExperiment() {
        System.out.println("=== equals() Reflexive Contract ===");

        PaymentWithEquals payment = new PaymentWithEquals(100);

        System.out.println("payment.equals(payment) -> " + payment.equals(payment));

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void equalsSymmetricExperiment() {
        System.out.println("=== equals() Symmetric Contract ===");

        PaymentWithEquals payment1 = new PaymentWithEquals(100);
        PaymentWithEquals payment2 = new PaymentWithEquals(100);

        System.out.println("payment1.equals(payment2) -> " + payment1.equals(payment2));

        System.out.println("payment2.equals(payment1) -> " + payment2.equals(payment1));

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void equalsTransitiveExperiment() {
        System.out.println("=== equals() Transitive Contract ===");

        PaymentWithEquals p1 = new PaymentWithEquals(100);
        PaymentWithEquals p2 = new PaymentWithEquals(100);
        PaymentWithEquals p3 = new PaymentWithEquals(100);

        System.out.println("p1.equals(p2) -> " + p1.equals(p2));
        System.out.println("p2.equals(p3) -> " + p2.equals(p3));
        System.out.println("p1.equals(p3) -> " + p1.equals(p3));

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void equalsConsistencyExperiment() {
        System.out.println("=== equals() Consistency Contract ===");

        PaymentWithEquals p1 = new PaymentWithEquals(100);
        PaymentWithEquals p2 = new PaymentWithEquals(100);

        System.out.println("first check  -> " + p1.equals(p2));
        System.out.println("second check -> " + p1.equals(p2));

        p2.amount = 900;

        System.out.println("after state change -> " + p1.equals(p2));

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void hashCodeWithoutOverrideExperiment() {
        System.out.println("=== hashCode() Without Override Experiment ===");

        PaymentWithEquals p1 = new PaymentWithEquals(100);
        PaymentWithEquals p2 = new PaymentWithEquals(100);

        System.out.println("p1.equals(p2) -> " + p1.equals(p2));

        System.out.println("p1.hashCode() -> " + p1.hashCode());
        System.out.println("p2.hashCode() -> " + p2.hashCode());

        System.out.println("same hashCode -> " + (p1.hashCode() == p2.hashCode()));

        System.out.println();
    }
}

