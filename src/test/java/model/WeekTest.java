package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import cs3500.pa05.model.Week;
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
  void setUp() {
    week = new Week();
    mockTask = mock(Task.class);
    mockEvent = mock(Event.class);
    mockAssignment = mock(Assignment.class);
  }

  @Test
  void testSetMaximumEvents() {
    week.setMaximumEvents(5);
    assertEquals(5, week.getMaximumEvents());
  }

  @Test
  void testSetMaximumTasks() {
    week.setMaximumTasks(3);
    assertEquals(3, week.getMaximumTasks());
  }

  @Test
  void testAddNoteOrQuote() {
    week.addNoteOrQuote("test note");
    assertEquals(List.of("test note"), week.getQuotesAndNotes());
  }

  @Test
  void testAddEvent() {
    when(mockEvent.getDay()).thenReturn("MONDAY");
    week.addEvent(mockEvent);
    assertEquals(Collections.singletonList(mockEvent), week.getAllEvents());
  }

  @Test
  void testAddTask() {
    when(mockTask.getDay()).thenReturn("MONDAY");
    week.addTask(mockTask);
    assertEquals(Collections.singletonList(mockTask), week.getAllTasks());
  }

  @Test
  void testDetermineDay() {
    when(mockAssignment.getDay()).thenReturn("MONDAY");
    assertEquals(Days.MONDAY, week.determineDay(mockAssignment));
  }

  @Test
  void testGetMaximumEvents() {
    week.setMaximumEvents(5);
    assertEquals(5, week.getMaximumEvents());
  }

  @Test
  void testGetMaximumTasks() {
    week.setMaximumTasks(5);
    assertEquals(5, week.getMaximumTasks());
  }

  @Test
  void testGetQuotesAndNotes() {
    week.addNoteOrQuote(sampleNote);
    assertEquals(Collections.singletonList(sampleNote), week.getQuotesAndNotes());
  }

  @Test
  void testGetCategories() {
    week.addCategory(sampleCategory);
    assertEquals(Collections.singletonList(sampleCategory), week.getCategories());
  }

  @Test
  void testAddCategory() {
    week.addCategory(sampleCategory);
    assertTrue(week.getCategories().contains(sampleCategory));
  }

  @Test
  void testSetName() {
    week.setName("Week 1");
    assertEquals("Week 1", week.getName());
  }

  @Test
  void testNumTasks() {
    Task task1 = mock(Task.class);
    Task task2 = mock(Task.class);
    when(task1.getDay()).thenReturn("MONDAY");
    when(task2.getDay()).thenReturn("TUESDAY");
    week.addTask(task1);
    week.addTask(task2);
    assertEquals(2, week.numTasks());
  }

  @Test
  void testNumEvents() {
    Event event1 = mock(Event.class);
    Event event2 = mock(Event.class);
    when(event1.getDay()).thenReturn("MONDAY");
    when(event2.getDay()).thenReturn("TUESDAY");
    week.addEvent(event1);
    week.addEvent(event2);
    assertEquals(2, week.numEvents());
  }

  @Test
  void testGetPercentTasksCompleted() {
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
  void testMaxTasksExceeded() {
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
  void testMaxEventsExceeded() {
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
  void testToJsonFormat() {
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


