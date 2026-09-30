package org.example.allnewfeaturesinjava8.stream.reduce.service;

import org.example.allnewfeaturesinjava8.stream.reduce.domain.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class OrderService {
    public BigDecimal calculateTotal(List<OrderItem> items) {
        return items.stream()
                .map(item ->
                        item.price().multiply(BigDecimal.valueOf(item.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
