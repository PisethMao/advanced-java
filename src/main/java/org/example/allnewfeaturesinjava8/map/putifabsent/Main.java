package org.example.allnewfeaturesinjava8.map.putifabsent;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
        Map<String, String> users = new HashMap<>();
        users.put("P001", "Piseth");
        users.put("P002", "Pisal");
        IO.println(users);
        users.putIfAbsent("P003", "Sophaneth");
        IO.println(users);
        users.putIfAbsent("P001", "Mea");
        IO.println(users);
    }
}
