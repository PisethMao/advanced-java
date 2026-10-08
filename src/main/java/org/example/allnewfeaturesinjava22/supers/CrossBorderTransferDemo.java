package org.example.allnewfeaturesinjava22.supers;

import java.math.BigDecimal;

public class CrossBorderTransferDemo {
    void main() {
        CrossBorderTransfer transfer = new CrossBorderTransfer(" acc-1001 ", new BigDecimal("125.50"), " la ");
        IO.println(transfer.summary());
        try {
            new CrossBorderTransfer("acc-1001", new BigDecimal("-5"), "LA");
        } catch (IllegalArgumentException e) {
            IO.println("Rejected: " + e.getMessage());
        }
    }
}