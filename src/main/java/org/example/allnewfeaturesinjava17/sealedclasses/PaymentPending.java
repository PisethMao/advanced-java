package org.example.allnewfeaturesinjava17.sealedclasses;

public record PaymentPending(String transactionId, String message) implements PaymentResult {
}