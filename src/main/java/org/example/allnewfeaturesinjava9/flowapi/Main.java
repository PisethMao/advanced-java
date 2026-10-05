package org.example.allnewfeaturesinjava9.flowapi;

import java.math.BigDecimal;

public class Main {
    static void main() throws InterruptedException {
        OrderPublisher publisher = new OrderPublisher();
        OrderSubscriber subscriber = new OrderSubscriber();
        publisher.subscribe(subscriber);
        Order order1 = new Order("ORD-001", "Piseth", new BigDecimal("100.00"));
        Order order2 = new Order("ORD-002", "Dara", new BigDecimal("250.50"));
        Order order3 = new Order("ORD-003", "Sokha", new BigDecimal("75.25"));
        Order order4 = new Order("ORD-004", "Nita", new BigDecimal("500.00"));
        Order order5 = new Order("ORD-005", "Vanna", new BigDecimal("125.75"));
        publisher.publish(order1);
        publisher.publish(order2);
        publisher.publish(order3);
        publisher.publish(order4);
        publisher.publish(order5);
        publisher.close();
        subscriber.awaitCompletion();
        IO.println();
        IO.println("Application finished.");
    }
}
