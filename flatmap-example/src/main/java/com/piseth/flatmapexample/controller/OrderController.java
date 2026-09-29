package com.piseth.flatmapexample.controller;

import com.piseth.flatmapexample.domain.Order;
import com.piseth.flatmapexample.domain.OrderItem;
import com.piseth.flatmapexample.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/items/map")
    public List<List<OrderItem>> getItemsUsingMap() {
        return orderService.getItemsUsingMap();
    }

    @GetMapping("/items")
    public List<OrderItem> getAllItems() {
        return orderService.getAllItems();
    }
}