package model.day;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.Wednesday;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tests for the wednesday class
 */
public class WednesdayTest {
  private Wednesday wednesday;

  @BeforeEach
  public void setUp() {
    wednesday = new Wednesday();
  }

  @Test
  public void testAddEvent() {
    Event event = new Event("Meeting", "Wednesday", "10:00", "2h");
    wednesday.addEvent(event);

    List<Event> events = wednesday.getEvents();
    assertEquals(1, events.size());
    assertEquals(event, events.get(0));
  }

  @Test
  public void testAddTask() {
    Task task = new Task("Shopping", "Wednesday");
    wednesday.addTask(task);

    List<Task> tasks = wednesday.getTasks();
    assertEquals(1, tasks.size());
    assertEquals(task, tasks.get(0));
  }
}
