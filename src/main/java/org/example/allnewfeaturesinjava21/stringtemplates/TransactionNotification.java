package org.example.allnewfeaturesinjava21.stringtemplates;

import java.math.BigDecimal;

public class TransactionNotification {
    static void main() {
        String customerName = "Piseth";
        BigDecimal amount = new BigDecimal("250.50");
        String currency = "USD";
        String reference = "TXN20261008001";
        String notification = """
                Transaction Successful
                ----------------------
                Customer: %s
                Amount: %s %s
                Reference: %s
                Status: COMPLETED
                """.formatted(
                customerName,
                amount.toPlainString(),
                currency,
                reference
        );
        IO.println(notification);
    }
}
