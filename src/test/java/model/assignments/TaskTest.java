package model.assignments;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

  @Test
  public void testTaskConstructor() {
    // Create a new instance of Task using the no-args constructor
    Task task = new Task();

    // Assert that the 'complete' field is false as expected
    assertFalse(task.isComplete(), "Newly created task should not be complete.");
  }


  @Test
  void testConstructorWithAllFields() {
    assertEquals("Study", task2.getName());
    assertEquals("Monday", task2.getDay());
    assertEquals("Finish chapter 5", task2.getDescription());
    assertEquals("Academics", task2.getCategory());
    assertFalse(task2.isComplete());
  }

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

  @Test
  void testGetCategoryWithExistingCategory() {
    Task task = new Task();
    task.setCategory("Work");
    assertEquals("Work", task.getCategory());
  }

  @Test
  void testGetCategoryWithoutCategory() {
    Task task = new Task();
    assertEquals("No Category Available.", task.getCategory());
  }

  @Test
  void testGetDescriptionWithExistingDescription() {
    Task task = new Task();
    task.setDescription("Write report");
    assertEquals("Write report", task.getDescription());
  }

  @Test
  void testGetDescriptionWithoutDescription() {
    Task task = new Task();
    assertEquals("No Description Available.", task.getDescription());
  }

  @Test
  void testGetCategoryWithEmptyCategory() {
    Task task = new Task();
    task.setCategory("");
    assertEquals("No Category Available.", task.getCategory());
  }

  @Test
  void testGetDescriptionWithEmptyDescription() {
    Task task = new Task();
    task.setDescription("");
    assertEquals("No Description Available.", task.getDescription());
  }
}

