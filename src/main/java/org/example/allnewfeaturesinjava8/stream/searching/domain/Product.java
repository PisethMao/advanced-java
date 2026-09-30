package org.example.allnewfeaturesinjava8.stream.searching.domain;

import java.math.BigDecimal;

public record Product(
        Long id,
        String name,
        String category,
        BigDecimal price
) {
}
