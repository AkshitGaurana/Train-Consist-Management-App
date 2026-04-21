package test;

import main.UseCase19TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase19TrainConsistMgmtTest {

    UseCase19TrainConsistMgmt app = new UseCase19TrainConsistMgmt();

    @Test
    void testBinarySearch_BogieFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(app.binarySearch(arr, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(app.binarySearch(arr, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(app.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(app.binarySearch(arr, "BG309"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(app.binarySearch(arr, "BG101"));
        assertFalse(app.binarySearch(arr, "BG205"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] arr = {};
        assertFalse(app.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] arr = {"BG309", "BG101", "BG550"};

        // sort before applying binary search
        Arrays.sort(arr);

        assertTrue(app.binarySearch(arr, "BG309"));
    }
}