package org.example.allnewfeaturesinjava8.stream.matching;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    static void main() {
        List<Product> products = List.of(
                new Product(1L, "MacBook Pro", "Laptop", new BigDecimal("2000"), true),
                new Product(2L, "iPhone", "Phone", new BigDecimal("1200"), true),
                new Product(3L, "Mouse", "Accessory", new BigDecimal("50"), false),
                new Product(4L, "Keyboard", "Accessory", new BigDecimal("100"), true),
                new Product(5L, "Monitor", "Monitor", new BigDecimal("500"), true)
        );
        // 1. Version 1: Using For-Each Loop
//        boolean hasExpensiveProduct = false;
//        for (Product product : products) {
//            if (product.price().compareTo(new BigDecimal("500")) > 0) {
//                hasExpensiveProduct = true;
//                break;
//            }
//        }
        // 2. Version 2: Using anyMatch()
        Boolean hasExpensiveProduct = products.stream()
                .peek(product -> IO.println("Checking product " + product.name()))
                .anyMatch(product -> product.price().compareTo(new BigDecimal("500")) == 0
                );
        IO.println(hasExpensiveProduct);
        // 3. Version 3: Using allMatch()
        boolean isAllPricesValid = products.stream()
                .peek(product -> IO.println("Checking product " + product.name()))
                .allMatch(Product::available);
        IO.println("All products are available: " + isAllPricesValid);
        // 4. Version 4: Using nonMatch()
        Boolean isNoNegativePrice = products.stream()
                .noneMatch(product -> product.price().compareTo(new BigDecimal("500")) == 0);
        IO.println(isNoNegativePrice);
    }
}
