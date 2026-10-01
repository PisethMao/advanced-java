package org.example.allnewfeaturesinjava8.map.compute;

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
        inventory.compute("B", (_, stock) -> {
            if (stock == null) {
                return 6;
            }
            return stock + 6;
        });
        IO.println("After: ");
        IO.println(inventory);
    }
}

