package org.example.allnewfeaturesinjava8.stream.reduce;

import org.example.allnewfeaturesinjava8.stream.reduce.domain.OrderItem;
import org.example.allnewfeaturesinjava8.stream.reduce.service.OrderService;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    static void main() {
        List<OrderItem> items = List.of(
                new OrderItem(1L, "MacBook Pro", new BigDecimal("2000"), 1),
                new OrderItem(2L, "Mouse", new BigDecimal("50"), 2),
                new OrderItem(3L, "Keyboard", new BigDecimal("100"), 1)
        );
//        BigDecimal total = new BigDecimal("0");
//        for (OrderItem item : items) {
//            BigDecimal itemTotal = item.price().multiply(BigDecimal.valueOf(item.quantity()));
//            total = total.add(itemTotal);
//        }
//        BigDecimal total = items.stream().map(item -> item.price()
//                        .multiply(BigDecimal.valueOf(item.quantity())))
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//        IO.println("Total price: " + total);
        OrderService orderService = new OrderService();
        BigDecimal total = orderService.calculateTotal(items);
        IO.println("Order Total = $" + total);
    }
}
