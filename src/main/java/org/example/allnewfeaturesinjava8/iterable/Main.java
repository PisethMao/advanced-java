package org.example.allnewfeaturesinjava8.iterable;

import org.example.allnewfeaturesinjava8.iterable.domain.Order;
import org.example.allnewfeaturesinjava8.iterable.domain.OrderCollection;
import org.example.allnewfeaturesinjava8.iterable.service.NotificationService;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    static void main() {
        List<Order> orders = List.of(
                new Order(1L, "Piseth", new BigDecimal("1200.00")),
                new Order(2L, "Dara", new BigDecimal("500.00")),
                new Order(3L, "Sokha", new BigDecimal("250.00"))
        );
        // 1. Version 1
//        for (Order order : orders) {
//            IO.println(order);
//        }
        // 2. Version 2
//        orders.forEach(order -> IO.println(order));
        // 3. Version 3
        orders.forEach(IO::println);
        // 4. Version 4
        Consumer<Order> printOrder = IO::println;
        orders.forEach(printOrder);

        NotificationService notificationService = new NotificationService();
        orders.forEach(notificationService::sendOrderConfirmation);

        OrderCollection orderCollection = new OrderCollection(orders);
        orderCollection.forEach(IO::println);
    }
}
