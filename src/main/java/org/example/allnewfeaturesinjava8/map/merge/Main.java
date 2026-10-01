package org.example.allnewfeaturesinjava8.map.merge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static void main() {
        List<OrderItem> items = List.of(
                new OrderItem("MacBook", 2),
                new OrderItem("iPhone", 3),
                new OrderItem("MacBook", 1),
                new OrderItem("Mouse", 5),
                new OrderItem("iPhone", 2)
        );
        Map<String, Integer> sales = new HashMap<>();
        for (OrderItem item : items) {
            sales.merge(item.product(), item.quantity(), Integer::sum);
        }
        sales.forEach((product, quantity) -> IO.println(product + " = " + quantity));
    }
}
