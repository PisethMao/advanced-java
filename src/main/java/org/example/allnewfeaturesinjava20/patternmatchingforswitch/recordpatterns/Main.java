package org.example.allnewfeaturesinjava20.patternmatchingforswitch.recordpatterns;

public class Main {
    record Customer(String name, int age) {
    }

    static String describe(Object obj) {
        return switch (obj) {
            case Customer(String name, int age) when age >= 18 -> name + " is an adult";
            case Customer(String name, _) -> name + " is under 18";
            default -> "Unknown";
        };
    }

    static void main() {
        IO.println(describe(new Customer("John", 25)));
        IO.println(describe(new Customer("Jane", 15)));
        IO.println(describe("Hello"));
    }
}
