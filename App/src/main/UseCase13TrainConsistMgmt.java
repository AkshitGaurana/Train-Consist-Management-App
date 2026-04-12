package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13TrainConsistMgmt {

    public List<Integer> generateData(int size) {
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            data.add(i);
        }
        return data;
    }

    public List<Integer> filterUsingLoop(List<Integer> data) {
        List<Integer> result = new ArrayList<>();
        for (int num : data) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }
        return result;
    }

    public List<Integer> filterUsingStream(List<Integer> data) {
        return data.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }

    public long measureLoopTime(List<Integer> data) {
        long start = System.nanoTime();
        filterUsingLoop(data);
        long end = System.nanoTime();
        return end - start;
    }

    public long measureStreamTime(List<Integer> data) {
        long start = System.nanoTime();
        filterUsingStream(data);
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {

        UseCase13TrainConsistMgmt app = new UseCase13TrainConsistMgmt();

        List<Integer> data = app.generateData(1000000);

        long loopTime = app.measureLoopTime(data);
        long streamTime = app.measureStreamTime(data);

        System.out.println("=========================================");
        System.out.println("   UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("=========================================\n");

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}