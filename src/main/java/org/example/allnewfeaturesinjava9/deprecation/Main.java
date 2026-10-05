package org.example.allnewfeaturesinjava9.deprecation;

import java.math.BigDecimal;

public class Main {
    static void main() {
        PaymentService paymentService = new PaymentService();
        paymentService.pay(new BigDecimal("100.50"));
        IO.println("Payment processed successfully.");
        IO.println("Thank you for your payment!");
        IO.println("Have a great day!");
        IO.println("Goodbye!");
        IO.println("See you soon!");
        IO.println("Have a nice day!");
        IO.println("Have a wonderful day!");
        IO.println("Have a fantastic day!");
    }
}
