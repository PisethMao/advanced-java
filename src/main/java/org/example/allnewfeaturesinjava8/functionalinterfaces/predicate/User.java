package org.example.allnewfeaturesinjava8.functionalinterfaces.predicate;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
