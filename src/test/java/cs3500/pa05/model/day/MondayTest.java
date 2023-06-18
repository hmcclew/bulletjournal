package cs3500.pa05.model.day;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.Monday;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the monday class
 */
public class MondayTest {
  private Monday monday;

  @BeforeEach
  public void setUp() {
    monday = new Monday();
  }

  @Test
  public void testAddEvent() {
    Event event = new Event("Meeting", "Monday", "10:00", "2h");
    monday.addEvent(event);

    List<Event> events = monday.getEvents();
    assertEquals(1, events.size());
    assertEquals(event, events.get(0));
  }

  @Test
  public void testAddTask() {
    Task task = new Task("Shopping", "Monday");
    monday.addTask(task);

    List<Task> tasks = monday.getTasks();
    assertEquals(1, tasks.size());
    assertEquals(task, tasks.get(0));
  }
}
