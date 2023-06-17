package model;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Assignment;
import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.Days;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

//    @Test
//    void testGetAllTasks() {
//        week.addTask(mockTask);
//        assertEquals(Collections.singletonList(mockTask), week.getAllTasks());
//    }
//
//    @Test
//    void testGetPercentTasksCompleted() {
//        when(mockTask.isComplete()).thenReturn(true);
//        week.addTask(mockTask);
//        assertEquals(100.0, week.getPercentTasksCompleted());
//    }

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

//    @Test
//    void testNumEvents() {
//        week.addEvent(mockEvent);
//        assertEquals(1, week.numEvents());
//    }
//
//    @Test
//    void testNumTasks() {
//        week.addTask(mockTask);
//        assertEquals(1, week.numTasks());
//    }

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

//    @Test
//    void testToJsonFormat() {
//        week.setName("Week 1");
//        week.setMaximumEvents(5);
//        week.setMaximumTasks(5);
//        week.addCategory(sampleCategory);
//        week.addNoteOrQuote(sampleNote);
//        week.addEvent(mockEvent);
//        week.addTask(mockTask);
//
//        String json = week.toJsonFormat();
//
//        assertNotNull(json);  // Ensure the JSON string isn't null
//        assertTrue(json.startsWith("{"));
//        assertTrue(json.endsWith("}"));

    // Add additional assertions based on your specific JSON format expectations
}


