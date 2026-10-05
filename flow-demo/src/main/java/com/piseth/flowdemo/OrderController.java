package com.piseth.flowdemo;

import com.piseth.flowdemo.domain.CreateOrderRequest;
import com.piseth.flowdemo.domain.OrderEvent;
import com.piseth.flowdemo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderEvent createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }
}
