package com.piseth.consumerexample.config;

import com.piseth.consumerexample.domain.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class OrderConsumerConfig {
    @Bean
    public Consumer<Order> orderLogger() {
        return order -> {
            IO.println("[ORDER LOG]");
            IO.println("Order ID: " + order.id());
            IO.println("Customer: " + order.customerName());
            IO.println("Product: " + order.productName());
            IO.println("Quantity: " + order.quantity());
        };
    }
}