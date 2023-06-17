package cs3500.pa05.model.assignments;

public class Task extends AbstractAssignment {
  private boolean isComplete;

  public Task(String name, String day) {
    this.name = name;
    this.day = day;
  }

  public Task(String name, String day, String description, String category) {
    this(name, day);
    this.description = description;
    this.category = category;
    this.isComplete = false;
    setCategory(category);
  }

  public Task(String name, String day, String description) {
    this(name, day);
    this.description = description;
    this.isComplete = false;
  }

  public void markAsComplete() {
    this.isComplete = true;
  }

  public boolean isComplete() {
    return this.isComplete;
  }

  @Override
  public String toJsonFormat() {
    return null;
  }
}
