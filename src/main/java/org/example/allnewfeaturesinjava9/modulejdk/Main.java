package org.example.allnewfeaturesinjava9.modulejdk;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());

    static void main() {
        BigDecimal amount = new BigDecimal("100.00");
        logger.info("Amount: " + amount);
        IO.println("Amount: " + amount);
        IO.println("Time: " + LocalDateTime.now());
    }
}
