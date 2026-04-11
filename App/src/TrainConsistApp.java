import java.util.LinkedHashSet;

public class TrainConsistApp {
    public static void main(String[] args) {

        LinkedHashSet<String> bogies = new LinkedHashSet<>();

        System.out.println("UC5 - Preserve Insertion Order of Bogies\n");

        // Adding bogies (with duplicates)
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("Cargo");
        bogies.add("Sleeper"); // duplicate
        bogies.add("Guard");

        System.out.println("Final Train Formation:\n");
        System.out.println(bogies);

        System.out.println("\nNote:\n");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");
    }
}