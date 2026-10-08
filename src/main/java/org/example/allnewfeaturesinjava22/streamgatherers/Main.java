package org.example.allnewfeaturesinjava22.streamgatherers;

import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class Main {
    void main() {
        // 1. windowFixed()
        var result = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .gather(Gatherers.windowFixed(3)).toList();
        IO.println(result);
        // 2. windowSliding()
        var result1 = Stream.of(10, 20, 30, 40, 50)
                .gather(Gatherers.windowSliding(3)).toList();
        IO.println(result1);
        // 3. scan()
        var result2 = Stream.of(100, 200, 50, 150)
                .gather(Gatherers.scan(() -> 0, Integer::sum)).toList();
        IO.println(result2);
        // 4. fold()
        var result3 = Stream.of(100, 200, 50, 150)
                .gather(Gatherers.fold(() -> 0, Integer::sum)).toList();
        IO.println(result3);
    }
}
