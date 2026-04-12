package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseCase11TrainConsistMgmt {

    public boolean validateTrainID(String trainId) {
        Pattern pattern = Pattern.compile("TRN-\\d{4}");
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    public boolean validateCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile("PET-[A-Z]{2}");
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        UseCase11TrainConsistMgmt app = new UseCase11TrainConsistMgmt();

        String trainId = "TRN-6524";
        String cargoCode = "PET-FH";

        boolean isTrainValid = app.validateTrainID(trainId);
        boolean isCargoValid = app.validateCargoCode(cargoCode);

        System.out.println("=========================================");
        System.out.println("   UC11 - Validate Train ID and Cargo Code");
        System.out.println("=========================================\n");

        System.out.println("Enter Train ID (Format: TRN-1234): " + trainId);
        System.out.println("Enter Cargo Code (Format: PET-AB): " + cargoCode);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        System.out.println("\nUC11 validation completed...");
    }
}