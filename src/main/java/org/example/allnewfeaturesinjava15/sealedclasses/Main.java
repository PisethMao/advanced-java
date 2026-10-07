package org.example.allnewfeaturesinjava15.sealedclasses;

public class Main {
    static void main() {
        PaymentService paymentService = new PaymentService();
        PaymentResult result = paymentService.processPayment("TXN-10001", 500.00);
        handlePaymentResult(result);
    }

    private static void handlePaymentResult(PaymentResult result) {
        if (result instanceof PaymentSuccess(String id, java.math.BigDecimal amount)) {
            IO.println("Payment successful");
            IO.println("Transaction ID: " + id);
            IO.println("Amount: $" + amount);
        } else if (result instanceof PaymentFailed failed) {
            IO.println("Payment failed");
            IO.println("Reason: " + failed.reason());
        } else if (result instanceof PaymentPending(String transactionId)) {
            IO.println("Payment pending");
            IO.println("Transaction ID: " + transactionId);
        }
    }
}
