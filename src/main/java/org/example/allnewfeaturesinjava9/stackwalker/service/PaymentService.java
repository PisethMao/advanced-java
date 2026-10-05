package org.example.allnewfeaturesinjava9.stackwalker.service;

import org.example.allnewfeaturesinjava9.stackwalker.util.AuditLogger;

import java.math.BigDecimal;

public class PaymentService {
    public void processPayment(BigDecimal amount) {
        AuditLogger.log("Processing payment amount: $" + amount);
        IO.println("Payment processed successfully.");
    }
}
