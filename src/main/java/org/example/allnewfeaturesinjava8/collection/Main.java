package org.example.allnewfeaturesinjava8.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    static void main() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Predicate<Integer> isEven = n -> n % 2 == 0;
        numbers.removeIf(isEven);
        IO.println(numbers);
//        IO.println(isEven);
    }
}
