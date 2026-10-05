package org.example.allnewfeaturesinjava9.flowapi;

import java.util.concurrent.SubmissionPublisher;

public class OrderPublisher extends SubmissionPublisher<Order> {
    public void publish(Order order) {
        IO.println("[PUBLISHER] Publishing: " + order.getId());
        submit(order);
    }
}
