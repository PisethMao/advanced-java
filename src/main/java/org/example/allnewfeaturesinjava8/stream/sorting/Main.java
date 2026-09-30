package org.example.allnewfeaturesinjava8.stream.sorting;

import java.util.Comparator;
import java.util.List;

public class Main {
    static void main() {
        List<Integer> numbers = List.of(1, 2, 90, 4, 55, 6, 71, 8, 94);
        List<Integer> result = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        IO.println(result);
    }
}
