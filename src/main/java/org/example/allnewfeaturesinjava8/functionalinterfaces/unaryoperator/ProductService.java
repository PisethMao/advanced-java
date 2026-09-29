package org.example.allnewfeaturesinjava8.functionalinterfaces.unaryoperator;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public class ProductService {
    private final UnaryOperator<Product> discountOperator = product -> {
        BigDecimal discountedPrice = product.price().multiply(new BigDecimal("0.90"));
        return new Product(product.name(), discountedPrice);
    };

    public Product applyDiscount(Product product) {
        return discountOperator.apply(product);
    }
}
