package org.example.allnewfeaturesinjava17.sealedclasses;

import java.math.BigDecimal;

public record PaymentSuccess(String transactionId, BigDecimal amount) implements PaymentResult {
}