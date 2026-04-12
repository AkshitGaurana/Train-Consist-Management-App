package test;

import main.UseCase15TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {
        UseCase15TrainConsistMgmt app = new UseCase15TrainConsistMgmt();

        assertDoesNotThrow(() -> app.assignCargo("Cylindrical", "Petroleum"));
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        UseCase15TrainConsistMgmt app = new UseCase15TrainConsistMgmt();

        Exception exception = assertThrows(Exception.class, () -> {
            app.assignCargo("Rectangular", "Petroleum");
        });

        assertEquals("Unsafe cargo assignment!", exception.getMessage());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15TrainConsistMgmt app = new UseCase15TrainConsistMgmt();

        Exception exception = assertThrows(Exception.class, () -> {
            app.assignCargo("Rectangular", "Petroleum");
        });

        assertNotNull(exception);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        UseCase15TrainConsistMgmt app = new UseCase15TrainConsistMgmt();

        assertThrows(Exception.class, () -> app.assignCargo("Rectangular", "Petroleum"));
        assertDoesNotThrow(() -> app.assignCargo("Cylindrical", "Petroleum"));
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        UseCase15TrainConsistMgmt app = new UseCase15TrainConsistMgmt();

        assertThrows(Exception.class, () -> app.assignCargo("Rectangular", "Petroleum"));
    }
}