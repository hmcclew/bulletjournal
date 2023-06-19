package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import cs3500.pa05.model.assignments.Assignment;
import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.Days;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the week class
 */
public class WeekTest {

  private Week week;
  private Task mockTask;
  private Event mockEvent;
  private Assignment mockAssignment;
  private String sampleNote = "Sample Note";
  private String sampleCategory = "Sample Category";

  @BeforeEach
  public void setUp() {
    week = new Week();
    mockTask = mock(Task.class);
    mockEvent = mock(Event.class);
    mockAssignment = mock(Assignment.class);
  }

  @Test
  public void testSetMaximumEvents() {
    week.setMaximumEvents(5);
    assertEquals(5, week.getMaximumEvents());
  }

  @Test
  public void testSetMaximumTasks() {
    week.setMaximumTasks(3);
    assertEquals(3, week.getMaximumTasks());
  }

  @Test
  public void testAddNoteOrQuote() {
    week.addNoteOrQuote("test note");
    assertEquals(List.of("test note"), week.getQuotesAndNotes());
  }

  @Test
  public void testAddEvent() {
    when(mockEvent.getDay()).thenReturn("MONDAY");
    week.addEvent(mockEvent);
    assertEquals(Collections.singletonList(mockEvent), week.getAllEvents());
  }

  @Test
  public void testRemoveEvent() {
    week.getAllEvents().add(mockEvent);
    when(mockEvent.getDay()).thenReturn("MONDAY");
    week.removeEvent(mockEvent);
    assertFalse(week.getAllEvents().contains(mockEvent));

    week.getAllEvents().add(mockEvent);
    when(mockEvent.getDay()).thenReturn("TUESDAY");
    week.removeEvent(mockEvent);
    assertFalse(week.getAllEvents().contains(mockEvent));

    week.getAllEvents().add(mockEvent);
    when(mockEvent.getDay()).thenReturn("WEDNESDAY");
    week.removeEvent(mockEvent);
    assertFalse(week.getAllEvents().contains(mockEvent));

    week.getAllEvents().add(mockEvent);
    when(mockEvent.getDay()).thenReturn("THURSDAY");
    week.removeEvent(mockEvent);
    assertFalse(week.getAllEvents().contains(mockEvent));

    week.getAllEvents().add(mockEvent);
    when(mockEvent.getDay()).thenReturn("FRIDAY");
    week.removeEvent(mockEvent);
    assertFalse(week.getAllEvents().contains(mockEvent));

    week.getAllEvents().add(mockEvent);
    when(mockEvent.getDay()).thenReturn("SATURDAY");
    week.removeEvent(mockEvent);
    assertFalse(week.getAllEvents().contains(mockEvent));

    week.getAllEvents().add(mockEvent);
    when(mockEvent.getDay()).thenReturn("SUNDAY");
    week.removeEvent(mockEvent);
    assertFalse(week.getAllEvents().contains(mockEvent));
  }

  @Test
  public void testAddTask() {
    when(mockTask.getDay()).thenReturn("MONDAY");
    week.addTask(mockTask);
    assertEquals(Collections.singletonList(mockTask), week.getAllTasks());
  }

  @Test
  public void testRemoveTask() {
    week.getAllTasks().add(mockTask);
    when(mockTask.getDay()).thenReturn("MONDAY");
    week.removeTask(mockTask);
    assertFalse(week.getAllTasks().contains(mockTask));

    week.getAllTasks().add(mockTask);
    when(mockTask.getDay()).thenReturn("TUESDAY");
    week.removeTask(mockTask);
    assertFalse(week.getAllTasks().contains(mockTask));

    week.getAllTasks().add(mockTask);
    when(mockTask.getDay()).thenReturn("WEDNESDAY");
    week.removeTask(mockTask);
    assertFalse(week.getAllTasks().contains(mockTask));

    week.getAllTasks().add(mockTask);
    when(mockTask.getDay()).thenReturn("THURSDAY");
    week.removeTask(mockTask);
    assertFalse(week.getAllTasks().contains(mockTask));

    week.getAllTasks().add(mockTask);
    when(mockTask.getDay()).thenReturn("FRIDAY");
    week.removeTask(mockTask);
    assertFalse(week.getAllTasks().contains(mockTask));

    week.getAllTasks().add(mockTask);
    when(mockTask.getDay()).thenReturn("SATURDAY");
    week.removeTask(mockTask);
    assertFalse(week.getAllTasks().contains(mockTask));

    week.getAllTasks().add(mockTask);
    when(mockTask.getDay()).thenReturn("SUNDAY");
    week.removeTask(mockTask);
    assertFalse(week.getAllTasks().contains(mockTask));
  }

  @Test
  public void testDetermineDay() {
    when(mockAssignment.getDay()).thenReturn("MONDAY");
    assertEquals(Days.MONDAY, week.determineDay(mockAssignment));
  }

  @Test
  public void testGetMaximumEvents() {
    week.setMaximumEvents(5);
    assertEquals(5, week.getMaximumEvents());
  }

  @Test
  public void testGetMaximumTasks() {
    week.setMaximumTasks(5);
    assertEquals(5, week.getMaximumTasks());
  }

  @Test
  public void testGetQuotesAndNotes() {
    week.addNoteOrQuote(sampleNote);
    assertEquals(Collections.singletonList(sampleNote), week.getQuotesAndNotes());
  }

  @Test
  public void testGetCategories() {
    week.addCategory(sampleCategory);
    assertEquals(Collections.singletonList(sampleCategory), week.getCategories());
  }

  @Test
  public void testAddCategory() {
    week.addCategory(sampleCategory);
    assertTrue(week.getCategories().contains(sampleCategory));
  }

  @Test
  public void testSetName() {
    week.setName("Week 1");
    assertEquals("Week 1", week.getName());
  }

  @Test
  public void testNumTasks() {
    Task task1 = mock(Task.class);
    Task task2 = mock(Task.class);
    when(task1.getDay()).thenReturn("MONDAY");
    when(task2.getDay()).thenReturn("TUESDAY");
    week.addTask(task1);
    week.addTask(task2);
    assertEquals(2, week.numTasks());
  }

  @Test
  public void testNumEvents() {
    Event event1 = mock(Event.class);
    Event event2 = mock(Event.class);
    when(event1.getDay()).thenReturn("MONDAY");
    when(event2.getDay()).thenReturn("TUESDAY");
    week.addEvent(event1);
    week.addEvent(event2);
    assertEquals(2, week.numEvents());
  }

  @Test
  public void testGetPercentTasksCompleted() {
    Task task1 = mock(Task.class);
    Task task2 = mock(Task.class);
    when(task1.getDay()).thenReturn("MONDAY");
    when(task2.getDay()).thenReturn("TUESDAY");
    when(task1.isComplete()).thenReturn(true);
    when(task2.isComplete()).thenReturn(false);
    week.addTask(task1);
    week.addTask(task2);
    assertEquals(50.0, week.getPercentTasksCompleted());
  }

  @Test
  public void testMaxTasksExceeded() {
    week.setMaximumTasks(2);
    Task task1 = mock(Task.class);
    Task task2 = mock(Task.class);
    Task task3 = mock(Task.class);
    when(task1.getDay()).thenReturn("MONDAY");
    when(task2.getDay()).thenReturn("MONDAY");
    when(task3.getDay()).thenReturn("MONDAY");
    week.addTask(task1);
    week.addTask(task2);

    assertTrue(week.maxTasksExceeded());
    week.addTask(task3);

    assertTrue(week.maxTasksExceeded());
  }

  @Test
  public void testMaxEventsExceeded() {
    week.setMaximumEvents(2);
    Event event1 = mock(Event.class);
    Event event2 = mock(Event.class);
    Event event3 = mock(Event.class);
    when(event1.getDay()).thenReturn("MONDAY");
    when(event2.getDay()).thenReturn("MONDAY");
    when(event3.getDay()).thenReturn("MONDAY");
    week.addEvent(event1);
    week.addEvent(event2);

    assertTrue(week.maxEventsExceeded());
    week.addEvent(event3);

    assertTrue(week.maxEventsExceeded());
  }

  @Test
  public void testToJsonFormat() {
    String json = week.toJsonFormat();
    assertNotNull(json);
    assertTrue(json.contains("maximumTasks"));
  }

  @Test
  public void testUpdateDayWithEvent() {
    Week week = new Week();
    for (Days day : Days.values()) {
      Event event = mock(Event.class);
      when(event.getDay()).thenReturn(day.toString());

      week.addEvent(event);

      switch (day) {
        case MONDAY:
          assertEquals(event, week.getMonday().getEvents().get(0));
          break;
        case TUESDAY:
          assertEquals(event, week.getTuesday().getEvents().get(0));
          break;
        case WEDNESDAY:
          assertEquals(event, week.getWednesday().getEvents().get(0));
          break;
        case THURSDAY:
          assertEquals(event, week.getThursday().getEvents().get(0));
          break;
        case FRIDAY:
          assertEquals(event, week.getFriday().getEvents().get(0));
          break;
        case SATURDAY:
          assertEquals(event, week.getSaturday().getEvents().get(0));
          break;
        case SUNDAY:
          assertEquals(event, week.getSunday().getEvents().get(0));
          break;
        default:
          fail("Unexpected day: " + day);
      }
    }
  }

  @Test
  public void testUpdateDayWithTask() {
    Week week = new Week();
    for (Days day : Days.values()) {
      Task task = mock(Task.class);
      when(task.getDay()).thenReturn(day.toString());

      week.addTask(task);


      switch (day) {
        case MONDAY:
          assertEquals(task, week.getMonday().getTasks().get(0));
          break;
        case TUESDAY:
          assertEquals(task, week.getTuesday().getTasks().get(0));
          break;
        case WEDNESDAY:
          assertEquals(task, week.getWednesday().getTasks().get(0));
          break;
        case THURSDAY:
          assertEquals(task, week.getThursday().getTasks().get(0));
          break;
        case FRIDAY:
          assertEquals(task, week.getFriday().getTasks().get(0));
          break;
        case SATURDAY:
          assertEquals(task, week.getSaturday().getTasks().get(0));
          break;
        case SUNDAY:
          assertEquals(task, week.getSunday().getTasks().get(0));
          break;
        default:
          fail("Unexpected day: " + day);
      }
    }
  }
}


