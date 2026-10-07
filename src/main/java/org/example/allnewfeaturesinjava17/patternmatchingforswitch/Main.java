package org.example.allnewfeaturesinjava17.patternmatchingforswitch;

public class Main {
    static void main() {
        printValue("Hello");
        printValue(100);
        printValue(50.5);
        printValue(true);
        printValue(null);
    }

    static void printValue(Object value) {
        switch (value) {
            case null -> IO.println("null value");
            case String s -> IO.println("String: " + s);
            case Integer i -> IO.println("Integer: " + i);
            case Double d -> IO.println("Double: " + d);
            default -> IO.println("Other: " + value);
        }
    }
}
