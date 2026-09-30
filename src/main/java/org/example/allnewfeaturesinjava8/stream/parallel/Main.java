package org.example.allnewfeaturesinjava8.stream.parallel;

import java.util.List;

public class Main {
    static void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(number -> IO.println(number + " -> " + Thread.currentThread().getName()));
    }
}
