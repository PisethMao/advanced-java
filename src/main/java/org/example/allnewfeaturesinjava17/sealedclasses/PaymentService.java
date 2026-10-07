package org.example.allnewfeaturesinjava17.sealedclasses;

import java.math.BigDecimal;

public class PaymentService {
    public PaymentResult processPayment(String transactionId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return new PaymentFailed(transactionId, "Amount must be greater than zero");
        }
        if (amount.compareTo(new BigDecimal("1000")) > 0) {
            return new PaymentPending(transactionId, "Payment requires review");
        }
        return new PaymentSuccess(transactionId, amount);
    }
}