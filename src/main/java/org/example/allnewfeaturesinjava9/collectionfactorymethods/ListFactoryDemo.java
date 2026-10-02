package org.example.allnewfeaturesinjava9.collectionfactorymethods;

import java.util.ArrayList;
import java.util.List;

public class ListFactoryDemo {
    public static void run(){
        IO.println("========== List.of() ==========");
        List<String> languages = new ArrayList<>(List.of("Java", "Python", "C++"));
        IO.println("Languages: " + languages);
        IO.println("First Language: " + languages.getFirst());
        IO.println("Contains Java: " + languages.contains("Java"));
        IO.println("Size: " + languages.size());
        List<String> duplicateLanguages = List.of("Java", "Python", "Java", "C++");
        IO.println("Duplicate Languages: " + duplicateLanguages);
        try {
            languages.add("C#");
        } catch (UnsupportedOperationException e) {
            IO.println("UnsupportedOperationException: " + e.getMessage());
        }
        List<String> mutableList = new ArrayList<>(languages);
        mutableList.add("Assembly");
        IO.println("Mutable List: " + mutableList);
    }
}
