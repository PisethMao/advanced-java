package com.piseth.completionstagedemo.service;

import com.piseth.completionstagedemo.dto.DeliveryInfo;
import com.piseth.completionstagedemo.dto.OrderInfo;
import com.piseth.completionstagedemo.dto.OrderSummary;
import com.piseth.completionstagedemo.dto.PaymentInfo;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletionStage;

@Service
public class OrderSummaryService {
    private final OrderRemoteService orderRemoteService;

    public OrderSummaryService(OrderRemoteService orderRemoteService) {
        this.orderRemoteService = orderRemoteService;
    }

    public CompletionStage<OrderSummary> getSummary(String orderId) {
        CompletionStage<OrderInfo> orderStage = orderRemoteService.getOrder(orderId);
        CompletionStage<PaymentInfo> paymentStage = orderRemoteService.getPayment(orderId);
        CompletionStage<DeliveryInfo> deliveryStage = orderRemoteService.getDelivery(orderId);
        return orderStage.thenCombine(paymentStage, OrderAndPayment::new)
                .thenCombine(deliveryStage, (orderAndPayment, delivery) -> new OrderSummary(orderAndPayment.order(), orderAndPayment.payment(), delivery));
    }

    private record OrderAndPayment(OrderInfo order, PaymentInfo payment) {
    }

    public CompletionStage<String> getProductName(String orderId) {
        return orderRemoteService.getOrder(orderId).thenApply(OrderInfo::productName);
    }

    public CompletionStage<String> processOrder(String orderId) {
        return orderRemoteService.getOrder(orderId)
                .thenCompose(orderRemoteService::reserveInventory);
    }

    public CompletionStage<String> getOrderSafely(String orderId) {
        return orderRemoteService.getOrder(orderId)
                .thenApply(order -> "Order found: " + order.orderId())
                .exceptionally(error -> "Could not load order: " + error.getMessage());
    }
}
