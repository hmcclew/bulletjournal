package model.day;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.day.Saturday;
import cs3500.pa05.model.assignments.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SaturdayTest {
    private Saturday saturday;

    @BeforeEach
    public void setUp() {
        saturday = new Saturday();
    }

    @Test
    public void testAddEvent() {
        Event event = new Event("Meeting", "Saturday", "10:00", "2h");
        saturday.addEvent(event);

        List<Event> events = saturday.getEvents();
        assertEquals(1, events.size());
        assertEquals(event, events.get(0));
    }

    @Test
    public void testAddTask() {
        Task task = new Task("Shopping", "Saturday");
        saturday.addTask(task);

        List<Task> tasks = saturday.getTasks();
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }
}
