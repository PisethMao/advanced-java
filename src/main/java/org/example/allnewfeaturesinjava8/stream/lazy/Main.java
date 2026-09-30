package org.example.allnewfeaturesinjava8.stream.lazy;

import java.util.List;

public class Main {
    static void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var result = numbers.stream().filter(number -> {
            IO.println("Filter: " + number);
            return number % 2 == 0;
        }).map(number -> {
            IO.println("Map: " + number);
            return number * 10;
        }).filter(number -> {
            IO.println("Second Filter: " + number);
            return number > 50;
        }).findFirst();
        IO.println("Result: " + result);
    }
}
