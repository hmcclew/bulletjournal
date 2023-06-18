package model.day;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.Tuesday;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the tuesday class
 */
public class TuesdayTest {
  private Tuesday tuesday;

  @BeforeEach
  public void setUp() {
    tuesday = new Tuesday();
  }

  @Test
  public void testAddEvent() {
    Event event = new Event("Meeting", "Tuesday", "10:00", "2h");
    tuesday.addEvent(event);

    List<Event> events = tuesday.getEvents();
    assertEquals(1, events.size());
    assertEquals(event, events.get(0));
  }

  @Test
  public void testAddTask() {
    Task task = new Task("Shopping", "Tuesday");
    tuesday.addTask(task);

    List<Task> tasks = tuesday.getTasks();
    assertEquals(1, tasks.size());
    assertEquals(task, tasks.get(0));
  }
}
