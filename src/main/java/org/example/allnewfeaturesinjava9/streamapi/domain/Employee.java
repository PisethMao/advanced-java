package org.example.allnewfeaturesinjava9.streamapi.domain;

import java.math.BigDecimal;

public record Employee(
        String id,
        String name,
        String department,
        BigDecimal salary
) {
}
