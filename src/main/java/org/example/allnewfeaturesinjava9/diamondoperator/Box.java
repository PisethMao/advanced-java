package org.example.allnewfeaturesinjava9.diamondoperator;

import lombok.Getter;

@Getter
public class Box<T> {
    private final T value;

    public Box(T value) {
        this.value = value;
    }
}
