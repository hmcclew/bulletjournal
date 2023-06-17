package model.day;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.day.Friday;
import cs3500.pa05.model.assignments.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FridayTest {
    private Friday friday;

    @BeforeEach
    public void setUp() {
        friday = new Friday();
    }

    @Test
    public void testAddEvent() {
        Event event = new Event("Meeting", "Friday", "10:00", "2h");
        friday.addEvent(event);

        List<Event> events = friday.getEvents();
        assertEquals(1, events.size());
        assertEquals(event, events.get(0));
    }

    @Test
    public void testAddTask() {
        Task task = new Task("Shopping", "Friday");
        friday.addTask(task);

        List<Task> tasks = friday.getTasks();
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }
}
