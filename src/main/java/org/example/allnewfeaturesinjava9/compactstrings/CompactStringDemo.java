package org.example.allnewfeaturesinjava9.compactstrings;

public class CompactStringDemo {
    static void main() {
        String english = "Hello Piseth";
        String api = "/api/v1/payments";
        String email = "piseth@example.com";
        String khmer = "សួស្តី";
        String mixed = "Hello សួស្តី";
        print(english);
        print(api);
        print(email);
        print(khmer);
        print(mixed);
    }

    private static void print(String value) {
        IO.println("Text: " + value + ", length: " + value.length());
    }
}