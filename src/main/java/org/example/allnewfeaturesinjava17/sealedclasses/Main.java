package org.example.allnewfeaturesinjava17.sealedclasses;

import java.math.BigDecimal;

public class Main {
    static void main() {
        PaymentService paymentService = new PaymentService();
        PaymentResult result = paymentService.processPayment("TXN001", new BigDecimal("500"));
        IO.println(result);
        if (result instanceof PaymentSuccess(String transactionId, BigDecimal amount)) {
            IO.println("Payment successful");
            IO.println("Transaction ID: " + transactionId);
            IO.println("Amount: " + amount);
        } else if (result instanceof PaymentFailed(String transactionId, String reason)) {
            IO.println("Payment failed");
            IO.println("Transaction ID: " + transactionId);
            IO.println("Reason: " + reason);
        } else if (result instanceof PaymentPending(String transactionId, String message)) {
            IO.println("Payment pending");
            IO.println("Transaction ID: " + transactionId);
            IO.println("Message: " + message);
        }
    }
}