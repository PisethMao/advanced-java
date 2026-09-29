package org.example.allnewfeaturesinjava8.methodreferences.constructorreference;

import java.util.function.Function;

public class Main {
    static void main() {
        Function<String, User> userCreator = User::new;
        User user = userCreator.apply("John");
        IO.println("User Created: " + user.getName());
    }
}
