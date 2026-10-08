package org.example.allnewfeaturesinjava20.patternmatchingforswitch.guardedpatternusingwhen;

public class Main {
    static String checkNumber(Object value) {
        return switch (value) {
            case Integer i when i > 0 -> "Positive";
            case Integer i when i < 0 -> "Negative";
            case Integer _ -> "Zero";
            case null -> "No value";
            default -> "Not an integer";
        };
    }

    static void main() {
        IO.println(checkNumber(5));
        IO.println(checkNumber(-3));
        IO.println(checkNumber(0));
        IO.println(checkNumber(null));
        IO.println(checkNumber("Hello"));
    }
}
