import java.util.HashSet;
import java.util.Set;

public class TrainConsistApp {
    public static void main(String[] args) {

        Set<String> bogieIds = new HashSet<>();

        System.out.println("=========================================");
        System.out.println("   UC3 - Track Unique Bogie IDs         ");
        System.out.println("=========================================\n");

        System.out.println("Adding Bogie IDs:");
        System.out.println("BG101, BG102, BG103, BG101, BG104");

        // Adding IDs (with duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG104");

        System.out.println("\nIDs After Insertion:");
        System.out.println(bogieIds);

        System.out.println("\nTotal Unique Bogies:");
        System.out.println(bogieIds.size());

        System.out.println("\nUC3 operations completed successfully...");
    }
}