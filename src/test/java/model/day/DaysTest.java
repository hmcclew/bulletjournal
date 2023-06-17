package model.day;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.day.Days;
import org.junit.jupiter.api.Test;

class DaysTest {

    @Test
    void testDaysEnum() {
        for (Days day : Days.values()) {
            assertNotNull(day);
            assertTrue(true);
        }
    }
}

