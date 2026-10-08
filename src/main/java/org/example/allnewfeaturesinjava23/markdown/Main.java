package org.example.allnewfeaturesinjava23.markdown;

import java.math.BigDecimal;

public class Main {
    void main() {
        var service = new TransferService();
        var receipt = service.transfer("ACC001", "ACC002", new BigDecimal("100.00"));
        IO.println(receipt);
    }
}