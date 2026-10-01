package org.example.allnewfeaturesinjava8.map.computeifabsent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static void main() {
        Map<String, List<String>> products = new HashMap<>();
        products.computeIfAbsent("Laptop", _ -> new ArrayList<>()).add("MacBook Pro");
        products.computeIfAbsent("Laptop", _ -> new ArrayList<>()).add("Dell XPS");
        products.computeIfAbsent("Phone", _ -> new ArrayList<>()).add("iPhone 18 Pro");
        products.computeIfAbsent("Phone", _ -> new ArrayList<>()).add("Samsung Galaxy S26");
        IO.println(products);
    }
}
