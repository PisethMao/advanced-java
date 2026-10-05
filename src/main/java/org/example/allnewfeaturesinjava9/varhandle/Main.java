package org.example.allnewfeaturesinjava9.varhandle;

public class Main {
    static void main() throws InterruptedException {
//        ProductInventory inventory = new ProductInventory(3);
//        IO.println(inventory.getStock());
//        IO.println(inventory.reserve());
//        IO.println(inventory.reserve());
//        IO.println(inventory.reserve());
//        IO.println(inventory.reserve());
//        IO.println(inventory.getStock());
//        IO.println("Remaining stock: " + inventory.getStock());
        ProductInventory inventory = new ProductInventory(10);
        IO.println(inventory.getStock());
        inventory.reserve();
        inventory.reserve();
        IO.println(inventory.getStock());
        inventory.restock(5);
        IO.println(inventory.getStock());

        AtomicCounter counter = new AtomicCounter();
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        IO.println(counter.get());
    }
}
