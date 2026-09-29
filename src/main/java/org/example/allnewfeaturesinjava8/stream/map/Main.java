package org.example.allnewfeaturesinjava8.stream.map;

import java.util.List;

public class Main {
    static void main() {
        List<String> names = List.of("Alice", "Bob");
        List<String> upperNames = names.stream().map(String::toUpperCase).toList();
        IO.println(upperNames);
    }
}
