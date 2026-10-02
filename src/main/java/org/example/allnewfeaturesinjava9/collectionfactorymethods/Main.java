package org.example.allnewfeaturesinjava9.collectionfactorymethods;

import java.util.List;
import java.util.Set;

public class Main {
    static void main() {
        List<String> list = List.of("a", "b", "c");
        IO.println(list);
        Set<String> set = Set.of("a", "b", "c");
        IO.println(set);

        ListFactoryDemo.run();
        SetFactoryDemo.run();
        MapFactoryDemo.run();
    }
}
