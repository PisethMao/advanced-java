package org.example.allnewfeaturesinjava8.functionalinterfaces.function;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Function;

public class Main {
    static void main() {
        Product product = new Product(UUID.randomUUID(),
                "MacBook M5 Pro 2T 24GB",
                new BigDecimal("3000"));
        ProductResponse productResponse = ProductMapper.TO_RESPONSE.apply(product);
        IO.println(productResponse);
    }
}
