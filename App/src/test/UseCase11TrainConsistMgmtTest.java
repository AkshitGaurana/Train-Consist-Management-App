package test;

import main.UseCase11TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmtTest {

    private final UseCase11TrainConsistMgmt app = new UseCase11TrainConsistMgmt();

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(app.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(app.validateTrainID("TRAIN12"));
        assertFalse(app.validateTrainID("TRN12A"));
        assertFalse(app.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(app.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(app.validateCargoCode("PET-ab"));
        assertFalse(app.validateCargoCode("PET123"));
        assertFalse(app.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(app.validateTrainID("TRN-123"));
        assertFalse(app.validateTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(app.validateCargoCode("PET-Ab"));
        assertFalse(app.validateCargoCode("PET-aB"));
        assertFalse(app.validateCargoCode("PET-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(app.validateTrainID(""));
        assertFalse(app.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(app.validateTrainID("TRN-1234XYZ"));
        assertFalse(app.validateTrainID("XTRN-1234"));
        assertFalse(app.validateCargoCode("PET-ABCD"));
        assertFalse(app.validateCargoCode("XPET-AB"));
    }
}