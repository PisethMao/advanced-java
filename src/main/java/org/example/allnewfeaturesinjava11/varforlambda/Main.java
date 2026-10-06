package org.example.allnewfeaturesinjava11.varforlambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    static void main() {
        Function<String, String> toUpperCase = String::toUpperCase;
//        Function<String, String> toUpperCase = (var text) -> text.toUpperCase();
        String result = toUpperCase.apply("Hello, World!");
        IO.println("Result: " + result);

        BiFunction<Integer, Integer, Integer> add = Integer::sum;
//        BiFunction<Integer, Integer, Integer> add = (var a, var b) -> a + b;
        Integer sum = add.apply(5, 3);
        IO.println("Sum: " + sum);

        BiFunction<Integer, Integer, Integer> multiply = (var a, var b) -> a * b;
        var answer = multiply.apply(4, 6);
        IO.println("Answer: " + answer);

//        Function<String, String> formatter = (@NotNull var name) -> name.trim().toUpperCase();
//        var formattedName = formatter.apply("   john doe   ");
//        IO.println("Formatted Name: " + formattedName);

        Function<String, String> formatter = (final var name) -> name.trim().toUpperCase();
        var formattedName = formatter.apply("   john doe   ");
        IO.println("Formatted Name: " + formattedName);
    }
}
