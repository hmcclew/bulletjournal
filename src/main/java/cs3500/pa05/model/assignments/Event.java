package cs3500.pa05.model.assignments;

public class Event extends AbstractAssignment {
  private final String startTime;
  private final String duration;

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

  public String getStartTime() {
    return this.startTime;
  }

  public String getDuration() {
    return this.duration;
  }

  @Override
  public String toJsonFormat() {
    return null;
  }
}
