package org.example.allnewfeaturesinjava8.functionalinterfaces.biconsumer;

import java.util.function.BiConsumer;

public class Main {
    static void main() {
        BiConsumer<String, Integer> printUser =
                (name, age) -> IO.println("[" + name + "]: " + age);
        printUser.accept("MacBook", 120);
    }
}
