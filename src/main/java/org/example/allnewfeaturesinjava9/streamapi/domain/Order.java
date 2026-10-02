package org.example.allnewfeaturesinjava9.streamapi.domain;

import java.util.List;

public record Order(
        String orderId,
        String customerName,
        List<String> products
) {
}
