package com.piseth.consumerexample.service.impl;

import com.piseth.consumerexample.domain.Order;
import com.piseth.consumerexample.dto.CreateOrderRequest;
import com.piseth.consumerexample.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class OrderServiceImpl implements OrderService {
    private final Consumer<Order> orderLogger;

    public OrderServiceImpl(Consumer<Order> orderLogger) {
        this.orderLogger = orderLogger;
    }

    @Override
    public Order create(CreateOrderRequest request) {
        Order order =
                new Order(
                        UUID.randomUUID(),
                        request.customerName(),
                        request.productName(),
                        request.quantity(),
                        Instant.now()
                );
        orderLogger.accept(order);
        return order;
    }
}
