package com.piseth.consumerexample.controller;

import com.piseth.consumerexample.domain.Order;
import com.piseth.consumerexample.dto.CreateOrderRequest;
import com.piseth.consumerexample.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> create(@Valid @RequestBody CreateOrderRequest request) {
        Order order = orderService.create(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(order);
    }
}