package org.example.allnewfeaturesinjava8.completablefuture.concurrenthashmap;

public class Main {
    static void main() {
        RequestCounter requestCounter = new RequestCounter();

        requestCounter.increment("/api/login");
        requestCounter.increment("/api/login");
        requestCounter.increment("/api/payment");
        requestCounter.increment("/api/login");
        requestCounter.increment("/api/payment");

        requestCounter.printAll();
    }
}
