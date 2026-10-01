package org.example.allnewfeaturesinjava8.completablefuture.composition;

import java.util.concurrent.CompletableFuture;

public class Main {
    static CompletableFuture<Customer> findCustomer() {
        return CompletableFuture.supplyAsync(() -> {
            sleep();
            return new Customer(1L, "Piseth");
        });
    }

    static CompletableFuture<Order> findOrder(Long customerId) {
        return CompletableFuture.supplyAsync(() -> {
            sleep();
            return new Order(1001L, customerId, 150.00);
        });
    }

    static CompletableFuture<String> generateReceipt(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            sleep();
            return """
                    ===== RECEIPT =====
                    Order ID : %d
                    Amount   : $%.2f
                    ===================
                    """.formatted(
                    order.id(),
                    order.amount()
            );
        });
    }

    static void sleep() {
        try {
            Thread.sleep((long) 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static void main() {
        CompletableFuture<String> result = findCustomer().thenCompose(customer -> {
            IO.println("Customer found: " + customer.name());
            return findOrder(customer.id());
        }).thenCompose(order -> {
            IO.println("Order found: " + order.id());
            return generateReceipt(order);
        });
        result.thenAccept(receipt -> IO.println("\n" + receipt));
        result.join();
    }
}
