package org.example.allnewfeaturesinjava8.functionalinterfaces.supplier;

import java.util.UUID;
import java.util.function.Supplier;

public class Main {
    static void main() {
        Supplier<String> messageSupplier = () -> "Hello World!";
        String message = messageSupplier.get();
        IO.println(message);

        // 1. With Lambda
//        Supplier<UUID> uuidSupplier = () -> UUID.randomUUID();
        // 2. With Method Reference
        Supplier<UUID> uuidSupplier = UUID::randomUUID;
        UUID uuid1 = uuidSupplier.get();
        UUID uuid2 = uuidSupplier.get();
        IO.println(uuid1);
        IO.println(uuid2);
    }
}
