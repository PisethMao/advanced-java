package com.piseth.completionstagedemo.controller;

import com.piseth.completionstagedemo.dto.OrderSummary;
import com.piseth.completionstagedemo.service.OrderSummaryService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletionStage;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderSummaryService orderSummaryService;

    public OrderController(OrderSummaryService orderSummaryService) {
        this.orderSummaryService = orderSummaryService;
    }

    @GetMapping("/{orderId}")
    public CompletionStage<OrderSummary> getOrderSummary(@PathVariable String orderId) {
        return orderSummaryService
                .getSummary(orderId);
    }

    @GetMapping("/{orderId}/product")
    public CompletionStage<String> getProduct(@PathVariable String orderId) {
        return orderSummaryService.getProductName(orderId);
    }

    @PostMapping("/{orderId}/process")
    public CompletionStage<String> processOrder(@PathVariable String orderId) {
        return orderSummaryService.processOrder(orderId);
    }

    @GetMapping("/{orderId}/safe")
    public CompletionStage<String> getOrderSafely(@PathVariable String orderId) {
        return orderSummaryService.getOrderSafely(orderId);
    }
}
