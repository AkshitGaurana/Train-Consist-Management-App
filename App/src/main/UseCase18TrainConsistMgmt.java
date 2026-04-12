package main;

public class UseCase18TrainConsistMgmt {

    public boolean linearSearch(String[] bogieIds, String target) {
        for (String id : bogieIds) {
            if (id.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UseCase18TrainConsistMgmt app = new UseCase18TrainConsistMgmt();

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String target = "BG309";

        System.out.println("=========================================");
        System.out.println("   UC18 - Linear Search for Bogie ID");
        System.out.println("=========================================\n");

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = app.linearSearch(bogieIds, target);

        System.out.println();
        if (found) {
            System.out.println("Bogie " + target + " found in train consist.");
        } else {
            System.out.println("Bogie " + target + " not found in train consist.");
        }

        System.out.println("\nUC18 search completed...");
    }
}