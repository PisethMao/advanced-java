package org.example.allnewfeaturesinjava8.lambdaexpressions;

public class EnglishGreeting implements Greeting{
    @Override
    public void sayHello(String name) {
        IO.println("Hello, " + name);
    }
}
