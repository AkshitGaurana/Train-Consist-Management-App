package test;

import main.UseCase17TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UseCase17TrainConsistMgmtTest {

    UseCase17TrainConsistMgmt app = new UseCase17TrainConsistMgmt();

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] arr = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        app.sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"}, arr);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] arr = {"Luxury", "Sleeper", "AC Chair", "General", "First Class"};
        app.sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"}, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] arr = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        app.sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"}, arr);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] arr = {"Sleeper", "AC Chair", "Sleeper", "General"};
        app.sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper", "Sleeper"}, arr);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] arr = {"Sleeper"};
        app.sortBogieNames(arr);
        assertArrayEquals(new String[]{"Sleeper"}, arr);
    }
}