package org.example.allnewfeaturesinjava8.stream.limitskip;

import java.util.List;

public class Main {
    static void main() {
        ProductService productService = new ProductService();
        List<Product> products = productService.getAllProducts();
        // 1. limit()
//        List<Product> result = products.stream().limit(3).toList();
        // 2. skip()
//        List<Product> result = products.stream().skip(3).toList();
        // 3. limit() + skip()
        List<Product> result = products.stream().skip(3).limit(2).toList();
        result.forEach(IO::println);
    }
}
