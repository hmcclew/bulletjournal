package cs3500.pa05.model.assignments;

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
    Task task = new Task();

    assertFalse(task.isComplete());
  }


  @Test
  public void testConstructorWithAllFields() {
    assertEquals("Study", task2.getName());
    assertEquals("Monday", task2.getDay());
    assertEquals("Finish chapter 5", task2.getDescription());
    assertEquals("Academics", task2.getCategory());
    assertFalse(task2.isComplete());
  }

  @Test
  public void testMarkAsComplete() {
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
  public void testMarkAsIncomplete() {
    assertFalse(task1.isComplete());
    task1.markAsComplete();
    assertTrue(task1.isComplete());

    task1.markAsIncomplete();
    assertFalse(task1.isComplete());
  }

  @Test
  public void testGetCategoryWithExistingCategory() {
    Task task = new Task();
    task.setCategory("Work");
    assertEquals("Work", task.getCategory());
  }

  @Test
  public void testGetCategoryWithoutCategory() {
    Task task = new Task();
    assertEquals("No Category Available.", task.getCategory());
  }

  @Test
  public void testGetDescriptionWithExistingDescription() {
    Task task = new Task();
    task.setDescription("Write report");
    assertEquals("Write report", task.getDescription());
  }

  @Test
  public void testGetDescriptionWithoutDescription() {
    Task task = new Task();
    assertEquals("No Description Available.", task.getDescription());
  }

  @Test
  public void testGetCategoryWithEmptyCategory() {
    Task task = new Task();
    task.setCategory("");
    assertEquals("No Category Available.", task.getCategory());
  }

  @Test
  public void testGetDescriptionWithEmptyDescription() {
    Task task = new Task();
    task.setDescription("");
    assertEquals("No Description Available.", task.getDescription());
  }

  @Test
  public void testSetNameAndDay() {
    Task task = new Task();
    task.setName("TestName2");
    assertEquals("TestName2", task.getName());
    task.setDay("Wednesday");
    assertEquals("Wednesday", task.getDay());
  }
}

