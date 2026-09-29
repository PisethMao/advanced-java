package org.example.allnewfeaturesinjava8.functionalinterfaces.consumer;

import java.util.function.Consumer;

public class Main {
    static void main() {
        // 1. With Lambda
//        Consumer<String> consumer = message -> IO.println(message);
        // 2. With Method Reference
        Consumer<String> consumer = IO::println;
        consumer.accept("Hello, Piseth!!!");

        Consumer<User> printUser = user -> IO.println(user.getName() + " - " + user.getEmail());
        User user = new User("Piseth", "pisethmao2002@gmail.com");
        printUser.accept(user);
    }
}
