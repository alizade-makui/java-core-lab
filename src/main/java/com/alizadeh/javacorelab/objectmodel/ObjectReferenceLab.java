package com.alizadeh.javacorelab.objectmodel;

public class ObjectReferenceLab {

    public static void main(String[] args) {

        mutationExperiment();
        reassignmentExperiment();
        nullReferenceExperiment();
        unreachableObjectExperiment();
        parameterPassingExperiment();
        primitiveParameterExperiment();
        stackHeapExperiment();
        lifetimeExperiment();
        earlyUnreachableExperiment();
    }

    // ************************************************************************************************************* //

    private static void mutationExperiment() {
        System.out.println("=== Mutation Experiment ===");

        PaymentRequest request1 = new PaymentRequest(100);
        PaymentRequest request2 = request1;

        request2.amount = 500;

        System.out.println("request1.amount = " + request1.amount);
        System.out.println("request2.amount = " + request2.amount);
        System.out.println("request1 == request2 -> " + (request1 == request2));

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void reassignmentExperiment() {
        System.out.println("=== Reassignment Experiment ===");

        PaymentRequest request1 = new PaymentRequest(100);
        PaymentRequest request2 = request1;

        request2 = new PaymentRequest(900);

        System.out.println("request1.amount = " + request1.amount);
        System.out.println("request2.amount = " + request2.amount);
        System.out.println("request1 == request2 -> " + (request1 == request2));

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void nullReferenceExperiment() {
        System.out.println("=== Null Reference Experiment ===");

        PaymentRequest request1 = new PaymentRequest(100);
        PaymentRequest request2 = request1;

        request2 = null;

        System.out.println("request1.amount = " + request1.amount);
        System.out.println("request2 = " + request2);

        System.out.println();
    }

    private static void unreachableObjectExperiment() {
        System.out.println("=== Unreachable Object Experiment ===");

        PaymentRequest request1 = new PaymentRequest(100);
        PaymentRequest request2 = request1;

        request1 = null;
        request2 = null;

        System.out.println("request1 = " + request1);
        System.out.println("request2 = " + request2);
        System.out.println("The PaymentRequest object is now unreachable from these references.");

        System.out.println();
    }

    // ************************************************************************************************************* //

    private static void parameterPassingExperiment() {
        System.out.println("=== Parameter Passing Experiment ===");

        PaymentRequest request = new PaymentRequest(100);

        mutateParameter(request);

        System.out.println("After mutation:");
        System.out.println("request.amount = " + request.amount);

        reassignParameter(request);

        System.out.println("After parameter reassignment:");
        System.out.println("request.amount = " + request.amount);

        System.out.println();
    }

    private static void mutateParameter(PaymentRequest param) {
        param.amount = 500;
    }

    private static void reassignParameter(PaymentRequest param) {
        param = new PaymentRequest(900);

        System.out.println("Inside reassignParameter:");
        System.out.println("param.amount = " + param.amount);
    }

    // ************************************************************************************************************* //

    private static void primitiveParameterExperiment() {
        System.out.println("=== Primitive Parameter Experiment ===");

        int amount = 100;

        changePrimitive(amount);

        System.out.println("amount after method call = " + amount);

        System.out.println();
    }

    private static void changePrimitive(int value) {
        value = 500;

        System.out.println("value inside method = " + value);
    }

    // ************************************************************************************************************* //

    private static void stackHeapExperiment() {
        System.out.println("=== Stack / Heap Experiment ===");

        PaymentRequest request = new PaymentRequest(100);

        updateAmount(request);

        System.out.println("request.amount = " + request.amount);

        System.out.println();
    }

    private static void updateAmount(PaymentRequest param) {
        param.amount = 700;
    }

    // ************************************************************************************************************* //

    private static void lifetimeExperiment() {
        System.out.println("=== Object Lifetime Experiment ===");

        PaymentRequest payment = createRequest();

        System.out.println("payment.amount = " + payment.amount);

        System.out.println();
    }

    private static PaymentRequest createRequest() {
        PaymentRequest request = new PaymentRequest(500);

        return request;
    }

    // ************************************************************************************************************* //

    private static void earlyUnreachableExperiment() {
        System.out.println("=== Early Unreachable Experiment ===");

        PaymentRequest request = new PaymentRequest(100);

        request = new PaymentRequest(900);

        System.out.println("request.amount = " + request.amount);

        System.out.println();
    }

    // ************************************************************************************************************* //

}