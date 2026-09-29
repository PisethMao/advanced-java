package com.piseth.flatmapexample.service.impl;

import com.piseth.flatmapexample.domain.Order;
import com.piseth.flatmapexample.domain.OrderItem;
import com.piseth.flatmapexample.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final List<Order> orders = List.of(
            new Order(1L, "Piseth",
                    List.of(
                            new OrderItem(1L, "MacBook Pro", "Laptop", new BigDecimal("2000")),
                            new OrderItem(2L, "Mouse", "Accessory", new BigDecimal("50")),
                            new OrderItem(3L, "Keyboard", "Accessory", new BigDecimal("100"))
                    )
            ),
            new Order(2L, "Dara",
                    List.of(
                            new OrderItem(4L, "iPhone", "Phone", new BigDecimal("1200")),
                            new OrderItem(5L, "Charger", "Accessory", new BigDecimal("40"))
                    )
            ),
            new Order(3L, "Sokha",
                    List.of(
                            new OrderItem(6L, "Monitor", "Monitor", new BigDecimal("500")),
                            new OrderItem(7L, "HDMI Cable", "Accessory", new BigDecimal("20"))
                    )
            )
    );

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public List<List<OrderItem>> getItemsUsingMap() {
        return orders.stream()
                .map(Order::items)
                .toList();
    }

    @Override
    public List<OrderItem> getAllItems() {
        return orders.stream()
                .flatMap(order -> order.items().stream())
                .toList();
    }
}