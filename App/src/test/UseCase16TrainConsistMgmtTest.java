package test;

import main.UseCase16TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UseCase16TrainConsistMgmtTest {

    UseCase16TrainConsistMgmt app = new UseCase16TrainConsistMgmt();

    @Test
    void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        app.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] arr = {24, 56, 60, 70, 72};
        app.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] arr = {50, 20, 50, 10, 20};
        app.bubbleSort(arr);
        assertArrayEquals(new int[]{10, 20, 20, 50, 50}, arr);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] arr = {72};
        app.bubbleSort(arr);
        assertArrayEquals(new int[]{72}, arr);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] arr = {30, 30, 30, 30};
        app.bubbleSort(arr);
        assertArrayEquals(new int[]{30, 30, 30, 30}, arr);
    }
}