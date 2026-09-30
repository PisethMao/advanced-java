package org.example.allnewfeaturesinjava8.iterable.service;

import org.example.allnewfeaturesinjava8.iterable.domain.Order;

public class NotificationService {
    public void sendOrderConfirmation(Order order) {
        IO.println("Sending confirmation to " + order.customerName() + " for order #" + order.id());
    }
}
