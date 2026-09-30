package org.example.allnewfeaturesinjava8.stream.searching;

import org.example.allnewfeaturesinjava8.stream.searching.domain.Product;
import org.example.allnewfeaturesinjava8.stream.searching.service.ProductService;

public class Main {
    static void main() {
        ProductService productService = new ProductService();
        IO.println("Welcome to New Features In Java 8 Stream");
        IO.println("===== FIND BY ID =====");
        Product product = productService.findById(3L);
        IO.println("The product with id 3 is " + product);
        IO.println("====== FIND BY NAME =====");
        Product product1 = productService.findAnyLaptop();
        IO.println("The product with name is " + product1.name());
    }
}
