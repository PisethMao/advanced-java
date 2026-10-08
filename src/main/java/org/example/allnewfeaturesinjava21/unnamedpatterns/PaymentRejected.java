package org.example.allnewfeaturesinjava21.unnamedpatterns;


public record PaymentRejected(String transactionId, String reason, String errorCode) implements PaymentEvent {
}