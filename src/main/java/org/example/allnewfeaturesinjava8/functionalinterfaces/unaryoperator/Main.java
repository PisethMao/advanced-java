package org.example.allnewfeaturesinjava8.functionalinterfaces.unaryoperator;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public class Main {
    static void main() {
        UnaryOperator<Integer> doubleNumber = number -> number * 2;
        Integer result = doubleNumber.apply(5);
        IO.println(result);

        UsernameNormalizer usernameNormalizer = new UsernameNormalizer();
        String username = "     PISETH MAO     ";
        String result1 = usernameNormalizer.normalize(username);
        IO.println("Before [" + username + "]");
        IO.println("After [" + result1 + "]");

        ProductService productService = new ProductService();
        Product product = new Product("MacBook", new BigDecimal("1000.00"));
        Product discountedProduct = productService.applyDiscount(product);
        IO.println("Product: " + product.name());
        IO.println("Original price: " + product.price());
        IO.println("Discounted price: " + discountedProduct.price());
    }
}
