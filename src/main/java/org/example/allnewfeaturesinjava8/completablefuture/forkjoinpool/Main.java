package org.example.allnewfeaturesinjava8.completablefuture.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

public class Main {
    static void main() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        IO.println(forkJoinPool);

        int processors = Runtime.getRuntime().availableProcessors();
        int parallelism = ForkJoinPool.getCommonPoolParallelism();

        IO.println("Processors: " + processors);
        IO.println("Common Pool Parallelism: " + parallelism);

        ForkJoinPool.commonPool().submit(() -> IO.println(Thread.currentThread().getName())).join();

        Long[] numbers = new Long[1_000_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (long) (i + 1);
        }
        SumTask sumTask = new SumTask(numbers, 0, numbers.length);
        Long result = ForkJoinPool.commonPool().invoke(sumTask);
        IO.println(result);
    }
}
