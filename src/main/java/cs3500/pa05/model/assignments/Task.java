package cs3500.pa05.model.assignments;

public class Task implements Assignment {

  private final String name;
  private final String day;
  private String description;
  private boolean isComplete;
  private String category;

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

  public void setCategory(String category) {
    this.category = category;
  }

  public void markAsComplete() {
    this.isComplete = true;
  }

  public String toString() {
    return null;
  }

  @Override
  public String getDay() {
    return this.day;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public String getCategory() {
    return this.category;
  }

  public boolean isComplete() {
    return this.isComplete;
  }

  @Override
  public String toJsonFormat() {
    return null;
  }
}
