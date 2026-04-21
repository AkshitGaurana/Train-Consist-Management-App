package main;

import java.util.Arrays;

public class UseCase17TrainConsistMgmt {

    public void sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
    }

    public static void main(String[] args) {
        UseCase17TrainConsistMgmt app = new UseCase17TrainConsistMgmt();

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("=========================================");
        System.out.println("   UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("=========================================\n");

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        app.sortBogieNames(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}