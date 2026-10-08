package org.example.allnewfeaturesinjava21.unnamedpatterns;

import java.math.BigDecimal;

public class Main {
    static void main() {
        PaymentService service = new PaymentService();
        PaymentEvent payment1 = new PaymentSuccess("TXN001", new BigDecimal("250.00"), "USD");
        PaymentEvent payment2 = new PaymentRejected("TXN002", "Insufficient balance", "ERR100");
        service.process(payment1);
        IO.println("--------------------");
        service.process(payment2);
    }
}

