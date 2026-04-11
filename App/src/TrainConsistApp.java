import java.util.HashMap;
import java.util.Map;

public class TrainConsistApp {
    public static void main(String[] args) {

        Map<String, Integer> bogieMap = new HashMap<>();

        System.out.println("=========================================");
        System.out.println("   UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("=========================================\n");

        // Adding bogie-capacity mapping
        bogieMap.put("First Class", 24);
        bogieMap.put("Cargo", 120);
        bogieMap.put("Sleeper", 72);
        bogieMap.put("AC Chair", 56);

        System.out.println("Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}