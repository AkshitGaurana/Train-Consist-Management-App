package main;

public class UseCase16TrainConsistMgmt {

    public void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(value).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        UseCase16TrainConsistMgmt app = new UseCase16TrainConsistMgmt();

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("=========================================");
        System.out.println("   UC16 - Manual Sorting using Bubble Sort");
        System.out.println("=========================================\n");

        System.out.println("Original Capacities:");
        System.out.println(app.arrayToString(capacities));

        app.bubbleSort(capacities);

        System.out.println("\nSorted Capacities (Ascending):");
        System.out.println(app.arrayToString(capacities));

        System.out.println("\nUC16 sorting completed...");
    }
}