package org.example.allnewfeaturesinjava8.map.replaceall;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("iPhone", 0);
        scores.put("MacBook", 0);
        scores.put("Mouse", 0);
        IO.println(scores);
        scores.replaceAll((_, score) -> score + 1);
        IO.println(scores);
    }
}
