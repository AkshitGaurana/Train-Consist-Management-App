package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase8TrainConsistMgmt {

    public static class Bogie {
        private final String name;
        private final int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public List<Bogie> createSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        return bogies;
    }

    public List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        UseCase8TrainConsistMgmt app = new UseCase8TrainConsistMgmt();

        List<Bogie> bogies = app.createSampleBogies();
        List<Bogie> filtered = app.filterBogiesByCapacity(bogies, 60);

        System.out.println("=========================================");
        System.out.println("   UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("=========================================\n");

        System.out.println("Original Bogie List:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nFiltered Bogies (capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b);
        }

        System.out.println("\nUC8 stream filtering completed...");
    }
}