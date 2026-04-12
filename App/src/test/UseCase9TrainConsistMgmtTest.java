package test;

import main.UseCase9TrainConsistMgmt;
import main.UseCase9TrainConsistMgmt.Bogie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmtTest {

    private final UseCase9TrainConsistMgmt app = new UseCase9TrainConsistMgmt();

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = app.createSampleBogies();

        Map<String, List<Bogie>> grouped = app.groupBogiesByType(bogies);

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = app.createSampleBogies();

        Map<String, List<Bogie>> grouped = app.groupBogiesByType(bogies);

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = app.createSampleBogies();

        Map<String, List<Bogie>> grouped = app.groupBogiesByType(bogies);

        assertEquals(3, grouped.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> grouped = app.groupBogiesByType(bogies);

        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 72));

        Map<String, List<Bogie>> grouped = app.groupBogiesByType(bogies);

        assertEquals(1, grouped.size());
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = app.createSampleBogies();

        Map<String, List<Bogie>> grouped = app.groupBogiesByType(bogies);

        assertTrue(grouped.keySet().contains("Sleeper"));
        assertTrue(grouped.keySet().contains("AC Chair"));
        assertTrue(grouped.keySet().contains("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = app.createSampleBogies();

        Map<String, List<Bogie>> grouped = app.groupBogiesByType(bogies);

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = app.createSampleBogies();
        int originalSize = bogies.size();

        Map<String, List<Bogie>> grouped = app.groupBogiesByType(bogies);

        assertEquals(originalSize, bogies.size());
        assertEquals(5, bogies.size());
        assertNotNull(grouped);
    }
}