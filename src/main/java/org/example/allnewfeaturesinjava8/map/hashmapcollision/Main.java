package org.example.allnewfeaturesinjava8.map.hashmapcollision;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
        Map<UserKey, String> users = new HashMap<>(64);
        for (int i = 1; i <= 20; i++) {
            users.put(new UserKey(i), "User " + i);
        }
        IO.println(users.get(new UserKey(15)));
    }
}
