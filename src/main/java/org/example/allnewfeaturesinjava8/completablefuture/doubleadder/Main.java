package org.example.allnewfeaturesinjava8.completablefuture.doubleadder;

import java.util.concurrent.atomic.DoubleAdder;

public class Main {
    static void main() {
        DoubleAdder adder = new DoubleAdder();
        adder.add(1);
        adder.add(2);
        adder.add(3);
        IO.println(adder.sum());
    }
}
