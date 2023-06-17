package cs3500.pa05.model.assignments;

public class Event implements Assignment {
  private final String name;
  private final String day;
  private final String startTime;
  private final String duration;
  private String description;
  private String category;

  public Event(String name, String day, String startTime, String duration) {
    this.name = name;
    this.day = day;
    this.startTime = startTime;
    this.duration = duration;
  }

  public Event(String name, String day, String startTime, String duration, String description) {
    this(name, day, startTime, duration);
    this.description = description;
  }

  public Event(String name, String day, String startTime, String duration, String description,
               String category) {
    this(name, day, startTime, duration, description);
    setCategory(category);
  }

  public void setCategory(String category) {
    this.category = category;
  }
  public String toString() {
    return "iohgs";
  }

  public String getDay() {
    return this.day;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toJsonFormat() {
    return null;
  }
}
