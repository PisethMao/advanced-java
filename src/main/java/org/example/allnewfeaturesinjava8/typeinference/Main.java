package org.example.allnewfeaturesinjava8.typeinference;

public class Main {
    public static <T> T identity(T value) {
        return value;
    }

    static void main() {
        String name = identity("Piseth");
        Integer age = identity(21);
        Double price = identity(650.00);
        IO.println(name);
        IO.println(age);
        IO.println(price);
    }
}
