package org.example.allnewfeaturesinjava15.sealedclasses;

public record PaymentFailed(String transactionId, String reason) implements PaymentResult {
}
