package org.example.allnewfeaturesinjava8.functionalinterfaces.bifunction;

import java.util.function.BiFunction;

public class Main {
    static void main() {
        // 1. Original
//        BiFunction<Integer, Integer, Integer> add = new BiFunction<>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                return integer + integer2;
//            }
//        };
        // 2. With Lambda
//        BiFunction<Integer, Integer, Integer> add =
//                (integer, integer2) -> integer + integer2;
        // 3. With Method Reference
        BiFunction<Integer, Integer, Integer> add =
                Integer::sum;
        Integer result = add.apply(1, 2);
        IO.println(result);
    }
}
