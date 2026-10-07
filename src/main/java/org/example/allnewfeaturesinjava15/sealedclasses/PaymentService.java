package org.example.allnewfeaturesinjava15.sealedclasses;

import java.math.BigDecimal;

public class PaymentService {
    public PaymentResult processPayment(String transactionId, double amount) {
        if (amount <= 0) {
            return new PaymentFailed(transactionId, "Amount must be greater than zero");
        }
        if (amount > 10_000) {
            return new PaymentPending(transactionId);
        }
        return new PaymentSuccess(transactionId, BigDecimal.valueOf(amount));
    }
}
