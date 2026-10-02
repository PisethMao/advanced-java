package org.example.allnewfeaturesinjava8.completablefuture.arraysparallelsort;

import java.util.Arrays;

public class Main {
    static void main() {
        Integer[] numbers = {10, 4, 7, 2, 9, 1, 5};
        Arrays.parallelSort(numbers);
        IO.println(Arrays.toString(numbers));
    }
}
