package org.example.allnewfeaturesinjava20.patternmatchingforswitch.typepatternmatching;

public class Main {
    static String checkType(Object value) {
        return switch (value) {
            case String s -> "Text: " + s;
            case Integer i -> "Number: " + i;
            case Double d -> "Decimal: " + d;
            case null -> "Null";
            default -> "Other";
        };
    }

    static void main() {
        IO.println(checkType("Hello"));
        IO.println(checkType(42));
        IO.println(checkType(3.14));
        IO.println(checkType(null));
        IO.println(checkType(new Object()));
    }
}
