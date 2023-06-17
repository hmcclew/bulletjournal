package cs3500.pa05.model.assignments;

/**
 * Represents a task in a java journal week
 */
public class Task extends AbstractAssignment {
  private boolean complete;

  /**
   * Empty Constructor
   */
  public Task() {
    this.complete = false;
  }

  /**
   * constructor for a task with just name and day
   *
   * @param name task name
   * @param day  task day
   */
  public Task(String name, String day) {
    this.name = name;
    this.day = day;
    this.description = "";
    this.category = "";
  }

  /**
   * constructor for a task with all fields
   *
   * @param name        task name
   * @param day         task day
   * @param description task description
   * @param category    task category
   */
  public Task(String name, String day, String description, String category) {
    this(name, day);
    this.description = description;
    this.category = category;
    this.complete = false;
    setCategory(category);
  }

  /**
   * Constructor for a task with no category
   *
   * @param name        task name
   * @param day         task day
   * @param description task description
   */
  public Task(String name, String day, String description) {
    this(name, day);
    this.description = description;
    this.category = "";
    this.complete = false;
  }

  /**
   * marks the task as complete
   */
  public void markAsComplete() {
    this.complete = true;
  }

  /**
   * determines if the task is complete
   *
   * @return whether the task is complete
   */
  public boolean isComplete() {
    return this.complete;
  }
}
