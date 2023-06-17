package model.assignments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.assignments.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
    private Task task1;
    private Task task2;
    private Task task3;

    @BeforeEach
    void setUp() {
        task1 = new Task("Shopping", "Tuesday");
        task2 = new Task("Study", "Monday", "Finish chapter 5", "Academics");
        task3 = new Task("Workout", "Friday", "Gym at 6 PM");
    }

//    @Test
//    void testConstructorWithoutDescriptionAndCategory() {
//        assertEquals("Shopping", task1.getName());
//        assertEquals("Tuesday", task1.getDay());
//        assertNull(task1.getDescription());
//        assertNull(task1.getCategory());
//        assertFalse(task1.isComplete());
//    }

    @Test
    void testConstructorWithAllFields() {
        assertEquals("Study", task2.getName());
        assertEquals("Monday", task2.getDay());
        assertEquals("Finish chapter 5", task2.getDescription());
        assertEquals("Academics", task2.getCategory());
        assertFalse(task2.isComplete());
    }

//    @Test
//    void testConstructorWithoutCategory() {
//        assertEquals("Workout", task3.getName());
//        assertEquals("Friday", task3.getDay());
//        assertEquals("Gym at 6 PM", task3.getDescription());
//        assertNull(task3.getCategory());
//        assertFalse(task3.isComplete());
//    }

    @Test
    void testMarkAsComplete() {
        assertFalse(task1.isComplete());
        task1.markAsComplete();
        assertTrue(task1.isComplete());

        assertFalse(task2.isComplete());
        task2.markAsComplete();
        assertTrue(task2.isComplete());

        assertFalse(task3.isComplete());
        task3.markAsComplete();
        assertTrue(task3.isComplete());
    }
}

