package org.example.allnewfeaturesinjava8.stream.primitive;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    static void main() {
//        IntStream numbers = IntStream.of(1, 2, 90, 4, 55, 6, 71, 8, 94);
//        IntStream numbers = IntStream.range(1, 5);
        IntStream numbers = IntStream.rangeClosed(1, 10);
        numbers.forEach(IO::println);

        IntSummaryStatistics statistics = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).summaryStatistics();
        IO.println("Count: " + statistics.getCount());
        IO.println("Sum: " + statistics.getSum());
        IO.println("Aver: " + statistics.getAverage());
        IO.println("Min: " + statistics.getMin());
        IO.println("Max: " + statistics.getMax());

        LongStream longStream = LongStream.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
        IO.println(longStream);

        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        IO.println(doubleStream);
    }
}
