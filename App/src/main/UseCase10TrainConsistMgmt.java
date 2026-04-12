package main;

import java.util.ArrayList;
import java.util.List;

public class UseCase10TrainConsistMgmt {

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

    public int countTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        UseCase10TrainConsistMgmt app = new UseCase10TrainConsistMgmt();
        List<Bogie> bogies = app.createSampleBogies();
        int totalSeats = app.countTotalSeats(bogies);

        System.out.println("=========================================");
        System.out.println("   UC10 - Count Total Seats in Train (reduce)");
        System.out.println("=========================================\n");

        System.out.println("Bogie Seat Details:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        System.out.println("\nTotal Seating Capacity:");
        System.out.println(totalSeats);

        System.out.println("\nUC10 seat aggregation completed...");
    }
}