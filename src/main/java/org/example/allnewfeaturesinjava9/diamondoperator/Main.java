package org.example.allnewfeaturesinjava9.diamondoperator;

public class Main {
    static void main() {
        Box<String> box = new Box<>("Hello Java");
        IO.println(box.getValue());
    }
}
