package org.example.allnewfeaturesinjava8.stringjoiner;

import java.util.StringJoiner;

public class Main {
    static void main() {
        StringJoiner stringJoiner = new StringJoiner(" | ");
        stringJoiner.add("Username is required...");
        stringJoiner.add("Email is invalid...");
        stringJoiner.add("Password is too short...");
        IO.println(stringJoiner);
    }
}
