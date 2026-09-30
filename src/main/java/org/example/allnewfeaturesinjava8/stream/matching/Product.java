package org.example.allnewfeaturesinjava8.stream.matching;

import java.math.BigDecimal;

public record Product(
        Long id,
        String name,
        String category,
        BigDecimal price,
        boolean available
) {
}
