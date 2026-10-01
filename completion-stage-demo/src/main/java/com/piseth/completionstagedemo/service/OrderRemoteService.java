package com.piseth.completionstagedemo.service;

import com.piseth.completionstagedemo.dto.DeliveryInfo;
import com.piseth.completionstagedemo.dto.OrderInfo;
import com.piseth.completionstagedemo.dto.PaymentInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

@Service
public class OrderRemoteService {
    private final Executor orderExecutor;

    public OrderRemoteService(@Qualifier("orderExecutor") Executor orderExecutor) {
        this.orderExecutor = orderExecutor;
    }

    public CompletionStage<OrderInfo> getOrder(String orderId) {
        return CompletableFuture.supplyAsync(() -> {
            printThread("Fetching order...");
            sleep(1000);
            if ("error".equalsIgnoreCase(orderId)) {
                throw new RuntimeException("Order service is unavailable");
            }
            return new OrderInfo(orderId, "MacBook Pro", 1);
        }, orderExecutor);
    }

    public CompletionStage<PaymentInfo> getPayment(String orderId) {
        return CompletableFuture.supplyAsync(() -> {
            printThread("Fetching payment...");
            sleep(1500);
            return new PaymentInfo(orderId, "PAID", 1999.99);
        }, orderExecutor);
    }

    public CompletionStage<DeliveryInfo> getDelivery(String orderId) {
        return CompletableFuture.supplyAsync(() -> {
            printThread("Fetching delivery...");
            sleep(2000);
            return new DeliveryInfo(orderId, "SHIPPING", "2026-10-05");
        }, orderExecutor);
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Task interrupted", e);
        }
    }

    private void printThread(String message) {
        IO.println(message + " Thread: " + Thread.currentThread().getName());
    }

    public CompletionStage<String> reserveInventory(OrderInfo order) {
        return CompletableFuture.supplyAsync(() -> {
            printThread("Reserving inventory for " + order.productName());
            sleep(1000);
            return "Inventory reserved for order " + order.orderId();
        }, orderExecutor);
    }
}
