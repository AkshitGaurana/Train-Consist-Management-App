package test;

import main.UseCase18TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase18TrainConsistMgmtTest {

    UseCase18TrainConsistMgmt app = new UseCase18TrainConsistMgmt();

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(app.linearSearch(arr, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(app.linearSearch(arr, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(app.linearSearch(arr, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(app.linearSearch(arr, "BG309"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(app.linearSearch(arr, "BG101"));
        assertFalse(app.linearSearch(arr, "BG205"));
    }
}