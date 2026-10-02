package org.example.allnewfeaturesinjava8.methodparameterreflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {
    static void main() throws Exception {
        Method method = UserService.class
                .getDeclaredMethod("createUser", String.class, String.class, Integer.class);
        IO.println("Method: " + method.getName());
        IO.println("Parameter Count: " + method.getParameterCount());
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            IO.println("--------------------");
            IO.println("Name: " + parameter.getName());
            IO.println("Type: " + parameter.getType());
            IO.println("Name Present: " + parameter.isNamePresent());
        }
    }
}
