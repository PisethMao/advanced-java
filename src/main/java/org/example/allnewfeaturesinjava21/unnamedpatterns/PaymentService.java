package org.example.allnewfeaturesinjava21.unnamedpatterns;

import java.math.BigDecimal;

public class PaymentService {
    public void process(PaymentEvent event) {
        switch (event) {
            case PaymentSuccess(String transactionId, BigDecimal amount, _) -> {
                IO.println("Payment successful");
                IO.println("Transaction: " + transactionId);
                IO.println("Amount: " + amount);
            }
            case PaymentRejected(String transactionId, String reason, _) -> {
                IO.println("Payment rejected");
                IO.println("Transaction: " + transactionId);
                IO.println("Reason: " + reason);
            }
        }
    }
}

