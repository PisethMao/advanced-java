package org.example.allnewfeaturesinjava18.patternmatchingforswitch;

public class Main {
    static String checkValue(Object value) {
        return switch (value) {
            case null -> "Null value";
            case Integer number when number > 0 -> "Positive integer: " + number;
            case Integer number when number < 0 -> "Negative integer: " + number;
            case Integer _ -> "Zero";
            case String text -> "String: " + text;
            default -> "Other type";
        };
    }

    static void main() {
        Object value = 100;
        IO.println(checkValue(value));
    }
}
