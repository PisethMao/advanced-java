package org.example.allnewfeaturesinjava8.functionalinterfaces.unaryoperator;

import java.util.function.UnaryOperator;

public class UsernameNormalizer {
    private final UnaryOperator<String> normalizer = username -> username.trim().toLowerCase();

    public String normalize(String username) {
        return normalizer.apply(username);
    }
}
