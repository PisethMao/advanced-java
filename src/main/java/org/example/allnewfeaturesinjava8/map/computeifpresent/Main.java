package org.example.allnewfeaturesinjava8.map.computeifpresent;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("A", 5);
        inventory.put("B", 2);
        inventory.put("C", 3);
        IO.println("Before: ");
        IO.println(inventory);
        String productId = "A";
        Integer purchasedQuantity = 4;
        inventory.computeIfPresent(productId, (id, currentQuantity) -> currentQuantity - purchasedQuantity);
        IO.println("After: ");
        IO.println(inventory);
    }
}
