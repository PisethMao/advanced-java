package org.example.allnewfeaturesinjava15.sealedclasses;

import java.math.BigDecimal;

public record PaymentSuccess(String transactionId, BigDecimal amount) implements PaymentResult {
}
