package org.example.allnewfeaturesinjava15.sealedclasses;

public record PaymentPending(String transactionId) implements PaymentResult {
}
