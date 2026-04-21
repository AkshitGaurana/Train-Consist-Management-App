package main;

public class UseCase19TrainConsistMgmt {

    public boolean binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int compare = arr[mid].compareTo(target);

            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UseCase19TrainConsistMgmt app = new UseCase19TrainConsistMgmt();

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String target = "BG309";

        System.out.println("=========================================");
        System.out.println("   UC19 - Binary Search for Bogie ID");
        System.out.println("=========================================\n");

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = app.binarySearch(bogieIds, target);

        System.out.println();
        if (found) {
            System.out.println("Bogie " + target + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + target + " not found using Binary Search.");
        }

        System.out.println("\nUC19 search completed...");
    }
}