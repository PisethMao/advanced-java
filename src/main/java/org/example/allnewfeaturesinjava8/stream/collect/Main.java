package org.example.allnewfeaturesinjava8.stream.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        List<String> names = List.of("Mak At", "Pa Thun", "Sophaneth", "Pisal");
        // Version 1
//        List<String> result = names.stream().collect(Collectors.toList());
        // Version 2
//        List<String> result = new ArrayList<>(names);
        // Version 3
        List<String> result = names.stream().toList();
        IO.println(result);
    }
}
