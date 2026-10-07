package org.example.allnewfeaturesinjava14.records;

import java.math.BigDecimal;

public class Main {
    static void main() {
        Transfer transfer = new Transfer(
                "TXN001",
                "001-123456",
                "001-987654",
                new BigDecimal("-100.00"),
                "USD"
        );
        IO.println(transfer);
    }
}
