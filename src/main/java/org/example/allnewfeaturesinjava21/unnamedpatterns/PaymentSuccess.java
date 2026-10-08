package org.example.allnewfeaturesinjava21.unnamedpatterns;

import java.math.BigDecimal;

public record PaymentSuccess(String transactionId, BigDecimal amount, String currency) implements PaymentEvent {
}