package test;

import main.UseCase8TrainConsistMgmt;
import main.UseCase8TrainConsistMgmt.Bogie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmtTest {

    private final UseCase8TrainConsistMgmt app = new UseCase8TrainConsistMgmt();

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = app.createSampleBogies();

        List<Bogie> filtered = app.filterBogiesByCapacity(bogies, 70);

        assertEquals(2, filtered.size());
        assertTrue(filtered.stream().anyMatch(b -> b.getName().equals("Sleeper")));
        assertTrue(filtered.stream().anyMatch(b -> b.getName().equals("General")));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("TestBogie", 70));

        List<Bogie> filtered = app.filterBogiesByCapacity(bogies, 70);

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Mini", 40));

        List<Bogie> filtered = app.filterBogiesByCapacity(bogies, 70);

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = app.createSampleBogies();

        List<Bogie> filtered = app.filterBogiesByCapacity(bogies, 50);

        assertEquals(3, filtered.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> filtered = app.filterBogiesByCapacity(bogies, 100);

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("General", 90));

        List<Bogie> filtered = app.filterBogiesByCapacity(bogies, 20);

        assertEquals(2, filtered.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> filtered = app.filterBogiesByCapacity(bogies, 60);

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = app.createSampleBogies();
        int originalSize = bogies.size();

        List<Bogie> filtered = app.filterBogiesByCapacity(bogies, 60);

        assertEquals(originalSize, bogies.size());
        assertEquals(4, bogies.size());
        assertNotSame(bogies, filtered);
    }
}