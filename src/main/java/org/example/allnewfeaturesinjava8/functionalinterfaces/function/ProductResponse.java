package org.example.allnewfeaturesinjava8.functionalinterfaces.function;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(
        UUID id,
        String name,
        BigDecimal price,
        String displayPrice
) {
}
