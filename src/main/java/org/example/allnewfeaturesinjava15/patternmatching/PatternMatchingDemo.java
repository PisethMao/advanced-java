package org.example.allnewfeaturesinjava15.patternmatching;

import java.math.BigDecimal;

public class PatternMatchingDemo {
    interface PaymentEvent {
    }

    static class PaymentSuccess implements PaymentEvent {
        String transactionId;
        BigDecimal amount;

        PaymentSuccess(String transactionId, BigDecimal amount) {
            this.transactionId = transactionId;
            this.amount = amount;
        }
    }

    static class PaymentFailed implements PaymentEvent {
        String transactionId;
        String reason;

        PaymentFailed(String transactionId, String reason) {
            this.transactionId = transactionId;
            this.reason = reason;
        }
    }

    static void processPayment(PaymentEvent event) {
        if (event instanceof PaymentSuccess success) {
            IO.println("Payment successful");
            IO.println("Transaction: " + success.transactionId);
            IO.println("Amount: " + success.amount);
        } else if (event instanceof PaymentFailed failed) {
            IO.println("Payment failed");
            IO.println("Transaction: " + failed.transactionId);
            IO.println("Reason: " + failed.reason);
        }
    }

    static void main() {
        PaymentEvent first = new PaymentSuccess("TXN-1001", new BigDecimal("125.50"));
        PaymentEvent second = new PaymentFailed("TXN-1002", "Insufficient balance");
        processPayment(first);
        processPayment(second);
    }
}

