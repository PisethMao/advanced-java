package org.example.allnewfeaturesinjava8.methodreferences.arbitraryobject;

import java.util.function.Function;

public class Main {
    static void main() {
        // Instance Method of an Arbitrary Object of a Type
        Function<String, String> uppercase = String::toUpperCase;
        String message = uppercase.apply("Hello World");
        IO.println(message);
    }
}
