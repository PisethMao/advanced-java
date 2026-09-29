package org.example.allnewfeaturesinjava8.functionalinterfaces.bipredicate;

import java.util.function.BiPredicate;

public class Main {
    static void main() {
        BiPredicate<Integer, Integer> add = (x, y) -> x + y == 10;
        boolean test = add.test(12, 12);
        IO.println(test);
    }
}
