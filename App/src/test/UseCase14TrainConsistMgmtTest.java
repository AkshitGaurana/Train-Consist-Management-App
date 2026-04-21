package test;

import main.UseCase14TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() throws Exception {
        UseCase14TrainConsistMgmt.Bogie bogie =
                new UseCase14TrainConsistMgmt.Bogie("Sleeper", 72);

        assertEquals("Sleeper", bogie.getName());
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new UseCase14TrainConsistMgmt.Bogie("AC Chair", -10);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new UseCase14TrainConsistMgmt.Bogie("AC Chair", 0);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(Exception.class, () -> {
            new UseCase14TrainConsistMgmt.Bogie("General", 0);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        UseCase14TrainConsistMgmt.Bogie bogie =
                new UseCase14TrainConsistMgmt.Bogie("First Class", 24);

        assertNotNull(bogie);
        assertEquals("First Class", bogie.getName());
        assertEquals(24, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        UseCase14TrainConsistMgmt.Bogie b1 =
                new UseCase14TrainConsistMgmt.Bogie("Sleeper", 72);
        UseCase14TrainConsistMgmt.Bogie b2 =
                new UseCase14TrainConsistMgmt.Bogie("AC Chair", 56);
        UseCase14TrainConsistMgmt.Bogie b3 =
                new UseCase14TrainConsistMgmt.Bogie("First Class", 24);

        assertEquals(72, b1.getCapacity());
        assertEquals(56, b2.getCapacity());
        assertEquals(24, b3.getCapacity());
    }
}