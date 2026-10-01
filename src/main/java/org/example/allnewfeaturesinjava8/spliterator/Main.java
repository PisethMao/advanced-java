package org.example.allnewfeaturesinjava8.spliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Main {
    static void main() {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Jenny");
        names.add("Jenny");
        names.add("Jenny");
        Spliterator<String> spliterator1 = names.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        spliterator1.tryAdvance(IO::println);
        spliterator2.forEachRemaining(value -> IO.println("Part 1: " + value));
        spliterator1.forEachRemaining(value -> IO.println("Part 2: " + value));
        IO.println(spliterator1.estimateSize());
    }
}
