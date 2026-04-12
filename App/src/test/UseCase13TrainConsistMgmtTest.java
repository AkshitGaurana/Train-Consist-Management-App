package test;

import main.UseCase13TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmtTest {

    UseCase13TrainConsistMgmt app = new UseCase13TrainConsistMgmt();

    @Test
    void testLoopFilteringLogic() {
        List<Integer> data = app.generateData(10);
        List<Integer> result = app.filterUsingLoop(data);

        assertTrue(result.contains(2));
        assertTrue(result.contains(10));
        assertFalse(result.contains(3));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Integer> data = app.generateData(10);
        List<Integer> result = app.filterUsingStream(data);

        assertTrue(result.contains(2));
        assertTrue(result.contains(10));
        assertFalse(result.contains(5));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Integer> data = app.generateData(100);

        List<Integer> loopResult = app.filterUsingLoop(data);
        List<Integer> streamResult = app.filterUsingStream(data);

        assertEquals(loopResult, streamResult);
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Integer> data = app.generateData(10000);

        long loopTime = app.measureLoopTime(data);
        long streamTime = app.measureStreamTime(data);

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Integer> data = app.generateData(100000);

        List<Integer> result = app.filterUsingStream(data);

        assertFalse(result.isEmpty());
    }
}