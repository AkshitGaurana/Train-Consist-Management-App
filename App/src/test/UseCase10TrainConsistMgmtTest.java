package test;

import main.UseCase10TrainConsistMgmt;
import main.UseCase10TrainConsistMgmt.Bogie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmtTest {

    private final UseCase10TrainConsistMgmt app = new UseCase10TrainConsistMgmt();

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = app.createSampleBogies();
        int total = app.countTotalSeats(bogies);
        assertEquals(242, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = app.createSampleBogies();
        int total = app.countTotalSeats(bogies);
        assertEquals(242, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        int total = app.countTotalSeats(bogies);
        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        int total = app.countTotalSeats(bogies);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("A", 10));
        bogies.add(new Bogie("B", 20));
        bogies.add(new Bogie("C", 30));
        int total = app.countTotalSeats(bogies);
        assertEquals(60, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = app.createSampleBogies();
        int total = app.countTotalSeats(bogies);
        assertEquals(72 + 56 + 24 + 90, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = app.createSampleBogies();
        int originalSize = bogies.size();

        int total = app.countTotalSeats(bogies);

        assertEquals(242, total);
        assertEquals(originalSize, bogies.size());
        assertEquals(4, bogies.size());
        assertEquals("Sleeper", bogies.get(0).getName());
        assertEquals("AC Chair", bogies.get(1).getName());
        assertEquals("First Class", bogies.get(2).getName());
        assertEquals("General", bogies.get(3).getName());
    }
}