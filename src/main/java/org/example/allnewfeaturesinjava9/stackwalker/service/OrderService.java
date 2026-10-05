package org.example.allnewfeaturesinjava9.stackwalker.service;

import java.math.BigDecimal;

public class OrderService {
    private final PaymentService paymentService = new PaymentService();

    public void createOrder() {
        IO.println("Creating order...");
        paymentService.processPayment(new BigDecimal("150.00"));
        IO.println("Order created successfully.");
    }
}
