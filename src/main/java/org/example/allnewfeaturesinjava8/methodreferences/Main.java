package org.example.allnewfeaturesinjava8.methodreferences;

import java.util.List;
import java.util.function.Function;

public class Main {
    static void main() {
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Function<String, Integer> converter = Integer::parseInt;
        List<Integer> result = numbers.stream().map(converter).toList();
        result.forEach(IO::println);
    }
}
