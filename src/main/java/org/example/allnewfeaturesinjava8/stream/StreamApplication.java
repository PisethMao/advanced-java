package org.example.allnewfeaturesinjava8.stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamApplication {
    static void main() {
        List<String> names = List.of("Mak At", "Sophaneth", "Pisal", "Pa Thun");
        for(String name : names) {
            IO.println("Name: " + name);
        }

        Stream<String> namesStream = names.stream();
        namesStream.forEach(IO::println);
    }
}
