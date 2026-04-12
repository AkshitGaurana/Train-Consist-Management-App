package main;

public class UseCase20TrainConsistMgmt {

    public boolean searchBogie(String[] bogieIds, String target) {
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        for (String id : bogieIds) {
            if (id.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UseCase20TrainConsistMgmt app = new UseCase20TrainConsistMgmt();

        String[] bogieIds = {};   // empty array to trigger exception
        String target = "BG309";

        System.out.println("=========================================");
        System.out.println("   UC20 - Exception Handling During Search");
        System.out.println("=========================================\n");

        // This will throw IllegalStateException exactly as expected
        app.searchBogie(bogieIds, target);
    }
}