package org.example.allnewfeaturesinjava8.methodreferences.constructorreference;

import lombok.Getter;

@Getter
public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

}
