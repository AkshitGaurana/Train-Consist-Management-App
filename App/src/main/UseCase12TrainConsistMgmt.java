package main;

import java.util.ArrayList;
import java.util.List;

public class UseCase12TrainConsistMgmt {

    public static class GoodsBogie {
        private final String type;
        private final String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public boolean isSafetyCompliant(List<GoodsBogie> bogies) {
        for (GoodsBogie bogie : bogies) {
            if (bogie.getType().equalsIgnoreCase("Cylindrical")
                    && !bogie.getCargo().equalsIgnoreCase("Petroleum")) {
                return false;
            }
        }
        return true;
    }

    public List<GoodsBogie> createSampleBogies() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));
        return bogies;
    }

    public static void main(String[] args) {
        UseCase12TrainConsistMgmt app = new UseCase12TrainConsistMgmt();
        List<GoodsBogie> bogies = app.createSampleBogies();

        boolean safe = app.isSafetyCompliant(bogies);

        System.out.println("=========================================");
        System.out.println("   UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("=========================================\n");

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie bogie : bogies) {
            System.out.println(bogie);
        }

        System.out.println("\nSafety Compliance Status: " + safe);

        if (safe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}
