package org.example.allnewfeaturesinjava8.list.sort;

import java.math.BigDecimal;

public record Product(
        Long id,
        String name,
        String category,
        BigDecimal price
) {
}
