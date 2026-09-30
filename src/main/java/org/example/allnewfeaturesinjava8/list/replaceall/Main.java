package org.example.allnewfeaturesinjava8.list.replaceall;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Julie");
        IO.println("Before: ");
        IO.println(names);
        names.replaceAll(String::toUpperCase);
        IO.println("After: ");
        IO.println(names);
    }
}
