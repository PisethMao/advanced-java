package org.example.allnewfeaturesinjava16.patternmatching;


public class Main {
    interface PaymentResult {
    }

    record Approved(String transactionId, long amountCents) implements PaymentResult {
    }

    record Declined(String reason) implements PaymentResult {
    }

    record Pending(String reference) implements PaymentResult {
    }

    static void handlePayment(PaymentResult result) {
        if (result instanceof Approved(String transactionId, long amountCents)) {
            IO.println("Payment approved: " + transactionId);
            IO.println("Amount: " + amountCents + " cents");
        } else if (result instanceof Declined(String reason)) {
            IO.println("Payment declined: " + reason);
        } else if (result instanceof Pending(String reference)) {
            IO.println("Payment pending: " + reference);
        }
    }

    static void main() {
        handlePayment(new Approved("TXN-1001", 2500));
        handlePayment(new Declined("Insufficient funds"));
        handlePayment(new Pending("REF-2001"));
    }
}

