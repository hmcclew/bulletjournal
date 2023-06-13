package cs3500.pa05.model.assignments;

public class Task implements Assignment {

  private final String name;
  private final String day;
  private String description;
  private boolean isComplete;
  private String category;

  public Task(String name, String day, String description) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.isComplete = false;
  }

  public Task(String name, String day) {
    this.name = name;
    this.day = day;
    this.isComplete = false;
  }

  public void markAsComplete() {
    this.isComplete = true;
  }

  public String toString() {
    return null;
  }

  @Override
  public String toJsonFormat() {
    return null;
  }
}
