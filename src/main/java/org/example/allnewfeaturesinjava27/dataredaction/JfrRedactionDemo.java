package org.example.allnewfeaturesinjava27.dataredaction;

public class JfrRedactionDemo {
    void main() throws InterruptedException {
        IO.println("JFR demo started");
        String region = System.getProperty("app.region");
        IO.println("Application region: " + region);
        Thread.sleep(2000);
        IO.println("JFR demo completed");
    }
}

