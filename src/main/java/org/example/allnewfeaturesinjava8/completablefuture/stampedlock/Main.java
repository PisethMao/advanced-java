package org.example.allnewfeaturesinjava8.completablefuture.stampedlock;

public class Main {
    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static void main() throws InterruptedException {
        ExchangeRateService service = new ExchangeRateService();
        Runnable reader = () -> {
            for (int i = 0; i < 5; i++) {
                ExchangeRate rate = service.getRate();
                IO.println(Thread.currentThread().getName() + " → " + rate);
                sleep(300);
            }
        };
        Runnable writer = () -> {
            double rate = 4100;
            for (int i = 0; i < 5; i++) {
                rate += 10;
                service.updateRate(rate);
                IO.println("Updated rate → " + rate);
                sleep(700);
            }
        };
        Thread reader1 = new Thread(reader, "Reader-1");
        Thread reader2 = new Thread(reader, "Reader-2");
        Thread writer1 = new Thread(writer, "Writer");
        reader1.start();
        reader2.start();
        writer1.start();
        reader1.join();
        reader2.join();
        writer1.join();
    }
}
