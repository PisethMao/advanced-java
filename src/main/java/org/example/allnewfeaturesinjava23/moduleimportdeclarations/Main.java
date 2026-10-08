package org.example.allnewfeaturesinjava23.moduleimportdeclarations;

import module java.base;

public class Main {
    void main() {
        List<String> names = List.of("Dara", "Sokha");
        LocalDate today = LocalDate.now();
        BigDecimal amount = new BigDecimal("100.50");
        IO.println(names);
        IO.println(today);
        IO.println(amount);
    }
}
