package cs3500.pa05.model.assignments;

/**
 * Represents a task in a java journal week
 */
public class Task extends AbstractAssignment {
  private boolean isComplete;

  /**
   * constructor for a task with just name and day
   *
   * @param name task name
   * @param day task day
   */
  public Task(String name, String day) {
    this.name = name;
    this.day = day;
  }

  /**
   * constructor for a task with all fields
   *
   * @param name task name
   * @param day task day
   * @param description task description
   * @param category task category
   */
  public Task(String name, String day, String description, String category) {
    this(name, day);
    this.description = description;
    this.category = category;
    this.isComplete = false;
    setCategory(category);
  }

  /**
   * Constructor for a task with no category
   *
   * @param name task name
   * @param day task day
   * @param description task description
   */
  public Task(String name, String day, String description) {
    this(name, day);
    this.description = description;
    this.isComplete = false;
  }

  /**
   * marks the task as complete
   */
  public void markAsComplete() {
    this.isComplete = true;
  }

  /**
   * determines if the task is complete
   *
   * @return whether the task is complete
   */
  public boolean isComplete() {
    return this.isComplete;
  }

  /**
   * the json formatted string of this class
   *
   * @return the json formatted string
   */
  @Override
  public String toJsonFormat() {
    return null;
  }
}
