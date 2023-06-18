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

    @Test
    public void testEventConstructor() {
        // Create a new instance of Event using the no-args constructor
        Event event = new Event();

        // Assert that the 'startTime' field is an empty string as expected
        assertEquals("", event.getStartTime(), "Newly created event should have an empty start time.");

        // Assert that the 'duration' field is an empty string as expected
        assertEquals("", event.getDuration(), "Newly created event should have an empty duration.");
    }


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

    @Test
    void testGetCategoryWithExistingCategory() {
        Event event = new Event();
        event.setCategory("Sports");
        assertEquals("Sports", event.getCategory());
    }

    @Test
    void testGetCategoryWithoutCategory() {
        Event event = new Event();
        assertEquals("No Category Available.", event.getCategory());
    }

    @Test
    void testGetDescriptionWithExistingDescription() {
        Event event = new Event();
        event.setDescription("Football match");
        assertEquals("Football match", event.getDescription());
    }

    @Test
    void testGetDescriptionWithoutDescription() {
        Event event = new Event();
        assertEquals("No Description Available.", event.getDescription());
    }

    @Test
    void testGetCategoryWithEmptyCategory() {
        Event event = new Event();
        event.setCategory("");
        assertEquals("No Category Available.", event.getCategory());
    }

    @Test
    void testGetDescriptionWithEmptyDescription() {
        Event event = new Event();
        event.setDescription("");
        assertEquals("No Description Available.", event.getDescription());
    }
}

