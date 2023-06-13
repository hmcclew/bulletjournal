package cs3500.pa05.model.assignments;

public class Event implements Assignment {
  private final String name;
  private final String day;
  private final int startTime;
  private final int duration;
  private String description;
  private String category;

  public Event(String name, String day, int startTime, int duration, String description) {
    this.name = name;
    this.day = day;
    this.startTime = startTime;
    this.duration = duration;
    this.description = description;
  }

  public Event(String name, String day, int startTime, int duration) {
    this.name = name;
    this.day = day;
    this.startTime = startTime;
    this.duration = duration;
  }
  public String toString() {
    return null;
  }

  @Override
  public String toJsonFormat() {
    return null;
  }
}
