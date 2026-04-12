package test;

import main.UseCase20TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase20TrainConsistMgmtTest {

    UseCase20TrainConsistMgmt app = new UseCase20TrainConsistMgmt();

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            app.searchBogie(arr, "BG309");
        });

        assertEquals("No bogies available in train. Cannot perform search.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertDoesNotThrow(() -> app.searchBogie(arr, "BG205"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(app.searchBogie(arr, "BG309"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertFalse(app.searchBogie(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};
        assertTrue(app.searchBogie(arr, "BG101"));
        assertFalse(app.searchBogie(arr, "BG205"));
    }
}