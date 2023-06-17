package cs3500.pa05.model.assignments;

/**
 * Class representing an event for java journal
 */
public class Event extends AbstractAssignment {
  private final String startTime;
  private final String duration;

  /**
   * Constructor for an event with no description or category
   *
   * @param name event name
   * @param day event day
   * @param startTime event start time
   * @param duration event duration
   */
  public Event(String name, String day, String startTime, String duration) {
    this.name = name;
    this.day = day;
    this.startTime = startTime;
    this.duration = duration;
    this.description = "";
    this.category = "";
  }

  /**
   * Constructor for an event with a description
   *
   * @param name event name
   * @param day event day
   * @param startTime event start time
   * @param duration event duration
   * @param description event description
   */
  public Event(String name, String day, String startTime, String duration, String description) {
    this(name, day, startTime, duration);
    this.description = description;
    this.category = "";
  }

  /**
   * gets the start time of this event
   *
   * @return the start time of this event
   */
  public String getStartTime() {
    return this.startTime;
  }

  /**
   * gets the duration of this event
   *
   * @return the duration of this event
   */
  public String getDuration() {
    return this.duration;
  }

  /**
   * returns the event as a json string
   *
   * @return the formatted json string
   */
  @Override
  public String toJsonFormat() {
    StringBuilder jsonBuilder = new StringBuilder();
    jsonBuilder.append("{");
    jsonBuilder.append("\"name\": \"").append(name).append("\",");
    jsonBuilder.append("\"day\": \"").append(day).append("\",");
    jsonBuilder.append("\"start-time\": \"").append(startTime).append("\",");
    jsonBuilder.append("\"duration\": \"").append(duration).append("\",");
    jsonBuilder.append("\"category\": \"").append(category).append("\",");
    jsonBuilder.append("\"description\": \"").append(description).append("\",");
    jsonBuilder.setLength(jsonBuilder.length() - 1);
    jsonBuilder.append("}");
    return jsonBuilder.toString();
  }
}
