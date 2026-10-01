package org.example.allnewfeaturesinjava8.datetimeapi.duration;

import java.time.Duration;
import java.time.LocalTime;

public class Main {
    static void main() {
        LocalTime start = LocalTime.of(8, 30);
        LocalTime end = LocalTime.of(10, 0);
        Duration duration = Duration.between(start, end);
        IO.println(duration.toMinutes());
    }
}
