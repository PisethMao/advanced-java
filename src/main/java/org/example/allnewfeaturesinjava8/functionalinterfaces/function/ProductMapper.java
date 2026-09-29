package org.example.allnewfeaturesinjava8.functionalinterfaces.function;

import java.util.function.Function;

public class ProductMapper {
    public static final Function<Product, ProductResponse> TO_RESPONSE =
            product -> new ProductResponse(
                    product.id(),
                    product.name(),
                    product.price(),
                    "$" + product.price()
            );
}
