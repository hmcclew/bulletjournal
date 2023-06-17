package cs3500.pa05.model.day;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * abstract class for a day in java journal
 */
public abstract class AbstractDay implements Day {

  /**
   * List of all events for the day
   */
  protected List<Event> events;

  /**
   * List of all tasks for the day
   */
  protected List<Task> tasks;

  /**
   * Constructor for an abstract day
   */
  public AbstractDay() {
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
  }

  /**
   * getter method for the tasks of day
   *
   * @return all tasks for the day
   */
  public List<Task> getTasks() {
    return this.tasks;
  }

  /**
   * getter method for the events of day
   *
   * @return all events for the day
   */
  public List<Event> getEvents() {
    return this.events;
  }

  /**
   * adds an event to this day's events
   *
   * @param e the event to be added
   */
  public void addEvent(Event e) {
    events.add(e);
  }

  /**
   * adds a task to this day's tasks
   *
   * @param t the task to be added
   */
  public void addTask(Task t) {
    tasks.add(t);
  }

  /**
   * the json formatted string of this class
   *
   * @return the json formatted string
   */
  public String toJsonFormat() {
    StringBuilder jsonBuilder = new StringBuilder();
    jsonBuilder.append("{");
    jsonBuilder.append("\"events\": [");
    for (Event event : events) {
      jsonBuilder.append(event.toJsonFormat()).append(",");
    }
    if (!events.isEmpty()) {
      jsonBuilder.setLength(jsonBuilder.length() - 1);
    }
    jsonBuilder.append("],");
    jsonBuilder.append("\"tasks\": [");
    for (Task task : tasks) {
      jsonBuilder.append(task.toJsonFormat()).append(",");
    }
    if (!tasks.isEmpty()) {
      jsonBuilder.setLength(jsonBuilder.length() - 1);
    }
    jsonBuilder.append("]");
    jsonBuilder.append("}");
    return jsonBuilder.toString();
  }
}
