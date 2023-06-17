package model.assignments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cs3500.pa05.model.assignments.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {
    private Event event1;
    private Event event2;

    @BeforeEach
    void setUp() {
        event1 = new Event("Meeting", "Monday", "10:00", "2h");
        event2 = new Event("Concert", "Friday", "20:00", "3h", "Music Concert");
    }

//    @Test
//    void testConstructorWithoutDescription() {
//        assertEquals("Meeting", event1.getName());
//        assertEquals("Monday", event1.getDay());
//        assertEquals("10:00", event1.getStartTime());
//        assertEquals("2h", event1.getDuration());
//        assertNull(event1.getDescription());
//    }

    @Test
    void testConstructorWithDescription() {
        assertEquals("Concert", event2.getName());
        assertEquals("Friday", event2.getDay());
        assertEquals("20:00", event2.getStartTime());
        assertEquals("3h", event2.getDuration());
        assertEquals("Music Concert", event2.getDescription());
    }

    @Test
    void testGetStartTime() {
        assertEquals("10:00", event1.getStartTime());
        assertEquals("20:00", event2.getStartTime());
    }

    @Test
    void testGetDuration() {
        assertEquals("2h", event1.getDuration());
        assertEquals("3h", event2.getDuration());
    }
}

