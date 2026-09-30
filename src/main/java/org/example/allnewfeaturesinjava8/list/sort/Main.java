package org.example.allnewfeaturesinjava8.list.sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static void main() {
        List<Product> products = new ArrayList<>(List.of(
                new Product(1L, "MacBook Pro", "Laptop", new BigDecimal("2000")),
                new Product(2L, "iPhone 18 Pro", "Phone", new BigDecimal("1200")),
                new Product(3L, "Mouse", "Accessory", new BigDecimal("50")),
                new Product(4L, "Keyboard", "Accessory", new BigDecimal("100")),
                new Product(5L, "Monitor", "Accessory", new BigDecimal("500"))
        ));
        IO.println("Before Sorting:");
        products.forEach(IO::println);
        products.sort(Comparator.comparing(Product::price));
        IO.println("After Sorting:");
        products.forEach(IO::println);
    }
}
