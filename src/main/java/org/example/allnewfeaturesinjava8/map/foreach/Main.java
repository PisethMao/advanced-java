package org.example.allnewfeaturesinjava8.map.foreach;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
        Map<String, Integer> students = new HashMap<>();
        students.put("iPhone", 0);
        students.put("MacBook", 0);
        students.put("Mouse", 0);
        students.forEach((name, score) -> {
            IO.println("Name : " + name);
            IO.println("Score : " + score);
            IO.println("----------------");
        });
    }
}
