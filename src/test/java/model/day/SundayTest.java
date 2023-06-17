package model.day;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.day.Sunday;
import cs3500.pa05.model.assignments.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SundayTest {
    private Sunday sunday;

    @BeforeEach
    public void setUp() {
        sunday = new Sunday();
    }

    @Test
    public void testAddEvent() {
        Event event = new Event("Meeting", "Sunday", "10:00", "2h");
        sunday.addEvent(event);

        List<Event> events = sunday.getEvents();
        assertEquals(1, events.size());
        assertEquals(event, events.get(0));
    }

    @Test
    public void testAddTask() {
        Task task = new Task("Shopping", "Sunday");
        sunday.addTask(task);

        List<Task> tasks = sunday.getTasks();
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }
}
