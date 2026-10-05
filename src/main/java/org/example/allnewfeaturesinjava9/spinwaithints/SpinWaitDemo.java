package org.example.allnewfeaturesinjava9.spinwaithints;

public class SpinWaitDemo {
    private static volatile boolean ready = false;

    static void main() {
        Thread consumer = new Thread(() -> {
            IO.println("Consumer waiting...");
            while (!ready) {
                Thread.onSpinWait();
            }
            IO.println("Consumer received signal.");
        });
        Thread producer = new Thread(() -> {
            IO.println("Producer doing work...");
            ready = true;
            IO.println("Producer sent signal.");
        });
        consumer.start();
        producer.start();
    }
}
