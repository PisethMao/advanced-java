package org.example.allnewfeaturesinjava17.sealedclasses;

public record PaymentFailed(String transactionId, String reason) implements PaymentResult {
}