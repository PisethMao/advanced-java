package org.example.allnewfeaturesinjava8.methodreferences.staticmethodreference;

import java.util.function.Function;

public class Main {
    public static int square(int x) {
        return x * x;
    }
    static void main() {
        // 1. With Lambda
//        Function<String, Integer> converter = value -> Integer.parseInt(value);
        // 2. With Method Reference
        Function<String, Integer> converter = Integer::parseInt;
        Integer result = converter.apply("12");
        IO.println(result);

        Function<Integer, Integer> squareFunction = Main::square;
        Integer squareResult = squareFunction.apply(100);
        IO.println(squareResult);
    }
}
