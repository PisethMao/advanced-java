package org.example.allnewfeaturesinjava9.privatemethodsinterfaces;

import java.math.BigDecimal;

public class Main {
    static void main() {
        PaymentProcessor processor = new PaymentProcessorImpl();
        IO.println("=== QR PAYMENT ===");
        processor.payByQR(new BigDecimal("100.00"), "USD");
        IO.println();
        IO.println("=== CARD PAYMENT ===");
        processor.payByCard(new BigDecimal("250.00"), "USD");
        IO.println();
        IO.println("=== REFUND ===");
        processor.refund(new BigDecimal("50.00"), "USD");
    }
}
