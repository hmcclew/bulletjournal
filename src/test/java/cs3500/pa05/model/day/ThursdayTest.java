package cs3500.pa05.model.day;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.Thursday;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the thursday class
 */
public class ThursdayTest {
  private Thursday thursday;

  @BeforeEach
  public void setUp() {
    thursday = new Thursday();
  }

  @Test
  public void testAddEvent() {
    Event event = new Event("Meeting", "Thursday", "10:00", "2h");
    thursday.addEvent(event);

    List<Event> events = thursday.getEvents();
    assertEquals(1, events.size());
    assertEquals(event, events.get(0));
  }

  @Test
  public void testAddTask() {
    Task task = new Task("Shopping", "Thursday");
    thursday.addTask(task);

    List<Task> tasks = thursday.getTasks();
    assertEquals(1, tasks.size());
    assertEquals(task, tasks.get(0));
  }
}
