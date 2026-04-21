package main;

public class UseCase15TrainConsistMgmt {

    static class UnsafeCargoException extends Exception {
        public UnsafeCargoException(String message) {
            super(message);
        }
    }

    public void assignCargo(String bogieType, String cargo) throws UnsafeCargoException {
        if (bogieType.equals("Rectangular") && cargo.equals("Petroleum")) {
            throw new UnsafeCargoException("Unsafe cargo assignment!");
        }
        System.out.println("Cargo assigned successfully -> " + cargo);
    }

    public static void main(String[] args) {
        UseCase15TrainConsistMgmt app = new UseCase15TrainConsistMgmt();

        System.out.println("=========================================");
        System.out.println("   UC15 - Safe Cargo Assignment");
        System.out.println("=========================================\n");

        try {
            app.assignCargo("Cylindrical", "Petroleum");
        } catch (UnsafeCargoException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cargo validation completed for Cylindrical bogie");
        }

        System.out.println();

        try {
            app.assignCargo("Rectangular", "Petroleum");
        } catch (UnsafeCargoException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cargo validation completed for Rectangular bogie");
        }

        System.out.println("\nUC15 runtime handling completed...");
    }
}