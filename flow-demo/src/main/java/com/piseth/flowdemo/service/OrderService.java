package com.piseth.flowdemo.service;

import com.piseth.flowdemo.domain.CreateOrderRequest;
import com.piseth.flowdemo.domain.OrderEvent;
import com.piseth.flowdemo.publisher.OrderEventPublisher;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {
    private final OrderEventPublisher publisher;
    private final AtomicLong orderSequence = new AtomicLong(1000);

    public OrderService(OrderEventPublisher publisher) {
        this.publisher = publisher;
    }

    public OrderEvent createOrder(CreateOrderRequest request) {
        String orderId = "ORD-" + orderSequence.incrementAndGet();
        OrderEvent event = new OrderEvent(orderId, request.itemName(), "CREATED", Instant.now());
        publisher.publish(event);
        return event;
    }
}
