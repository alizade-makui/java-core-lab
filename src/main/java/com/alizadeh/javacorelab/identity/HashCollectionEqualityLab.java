package com.alizadeh.javacorelab.identity;

import java.util.HashSet;
import java.util.Set;

public class HashCollectionEqualityLab {

    public static void main(String[] args) {

        equalsAndHashCodeExperiment();
        brokenHashSetExperiment();
        brokenHashSetExperiment2();
        correctHashSetExperiment();
        mutableHashCodeExperiment();
    }

    // ************************************************************************************************************* //

    private static void equalsAndHashCodeExperiment() {
        System.out.println("=== equals() + hashCode() Experiment ===");

        PaymentWithEqualsAndHashCode p1 = new PaymentWithEqualsAndHashCode(100);

        PaymentWithEqualsAndHashCode p2 = new PaymentWithEqualsAndHashCode(100);

        PaymentWithEqualsAndHashCode p3 = new PaymentWithEqualsAndHashCode(900);

        System.out.println("p1.equals(p2) -> " + p1.equals(p2));
        System.out.println("p1.equals(p3) -> " + p1.equals(p3));

        System.out.println("p1.hashCode() == p2.hashCode() -> " + (p1.hashCode() == p2.hashCode()));

        System.out.println("p1.hashCode() == p3.hashCode() -> " + (p1.hashCode() == p3.hashCode()));

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void brokenHashSetExperiment() {
        System.out.println("=== Broken HashSet Experiment ===");

        PaymentWithEquals p1 = new PaymentWithEquals(100);
        PaymentWithEquals p2 = new PaymentWithEquals(100);

        Set<PaymentWithEquals> payments = new HashSet<>();

        payments.add(p1);
        payments.add(p2);

        System.out.println("p1.equals(p2) -> " + p1.equals(p2));
        System.out.println("set size -> " + payments.size());

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void brokenHashSetExperiment2() {
        System.out.println("=== Broken HashSet Experiment 2 ===");

        PaymentWithEquals p3 = new PaymentWithEquals(500);
        PaymentWithEquals p4 = new PaymentWithEquals(500);

        Set<PaymentWithEquals> payments = new HashSet<>();

        payments.add(p3);
        payments.add(p4);

        System.out.println("p3.equals(p4) -> " + p3.equals(p4));

        System.out.println("p3.hashCode() -> " + p3.hashCode());
        System.out.println("p4.hashCode() -> " + p4.hashCode());

        System.out.println(
                "same hashCode -> " + (p3.hashCode() == p4.hashCode())
        );

        System.out.println("set size -> " + payments.size());

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void correctHashSetExperiment() {
        System.out.println("=== Correct HashSet Experiment ===");

        PaymentWithEqualsAndHashCode p5 =
                new PaymentWithEqualsAndHashCode(100);

        PaymentWithEqualsAndHashCode p6 =
                new PaymentWithEqualsAndHashCode(100);

        Set<PaymentWithEqualsAndHashCode> payments = new HashSet<>();

        payments.add(p5);
        payments.add(p6);

        System.out.println("p5.equals(p6) -> " + p5.equals(p6));

        System.out.println("p5.hashCode() -> " + p5.hashCode());
        System.out.println("p6.hashCode() -> " + p6.hashCode());

        System.out.println(
                "same hashCode -> " + (p5.hashCode() == p6.hashCode())
        );

        System.out.println("set size -> " + payments.size());

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void mutableHashCodeExperiment() {
        System.out.println("=== Mutable HashCode Experiment ===");

        PaymentWithEqualsAndHashCode payment = new PaymentWithEqualsAndHashCode(100);

        Set<PaymentWithEqualsAndHashCode> payments = new HashSet<>();

        payments.add(payment);

        System.out.println("contains before mutation -> " + payments.contains(payment));

        System.out.println("hashCode before mutation -> " + payment.hashCode());

        payment.amount = 200;

        System.out.println("hashCode after mutation -> " + payment.hashCode());

        System.out.println("contains after mutation -> " + payments.contains(payment));

        System.out.println("set size -> " + payments.size());

        System.out.println();
    }

    // ************************************************************************************************************* //

}
