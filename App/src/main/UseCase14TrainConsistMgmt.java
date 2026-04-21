package main;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class UseCase14TrainConsistMgmt {

    public static class Bogie {
        private final String name;
        private final int capacity;

        public Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
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

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("   UC14 - Handle Invalid Bogie Capacity");
        System.out.println("=========================================\n");

        try {
            Bogie validBogie = new Bogie("Sleeper", 72);
            System.out.println("Created Bogie: " + validBogie);

            Bogie invalidBogie = new Bogie("AC Chair", 0);
            System.out.println("Created Bogie: " + invalidBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}