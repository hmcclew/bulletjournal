package cs3500.pa05.model.assignments;

/**
 * Class representing an event for java journal
 */
public class Event extends AbstractAssignment {
  private String startTime;
  private String duration;

  /**
   * Empty Constructor
   */
  public Event() {
    this.startTime = "";
    this.duration = "";
  }

  /**
   * Constructor for an event with no description or category
   *
   * @param name      event name
   * @param day       event day
   * @param startTime event start time
   * @param duration  event duration
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
   * @param name        event name
   * @param day         event day
   * @param startTime   event start time
   * @param duration    event duration
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
   * sets the start time of the event
   *
   * @param startTime the start time of the event
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  /**
   * sets the duration of the event
   *
   * @param duration the duration to be set
   */
  public void setDuration(String duration) {
    this.duration = duration;
  }

  /**
   * gets the duration of this event
   *
   * @return the duration of this event
   */
  public String getDuration() {
    return this.duration;
  }
}
