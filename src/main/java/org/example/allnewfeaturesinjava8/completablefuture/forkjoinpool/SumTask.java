package org.example.allnewfeaturesinjava8.completablefuture.forkjoinpool;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    private static final Integer THRESHOLD = 10_000;
    private final Long[] numbers;
    private final Integer start;
    private final Integer end;

    public SumTask(Long[] numbers, Integer start, Integer end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD){
            Long sum = 0L;
            for (int i = start; i < end; i++){
                sum += numbers[i];
            }
            return sum;
        }
        Integer middle = start + length / 2;
        SumTask left = new SumTask(numbers, start, middle);
        SumTask right = new SumTask(numbers, middle, end);
        left.fork();
        Long rightResult = right.compute();
        Long leftResult = left.join();
        return leftResult + rightResult;
    }
}
