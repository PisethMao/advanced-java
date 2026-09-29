package org.example.allnewfeaturesinjava8.functionalinterfaces.consumer;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private final String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
